package hospital.system;


public class Patient {
    private String name;
    private int age;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Patient: " + name + ", Age: " + age);
    }

    public String getName() {
        return name;
    }
}
