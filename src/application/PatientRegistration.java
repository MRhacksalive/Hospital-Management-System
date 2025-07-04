package application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class PatientRegistration {
    private List<Patient> patientList;
    private TextArea outputArea = new TextArea();

    public PatientRegistration(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public void start(Stage stage) {
        Label label = new Label("Patient Registration");

        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField medicalHistoryField = new TextField();
        medicalHistoryField.setPromptText("Medical History");

        TextField ongoingTreatmentsField = new TextField();
        ongoingTreatmentsField.setPromptText("Ongoing Treatments");

        TextField allergiesField = new TextField();
        allergiesField.setPromptText("Allergies");

        TextField emergencyContactField = new TextField();
        emergencyContactField.setPromptText("Emergency Contact");

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String name = nameField.getText();
            String medicalHistory = medicalHistoryField.getText();
            String ongoingTreatments = ongoingTreatmentsField.getText();
            String allergies = allergiesField.getText();
            String emergencyContact = emergencyContactField.getText();

            Patient patient = new Patient(name, medicalHistory, ongoingTreatments, allergies, emergencyContact);
            patientList.add(patient);
            FileUtil.savePatients(patientList); // Save updated list
            outputArea.appendText("Registered patient: " + name + "\n");

            // Clear fields after submission
            nameField.clear();
            medicalHistoryField.clear();
            ongoingTreatmentsField.clear();
            allergiesField.clear();
            emergencyContactField.clear();
        });

        Button viewPatientsButton = new Button("View All Patients");
        viewPatientsButton.setOnAction(e -> {
            outputArea.clear();
            for (Patient patient : patientList) {
                outputArea.appendText(patient.toString() + "\n---\n");
            }
        });

        // Button to clear all patients
        Button clearPatientsButton = new Button("Clear All Patients");
        clearPatientsButton.setOnAction(e -> {
            patientList.clear(); // Clear in-memory list
            FileUtil.savePatients(patientList); // Save empty list to clear the file
            outputArea.appendText("All patients have been cleared.\n");
        });

        VBox vbox = new VBox(label, nameField, medicalHistoryField, ongoingTreatmentsField, allergiesField, emergencyContactField, submitButton, viewPatientsButton, clearPatientsButton, outputArea);
        Scene scene = new Scene(vbox, 400, 500);
        stage.setTitle("Patient Registration");
        stage.setScene(scene);
        stage.show();
    }
}
