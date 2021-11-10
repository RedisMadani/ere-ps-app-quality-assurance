package health.ere.ps.service.connector.provider;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Base64;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.enterprise.event.Event;

import health.ere.ps.config.UserConfig;
import health.ere.ps.service.common.security.SecretsManagerService;
import health.ere.ps.service.connector.endpoint.EndpointDiscoveryService;

public class SingleConnectorServicesProvider extends AbstractConnectorServicesProvider {
    private final static Logger log = Logger.getLogger(SingleConnectorServicesProvider.class.getName());

    UserConfig userConfig;

    public SingleConnectorServicesProvider(UserConfig userConfig, Event<Exception> exceptionEvent) {
        this.userConfig = userConfig;
        this.secretsManagerService = new SecretsManagerService();
        if(userConfig.getConfigurations().getClientCertificate() != null && !userConfig.getConfigurations().getClientCertificate().isEmpty()) {
            
            String clientCertificateString = userConfig.getConfigurations().getClientCertificate().substring(33);
            byte[] clientCertificateBytes = Base64.getDecoder().decode(clientCertificateString);
            
            // byte[] clientCertificateBytes = getCertificateFromUriString(userConfig.getConfigurations().getClientCertificate(), userConfig.getConfigurations().getClientCertificatePassword());
            try (ByteArrayInputStream certificateInputStream = new ByteArrayInputStream(clientCertificateBytes)) {
                this.secretsManagerService.setUpSSLContext(userConfig.getConfigurations().getClientCertificatePassword(), certificateInputStream);
            } catch (NoSuchAlgorithmException | KeyStoreException | CertificateException | IOException
            | UnrecoverableKeyException | KeyManagementException e) {
                log.severe("There was a problem when creating the SSLContext:");
                e.printStackTrace();
                exceptionEvent.fireAsync(e);
            }
        }
        this.endpointDiscoveryService = new EndpointDiscoveryService(userConfig, secretsManagerService);

        initializeServices();
    }

    public static byte[] getKeyFromKeyStoreUriString(String keystoreUri, String keystorePassword) throws URISyntaxException, KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        KeyStore store = KeyStore.getInstance("pkcs12");
        Certificate certificate;
        byte[] key = null;

        URI uriParser = new URI(keystoreUri);
        String scheme = uriParser.getScheme();

        if (scheme.equalsIgnoreCase("data")){
            // example: "data:application/x-pkcs12;base64,MIACAQMwgAY...gtc/qoCAwGQAAAA"
            String[] schemeSpecificParts = uriParser.getSchemeSpecificPart().split(";");
            String contentType = schemeSpecificParts[0];
            if (contentType.equalsIgnoreCase("application/x-pkcs12")){
                String[] dataParts = schemeSpecificParts[1].split(",");
                String encodingType = dataParts[0];
                if (encodingType.equalsIgnoreCase("base64")){
                    String keystoreBase64 = dataParts[1];
                    ByteArrayInputStream keystoreInputStream = new ByteArrayInputStream(Base64.getDecoder().decode(keystoreBase64));
                    store.load(keystoreInputStream, keystorePassword.toCharArray());
                    certificate = store.getCertificate(store.aliases().nextElement());
                    key = certificate.getEncoded();
                }
            }
        } else if (scheme.equalsIgnoreCase("file")) {
            String keyAlias = null;
            String keystoreFile = uriParser.getPath();
            String query = uriParser.getRawQuery();
            try {
                String[] queryParts = query.split("=");
                String parameterName = queryParts[0];
                String parameterValue = queryParts[1];
                if (parameterName.equalsIgnoreCase("alias")){
                    // example: "src/test/resources/certs/keystore.p12?alias=key2"
                    keyAlias = parameterValue;
                }
            } catch (NullPointerException|PatternSyntaxException e){
                // example: "src/test/resources/certs/keystore.p12"
            }
            FileInputStream in = new FileInputStream(keystoreFile);
            store.load(in, keystorePassword.toCharArray());
            if (keyAlias == null){
                certificate = store.getCertificate(store.aliases().nextElement());
            } else {
                certificate = store.getCertificate(keyAlias);
            }
            key = certificate.getEncoded();
        }
        return key;
    }

    public UserConfig getUserConfig() {
        return userConfig;
    }
}
