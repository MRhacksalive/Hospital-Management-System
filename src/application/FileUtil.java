package application;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static final String PATIENT_FILE_PATH = "patients.txt";
    private static final String DOCTOR_FILE_PATH = "doctors.txt";
    private static final String APPOINTMENT_FILE_PATH = "appointments.txt";

    public static void savePatients(List<Patient> patients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATIENT_FILE_PATH))) {
            for (Patient patient : patients) {
                writer.write(patient.getName() + "\n");
                writer.write(patient.getMedicalHistory() + "\n");
                writer.write(patient.getOngoingTreatments() + "\n");
                writer.write(patient.getAllergies() + "\n");
                writer.write(patient.getEmergencyContact() + "\n");
                writer.write("---\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Patient> loadPatients() {
        List<Patient> patients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATIENT_FILE_PATH))) {
            String line;
            StringBuilder patientData = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (line.equals("---")) {
                    String[] data = patientData.toString().split("\n");
                    if (data.length >= 5) {
                        Patient patient = new Patient(data[0], data[1], data[2], data[3], data[4]);
                        patients.add(patient);
                    }
                    patientData.setLength(0);
                } else {
                    patientData.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return patients;
    }

    public static void saveDoctors(List<Doctor> doctors) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DOCTOR_FILE_PATH))) {
            for (Doctor doctor : doctors) {
                writer.write(doctor.getName() + "\n");
                writer.write(doctor.getSpecialty() + "\n");
                writer.write("---\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Doctor> loadDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DOCTOR_FILE_PATH))) {
            String line;
            StringBuilder doctorData = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (line.equals("---")) {
                    String[] data = doctorData.toString().split("\n");
                    if (data.length >= 2) {
                        Doctor doctor = new Doctor(data[0], data[1]);
                        doctors.add(doctor);
                    }
                    doctorData.setLength(0);
                } else {
                    doctorData.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public static void saveAppointments(List<Appointment> appointments) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(APPOINTMENT_FILE_PATH))) {
            for (Appointment appointment : appointments) {
                writer.write(appointment.getPatient().getName() + "\n");
                writer.write(appointment.getDoctor().getName() + "\n");
                writer.write("---\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Appointment> loadAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(APPOINTMENT_FILE_PATH))) {
            String line;
            StringBuilder appointmentData = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (line.equals("---")) {
                    String[] data = appointmentData.toString().split("\n");
                    if (data.length >= 2) {
                        Patient patient = new Patient(data[0], "", "", "", "");
                        Doctor doctor = new Doctor(data[1], "");
                     // Assuming you have appointmentDate and appointmentTime variables
                        Appointment appointment = new Appointment(patient, doctor); 

                        appointments.add(appointment);
                    }
                    appointmentData.setLength(0);
                } else {
                    appointmentData.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appointments;
    }
} 