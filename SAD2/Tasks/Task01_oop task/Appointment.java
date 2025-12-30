package hospital.system;

public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String date;

    public Appointment(Doctor doctor, Patient patient, String date) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    public void showAppointment() {
        System.out.println("Appointment on " + date + ":");
        doctor.displayInfo();
        patient.displayInfo();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }
}
