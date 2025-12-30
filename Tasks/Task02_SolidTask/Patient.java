package hospital.system;

public class Patient implements IReportable {
    private String name;
    private int age;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getReportString() {
        return "Patient: " + name + ", Age: " + age;
    }
}