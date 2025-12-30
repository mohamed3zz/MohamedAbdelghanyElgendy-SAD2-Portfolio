package hospital.system;

import java.util.ArrayList;

public class Nurse {
    private String name;
    private int experienceYears;
    private ArrayList<String> patientNotes = new ArrayList<>();

    public Nurse(String name, int experienceYears) {
        this.name = name;
        this.experienceYears = experienceYears;
    }

    public void addNote(String note) {
        patientNotes.add(note);
    }

    public void showNotes() {
        System.out.println("Follow-up notes by Nurse " + name + ":");
        if (patientNotes.isEmpty()) {
            System.out.println("No notes recorded.");
        } else {
            for (String n : patientNotes) {
                System.out.println("- " + n);
            }
        }
    }

    public void displayInfo() {
        System.out.println("Nurse: " + name + ", Experience: " + experienceYears + " years");
    }

    public String getName() {
        return name;
    }
}