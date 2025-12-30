package hospital.system;

public class Doctor implements IReportable {
    private String name;
    private String specialty;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getReportString() {
        return "Doctor: " + name + ", Specialty: " + specialty;
    }
}