package hospital.system;

import java.util.ArrayList;
import java.util.List;

public class NurseFollowUp {
    private Nurse nurse;
    private Patient patient;
    private List<String> notes = new ArrayList<>();

    public NurseFollowUp(Nurse nurse, Patient patient) {
        this.nurse = nurse;
        this.patient = patient;
    }

    public void addNote(String note) {
        notes.add(note);
    }
    
    public List<String> getNotes() {
        return notes;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public Patient getPatient() {
        return patient;
    }
}