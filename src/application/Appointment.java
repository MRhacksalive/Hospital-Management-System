package application;

import java.time.LocalDate;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private String time;

    // Constructor with date and time
    public Appointment(Patient patient, Doctor doctor, LocalDate date, String time) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

  
    public Appointment(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = LocalDate.now();
        this.time = "09:00";
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Appointment on " + date + " at " + time + " with Dr. " + doctor.getName() + " and patient " + patient.getName();
    }
}
