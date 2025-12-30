
package hospital.system;

import java.util.ArrayList;
import java.util.Scanner;

public class HospitalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<Patient> patients = new ArrayList<>();
        ArrayList<Nurse> nurses = new ArrayList<>();
        ArrayList<Appointment> appointments = new ArrayList<>();
        ArrayList<Prescription> prescriptions = new ArrayList<>();

        while (true) {
            System.out.println(" MENU :");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Patient");
            System.out.println("3. Add Nurse");
            System.out.println("4. Add Appointment");
            System.out.println("5. Add Prescription");
            System.out.println("6. Nurse Follow-up for Patient");
            System.out.println("7. Show Nurse Notes");
            System.out.println("8. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Doctor Name: ");
                    String dName = sc.nextLine();
                    System.out.print("Specialty: ");
                    String sp = sc.nextLine();
                    doctors.add(new Doctor(dName, sp));
                    break;

                case 2:
                    System.out.print("Patient Name: ");
                    String pName = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    patients.add(new Patient(pName, age));
                    break;

                case 3:
                    System.out.print("Nurse Name: ");
                    String nName = sc.nextLine();
                    System.out.print("Experience (years): ");
                    int exp = sc.nextInt();
                    sc.nextLine();
                    nurses.add(new Nurse(nName, exp));
                    break;

                case 4: 
                    if (doctors.isEmpty() || patients.isEmpty()) {
                        System.out.println("Add doctors and patients first!");
                        break;
                    }
                    System.out.println("Select Doctor:");
                    for (int i = 0; i < doctors.size(); i++)
                        System.out.println(i + " - " + doctors.get(i).getName());
                    int dIndex = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Select Patient:");
                    for (int i = 0; i < patients.size(); i++)
                        System.out.println(i + " - " + patients.get(i).getName());
                    int pIndex = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Date: ");
                    String date = sc.nextLine();

                    appointments.add(new Appointment(doctors.get(dIndex), patients.get(pIndex), date));
                    break;

                case 5: 
                    if (doctors.isEmpty() || patients.isEmpty()) {
                        System.out.println("Add doctors and patients first!");
                        break;
                    }
                    System.out.println("Select Doctor:");
                    for (int i = 0; i < doctors.size(); i++)
                        System.out.println(i + " - " + doctors.get(i).getName());
                    int docIndex = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Select Patient:");
                    for (int i = 0; i < patients.size(); i++)
                        System.out.println(i + " - " + patients.get(i).getName());
                    int patIndex = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Medicine: ");
                    String med = sc.nextLine();
                    System.out.print("Dosage: ");
                    String dose = sc.nextLine();

                    prescriptions.add(new Prescription(doctors.get(docIndex), patients.get(patIndex), med, dose));
                    break;

                case 6:
                    if (nurses.isEmpty() || patients.isEmpty()) {
                        System.out.println("Add nurses and patients first!");
                        break;
                    }

                    System.out.println("Select Nurse:");
                    for (int i = 0; i < nurses.size(); i++)
                        System.out.println(i + " - " + nurses.get(i).getName());
                    int nurseIndex = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Select Patient:");
                    for (int i = 0; i < patients.size(); i++)
                        System.out.println(i + " - " + patients.get(i).getName());
                    sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter follow-up note: ");
                    String note = sc.nextLine();

                    nurses.get(nurseIndex).addNote(note);
                    System.out.println("Note added!");
                    break;

                case 7:
                    if (nurses.isEmpty()) {
                        System.out.println("No nurses found!");
                        break;
                    }

                    System.out.println("Select Nurse:");
                    for (int i = 0; i < nurses.size(); i++)
                        System.out.println(i + " - " + nurses.get(i).getName());
                    int nIndex = sc.nextInt();
                    sc.nextLine();

                    nurses.get(nIndex).showNotes();
                    break;

                case 8:
                    System.out.println("Exiting.");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
