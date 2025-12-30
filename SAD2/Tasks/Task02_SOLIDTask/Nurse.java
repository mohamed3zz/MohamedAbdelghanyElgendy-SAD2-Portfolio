package hospital.system;

public class Nurse implements IReportable {
    private String name;
    private int experienceYears;
    

    public Nurse(String name, int experienceYears) {
        this.name = name;
        this.experienceYears = experienceYears;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String getReportString() {
        return "Nurse: " + name + ", Experience: " + experienceYears + " years";
    }
}