package hospital.system;

import java.util.ArrayList;
import java.util.List;

public class HospitalManager {
    
    private final List<Doctor> doctors = new ArrayList<>();
    private final List<Patient> patients = new ArrayList<>();
    private final List<Nurse> nurses = new ArrayList<>();
    private final List<Appointment> appointments = new ArrayList<>();
    private final List<Prescription> prescriptions = new ArrayList<>();
    private final List<NurseFollowUp> followUps = new ArrayList<>(); // لتخزين المتابعات

    public void addDoctor(Doctor doctor) { doctors.add(doctor); }
    public void addPatient(Patient patient) { patients.add(patient); }
    public void addNurse(Nurse nurse) { nurses.add(nurse); }
    public void addAppointment(Appointment appointment) { appointments.add(appointment); }
    public void addPrescription(Prescription prescription) { prescriptions.add(prescription); }
    public void addFollowUp(NurseFollowUp followUp) { followUps.add(followUp); }

    public List<Doctor> getDoctors() { return doctors; }
    public List<Patient> getPatients() { return patients; }
    public List<Nurse> getNurses() { return nurses; }
    public List<NurseFollowUp> getFollowUps() { return followUps; }
    
    public List<NurseFollowUp> getNurseFollowUps(Nurse nurse) {
        List<NurseFollowUp> result = new ArrayList<>();
        for (NurseFollowUp fu : followUps) {
            if (fu.getNurse().equals(nurse)) {
                result.add(fu);
            }
        }
        return result;
    }
}