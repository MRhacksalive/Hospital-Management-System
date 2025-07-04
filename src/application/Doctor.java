package application;
public class Doctor {
    private String name;
    private String specialty;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public String toString() {
        return "Doctor Name: " + name + ", Specialty: " + specialty;
    }
}
