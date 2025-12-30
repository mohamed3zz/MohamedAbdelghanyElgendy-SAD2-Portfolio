package hospital.system;

public class Doctor {
    private String name;
    private String specialty;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public void displayInfo() {
        System.out.println("Doctor: " + name + ", Specialty: " + specialty);
    }

    public String getName() {
        return name;
    }
}

