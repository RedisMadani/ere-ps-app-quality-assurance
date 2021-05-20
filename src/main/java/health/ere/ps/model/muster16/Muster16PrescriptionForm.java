package health.ere.ps.model.muster16;

import java.util.List;

public class Muster16PrescriptionForm {
    private String insuranceCompany;
    private String insuranceCompanyId;
    private String patientFirstName;
    private String patientLastName;
    private String patientStreetName;
    private String patientStreetNumber;
    private String patientCity;
    private String patientZipCode;
    private String patientInsuranceId;
    private String patientDateOfBirth;
    private String clinicId;
    private String doctorId;
    private String prescriptionDate;
    private String doctorFirstName;
    private String doctorLastName;
    private String doctorStreetName;
    private String doctorStreetNumber;
    private String doctorCity;
    private String doctorZipCode;
    private String doctorNamePrefix;
    private String doctorBSNR;
    private String doctorPhone;

    private List<MedicationString> prescriptionList;

    public Muster16PrescriptionForm(String insuranceCompany,
            String insuranceCompanyId,
            String patientFirstName,
            String patientLastName,
            String patientStreetName,
            String patientStreetNumber,
            String patientCity,
            String patientZipCode,
            String patientInsuranceId,
            String patientDateOfBirth,
            String clinicId,
            String doctorId,
            String prescriptionDate,
            List<MedicationString> prescriptionList) {
        this.insuranceCompany = insuranceCompany;
        this.insuranceCompanyId = insuranceCompanyId;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientStreetName = patientStreetName;
        this.patientStreetNumber = patientStreetNumber;
        this.patientCity = patientCity;
        this.patientZipCode = patientZipCode;
        this.setPatientInsuranceId(patientInsuranceId);
        this.patientDateOfBirth = patientDateOfBirth;
        this.clinicId = clinicId;
        this.doctorId = doctorId;
        this.prescriptionDate = prescriptionDate;
        this.prescriptionList = prescriptionList;
    }

    public Muster16PrescriptionForm() {

    }

    public String getDoctorBSNR() {
        return this.doctorBSNR;
    }

    public void setDoctorBSNR(String doctorBSNR) {
        this.doctorBSNR = doctorBSNR;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getInsuranceCompanyId() {
        return insuranceCompanyId;
    }

    public void setInsuranceCompanyId(String insuranceCompanyId) {
        this.insuranceCompanyId = insuranceCompanyId;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getPatientStreetName() {
        return patientStreetName;
    }

    public void setPatientStreetName(String patientStreetName) {
        this.patientStreetName = patientStreetName;
    }

    public String getPatientStreetNumber() {
        return patientStreetNumber;
    }

    public void setPatientStreetNumber(String patientStreetNumber) {
        this.patientStreetNumber = patientStreetNumber;
    }

    public String getPatientCity() {
        return patientCity;
    }

    public void setPatientCity(String patientCity) {
        this.patientCity = patientCity;
    }

    public String getPatientZipCode() {
        return patientZipCode;
    }

    public void setPatientZipCode(String patientZipCode) {
        this.patientZipCode = patientZipCode;
    }

    public String getPatientDateOfBirth() {
        return patientDateOfBirth;
    }

    public void setPatientDateOfBirth(String patientDateOfBirth) {
        this.patientDateOfBirth = patientDateOfBirth.trim();
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(String prescriptionDate) {
        this.prescriptionDate = prescriptionDate.trim();
    }

    public List<MedicationString> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(List<MedicationString> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }

    public String getPatientInsuranceId() {
        return patientInsuranceId;
    }

    public void setPatientInsuranceId(String patientInsuranceId) {
        this.patientInsuranceId = patientInsuranceId;
    }

    public String getDoctorFirstName() {
        return this.doctorFirstName;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public String getDoctorLastName() {
        return this.doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public String getDoctorStreetName() {
        return this.doctorStreetName;
    }

    public void setDoctorStreetName(String doctorStreetName) {
        this.doctorStreetName = doctorStreetName;
    }

    public String getDoctorStreetNumber() {
        return this.doctorStreetNumber;
    }

    public void setDoctorStreetNumber(String doctorStreetNumber) {
        this.doctorStreetNumber = doctorStreetNumber;
    }

    public String getDoctorCity() {
        return this.doctorCity;
    }

    public void setDoctorCity(String doctorCity) {
        this.doctorCity = doctorCity;
    }

    public String getDoctorZipCode() {
        return this.doctorZipCode;
    }

    public void setDoctorZipCode(String doctorZipCode) {
        this.doctorZipCode = doctorZipCode;
    }

    public String getDoctorNamePrefix() {
        return this.doctorNamePrefix;
    }

    public void setDoctorNamePrefix(String doctorNamePrefix) {
        this.doctorNamePrefix = doctorNamePrefix;
    }

    public String getDoctorPhone() {
        return this.doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }
}
