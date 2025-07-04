package application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class DoctorManagement {
    private List<Doctor> doctorList;
    private TextArea outputArea = new TextArea();

    public DoctorManagement(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public void start(Stage stage) {
        Label label = new Label("Doctor Management");
        TextField doctorNameField = new TextField();
        doctorNameField.setPromptText("Doctor Name");
        TextField specialtyField = new TextField();
        specialtyField.setPromptText("Specialty");

        Button addButton = new Button("Add Doctor");
        addButton.setOnAction(e -> {
            String doctorName = doctorNameField.getText();
            String specialty = specialtyField.getText();

            Doctor doctor = new Doctor(doctorName, specialty);
            doctorList.add(doctor);
            FileUtil.saveDoctors(doctorList); // Save updated doctor list

            String message = "Added doctor: " + doctorName + ", Specialty: " + specialty;
            outputArea.appendText(message + "\n");

            // Clear fields after submission
            doctorNameField.clear();
            specialtyField.clear();
        });

        Button viewDoctorsButton = new Button("View All Doctors");
        viewDoctorsButton.setOnAction(e -> {
            outputArea.clear();
            for (Doctor doctor : doctorList) {
                outputArea.appendText(doctor.toString() + "\n---\n");
            }
        });

        // Button to clear all doctors
        Button clearDoctorsButton = new Button("Clear All Doctors");
        clearDoctorsButton.setOnAction(e -> {
            doctorList.clear(); // Clear in-memory list
            FileUtil.saveDoctors(doctorList); // Save empty list to clear the file
            outputArea.appendText("All doctors have been cleared.\n");
        });

        VBox vbox = new VBox(label, doctorNameField, specialtyField, addButton, viewDoctorsButton, clearDoctorsButton, outputArea);
        Scene scene = new Scene(vbox, 300, 250);
        stage.setTitle("Doctor Management");
        stage.setScene(scene);
        stage.show();
    }
}
