package hospital.system;

import java.util.List; 
import hospital.system.Nurse; 
import hospital.system.NurseFollowUp; 
import hospital.system.IReportable; 

public class ReportGenerator {

    public static void print(IReportable item) {
        System.out.println("\n==================================");
        System.out.println("Generated Report:");
        System.out.println(item.getReportString()); 
        System.out.println("==================================\n");
    }
    
    public static void printNotes(Nurse nurse, List<NurseFollowUp> followUps) {
        System.out.println("\n--- Follow-up notes by Nurse " + nurse.getName() + " ---");
        if (followUps.isEmpty()) {
             System.out.println("No notes recorded.");
             return;
        }
        for (NurseFollowUp fu : followUps) {
            System.out.println("Notes for Patient " + fu.getPatient().getName() + ":");
            for (String note : fu.getNotes()) {
                System.out.println("  - " + note);
            }
        }
    }
}