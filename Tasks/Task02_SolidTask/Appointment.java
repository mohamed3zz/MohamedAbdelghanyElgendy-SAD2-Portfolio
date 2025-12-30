package hospital.system;

public class Appointment implements IReportable {
    private Doctor doctor;
    private Patient patient;
    private String date;

    public Appointment(Doctor doctor, Patient patient, String date) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }
    
    @Override
    public String getReportString() {
        return String.format(
            "Appointment on %s:\n\t- %s\n\t- %s", 
            date, 
            doctor.getReportString(), 
            patient.getReportString()
        );
    }
}