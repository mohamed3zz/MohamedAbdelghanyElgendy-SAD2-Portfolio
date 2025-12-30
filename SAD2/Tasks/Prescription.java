package hospital.system;

public class Prescription {
    private Doctor doctor;
    private Patient patient;
    private String medicine;
    private String dosage;

    public Prescription(Doctor doctor, Patient patient, String medicine, String dosage) {
        this.doctor = doctor;
        this.patient = patient;
        this.medicine = medicine;
        this.dosage = dosage;
    }

    public void showPrescription() {
        System.out.println("Prescription:");
        doctor.displayInfo();
        patient.displayInfo();
        System.out.println("Medicine: " + medicine + ", Dosage: " + dosage);
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }
}
