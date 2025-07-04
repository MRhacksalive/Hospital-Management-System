package application;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private List<Patient> patientList;
    private List<Appointment> appointmentList;
    private List<Doctor> doctorList;

    public void init() {
        patientList = FileUtil.loadPatients();
        doctorList = FileUtil.loadDoctors();
        appointmentList = FileUtil.loadAppointments();

        if (patientList == null) patientList = new ArrayList<>();
        if (doctorList == null) doctorList = new ArrayList<>();
        if (appointmentList == null) appointmentList = new ArrayList<>();
    }

    public void start(Stage primaryStage) {
        Button registerButton = new Button("Patient Registration");
        Button appointmentButton = new Button("Appointment Scheduling");
        Button doctorButton = new Button("Doctor Management");

        // Add CSS styles to the buttons
        registerButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 10;");
        appointmentButton.setStyle("-fx-background-color: #FF9800; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 10;");
        doctorButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 10;");

        // Set button actions
        registerButton.setOnAction(e -> {
            PatientRegistration patientRegistration = new PatientRegistration(patientList);
            patientRegistration.start(new Stage());
        });

        appointmentButton.setOnAction(e -> {
            AppointmentScheduling appointmentScheduling = new AppointmentScheduling(patientList, doctorList, appointmentList);
            appointmentScheduling.start(new Stage());
        });

        doctorButton.setOnAction(e -> {
            DoctorManagement doctorManagement = new DoctorManagement(doctorList);
            doctorManagement.start(new Stage());
        });

        // Create a VBox layout and set alignment to center
        VBox vbox = new VBox(15, registerButton, appointmentButton, doctorButton);  // 15 is the spacing between buttons
        vbox.setAlignment(Pos.CENTER);

        // Set up the background image
        Image backgroundImage = new Image("file:C:/Users/LAKSHYA/eclipse-workspace/Project/src/application/images.jpeg");
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, false, true)
        );
        vbox.setBackground(new Background(background));

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Kasturba Medical College");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void stop() {
        FileUtil.savePatients(patientList);
        FileUtil.saveDoctors(doctorList);
        FileUtil.saveAppointments(appointmentList);
    }

    public static void main(String[] args) {
        launch(args);
    }
}


