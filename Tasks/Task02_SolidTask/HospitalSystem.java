package hospital.system;

import java.util.List;
import java.util.Scanner;

public class HospitalSystem {
    
    private static HospitalManager manager = new HospitalManager();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        manager.addDoctor(new Doctor("Dr. Ahmed", "Cardiology"));
        manager.addPatient(new Patient("Khaled", 35));
        manager.addNurse(new Nurse("Sara", 5));
        
        while (true) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addDoctorAction(); break;
                case 2: addPatientAction(); break;
                case 3: addNurseAction(); break;
                case 4: addAppointmentAction(); break;
                case 5: addPrescriptionAction(); break;
                case 6: nurseFollowUpAction(); break;
                case 7: showNurseNotesAction(); break;
                case 8: System.out.println("Exiting."); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Menu :");
        System.out.println("1=> Add Doctor");
        System.out.println("2=> Add Patient");
        System.out.println("3=> Add Nurse");
        System.out.println("4=> Add Appointment");
        System.out.println("5=> Add Prescription");
        System.out.println("6=> Nurse Follow-up for Patient");
        System.out.println("7=> Show Nurse Notes");
        System.out.println("8=> Exit");
        System.out.print("Choose: ");
    }
    
    
    private static void addDoctorAction() {
        System.out.print("Doctor Name: ");
        String dName = sc.nextLine();
        System.out.print("Specialty: ");
        String sp = sc.nextLine();
        Doctor newDoctor = new Doctor(dName, sp);
        manager.addDoctor(newDoctor);
        ReportGenerator.print(newDoctor); // استخدام ReportGenerator لضمان OCP
    }
    
    private static void addPatientAction() {
        System.out.print("Patient Name: ");
        String pName = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        Patient newPatient = new Patient(pName, age);
        manager.addPatient(newPatient);
        ReportGenerator.print(newPatient);
    }
    
    private static void addNurseAction() {
        System.out.print("Nurse Name: ");
        String nName = sc.nextLine();
        System.out.print("Experience (years): ");
        int exp = sc.nextInt();
        sc.nextLine();
        Nurse newNurse = new Nurse(nName, exp);
        manager.addNurse(newNurse);
        ReportGenerator.print(newNurse);
    }

    private static void addAppointmentAction() {
        List<Doctor> doctors = manager.getDoctors();
        List<Patient> patients = manager.getPatients();
        
        if (doctors.isEmpty() || patients.isEmpty()) {
            System.out.println("Add doctors and patients first!");
            return;
        }
        
        int dIndex = selectEntity(doctors, "Doctor");
        int pIndex = selectEntity(patients, "Patient");
        
        System.out.print("Date: ");
        String date = sc.nextLine();

        Appointment newAppointment = new Appointment(doctors.get(dIndex), patients.get(pIndex), date);
        manager.addAppointment(newAppointment);
        ReportGenerator.print(newAppointment);
    }
    
    private static void addPrescriptionAction() {
        List<Doctor> doctors = manager.getDoctors();
        List<Patient> patients = manager.getPatients();
        
        if (doctors.isEmpty() || patients.isEmpty()) {
            System.out.println("Add doctors and patients first!");
            return;
        }

        int docIndex = selectEntity(doctors, "Doctor");
        int patIndex = selectEntity(patients, "Patient");
        
        System.out.print("Medicine: ");
        String med = sc.nextLine();
        System.out.print("Dosage: ");
        String dose = sc.nextLine();

        Prescription newPrescription = new Prescription(doctors.get(docIndex), patients.get(patIndex), med, dose);
        manager.addPrescription(newPrescription);
        ReportGenerator.print(newPrescription);
    }

    private static void nurseFollowUpAction() {
        List<Nurse> nurses = manager.getNurses();
        List<Patient> patients = manager.getPatients();
        
        if (nurses.isEmpty() || patients.isEmpty()) {
            System.out.println("Add nurses and patients first!");
            return;
        }

        int nurseIndex = selectEntity(nurses, "Nurse");
        int patientIndex = selectEntity(patients, "Patient");
        
        Nurse selectedNurse = nurses.get(nurseIndex);
        Patient selectedPatient = patients.get(patientIndex);
        
        System.out.print("Enter follow-up note: ");
        String note = sc.nextLine();
        
        NurseFollowUp followUp = new NurseFollowUp(selectedNurse, selectedPatient);
        followUp.addNote(note);
        manager.addFollowUp(followUp);
        
        System.out.println("Note added!");
    }
    
    private static void showNurseNotesAction() {
        List<Nurse> nurses = manager.getNurses();
        
        if (nurses.isEmpty()) {
            System.out.println("No nurses found!");
            return;
        }

        int nurseIndex = selectEntity(nurses, "Nurse");
        Nurse selectedNurse = nurses.get(nurseIndex);
        
        List<NurseFollowUp> notes = manager.getNurseFollowUps(selectedNurse);
        
        ReportGenerator.printNotes(selectedNurse, notes);
    }

    private static <T extends IReportable> int selectEntity(List<T> list, String entityName) {
        System.out.println("Select " + entityName + ":");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " - " + list.get(i).getReportString().split(":")[1].trim().split(",")[0].trim()); 
        }
        int index = sc.nextInt();
        sc.nextLine();
        return index;
    }
}