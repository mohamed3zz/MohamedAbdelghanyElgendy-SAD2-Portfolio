package hospital.system;

public class Prescription implements IReportable {
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

    @Override
    public String getReportString() {
        return String.format(
            "Prescription Details:\n\t- %s\n\t- %s\n\t- Medicine: %s, Dosage: %s",
            doctor.getReportString(),
            patient.getReportString(),
            medicine,
            dosage
        );
    }
}