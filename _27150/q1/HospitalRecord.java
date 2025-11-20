package _27150.q1;

/**
 * HospitalRecord class - Final class extending Bill
 * Contains the generateBill() method to calculate total bill
 */
public final class HospitalRecord extends Bill {
    
    // Constructor
    public HospitalRecord(int id, String createdDate, String updatedDate,
                         String patientName, int age, String gender, String contactNumber,
                         String admissionDate, String roomNumber, double roomCharges,
                         String diagnosis, String treatmentGiven, double treatmentCost,
                         double doctorFee, double medicineCost) throws HospitalDataException {
        super(id, createdDate, updatedDate, patientName, age, gender, contactNumber,
              admissionDate, roomNumber, roomCharges, diagnosis, treatmentGiven, treatmentCost,
              doctorFee, medicineCost);
    }
    
    /**
     * Method to generate the total bill
     * Formula: totalBill = roomCharges + treatmentCost + doctorFee + medicineCost
     */
    public void generateBill() {
        double total = getRoomCharges() + getTreatmentCost() + getDoctorFee() + getMedicineCost();
        setTotalBill(total);
    }
    
    /**
     * Display all hospital and patient details along with the final bill
     */
    public void displayRecord() {
        System.out.println("\n========== HOSPITAL MANAGEMENT SYSTEM - RECORD ==========");
        System.out.println("\n--- PATIENT INFORMATION ---");
        System.out.println("Patient ID: " + getId());
        System.out.println("Patient Name: " + getPatientName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Contact Number: " + getContactNumber());
        System.out.println("Created Date: " + getCreatedDate());
        System.out.println("Updated Date: " + getUpdatedDate());
        
        System.out.println("\n--- ADMISSION INFORMATION ---");
        System.out.println("Admission Date: " + getAdmissionDate());
        System.out.println("Room Number: " + getRoomNumber());
        
        System.out.println("\n--- TREATMENT INFORMATION ---");
        System.out.println("Diagnosis: " + getDiagnosis());
        System.out.println("Treatment Given: " + getTreatmentGiven());
        
        System.out.println("\n--- BILLING DETAILS ---");
        System.out.println("Room Charges: $" + String.format("%.2f", getRoomCharges()));
        System.out.println("Treatment Cost: $" + String.format("%.2f", getTreatmentCost()));
        System.out.println("Doctor Fee: $" + String.format("%.2f", getDoctorFee()));
        System.out.println("Medicine Cost: $" + String.format("%.2f", getMedicineCost()));
        System.out.println("----------------------------------------");
        System.out.println("TOTAL BILL: $" + String.format("%.2f", getTotalBill()));
        System.out.println("========================================\n");
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}

