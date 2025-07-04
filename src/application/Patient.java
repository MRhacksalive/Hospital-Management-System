package application;
public class Patient {
    private String name;
    private String medicalHistory;
    private String ongoingTreatments;
    private String allergies;
    private String emergencyContact;

    public Patient(String name, String medicalHistory, String ongoingTreatments, String allergies, String emergencyContact) {
        this.name = name;
        this.medicalHistory = medicalHistory;
        this.ongoingTreatments = ongoingTreatments;
        this.allergies = allergies;
        this.emergencyContact = emergencyContact;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public String getOngoingTreatments() {
        return ongoingTreatments;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
               "Medical History: " + medicalHistory + "\n" +
               "Ongoing Treatments: " + ongoingTreatments + "\n" +
               "Allergies: " + allergies + "\n" +
               "Emergency Contact: " + emergencyContact + "\n";
    }
}
