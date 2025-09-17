package aadi;

import java.util.*;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;
    private List<String> medicalHistory = new ArrayList<>();

    public Patient(String patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void addHistory(String record) {
        medicalHistory.add(record);
    }

    public List<String> getMedicalHistory() {
        return new ArrayList<>(medicalHistory);
    }

    public String getPatientDetails() {
        return "ID: " + patientId + ", Name: " + name + ", Age: " + age + ", Diagnosis: " + diagnosis;
    }

    public abstract double calculateBill();
}

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(String patientId, String name, int age, String diagnosis, int daysAdmitted, double dailyRate) {
        super(patientId, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    public void addRecord(String record) {
        addHistory(record);
    }

    public List<String> viewRecords() {
        return getMedicalHistory();
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;

    public OutPatient(String patientId, String name, int age, String diagnosis, double consultationFee) {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        addHistory(record);
    }

    public List<String> viewRecords() {
        return getMedicalHistory();
    }
}

public class hospital_patience_management {
    public static void processPatients(List<Patient> patients) {
        for (Patient p : patients) {
            System.out.println(p.getPatientDetails() + ", Bill: " + p.calculateBill());
        }
    }

    public static void main(String[] args) {
        List<Patient> list = new ArrayList<>();
        InPatient p1 = new InPatient("P001", "Aarav", 35, "Fracture", 5, 2000);
        p1.addRecord("X-Ray done");
        p1.addRecord("Plaster applied");

        OutPatient p2 = new OutPatient("P002", "Meera", 28, "Fever", 500);
        p2.addRecord("Blood test done");
        p2.addRecord("Medication prescribed");

        list.add(p1);
        list.add(p2);
        processPatients(list);
    }
}
