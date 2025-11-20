package _27150.q1;

/**
 * Bill class extending Treatment
 * Contains billing information
 */
public class Bill extends Treatment {
    private double doctorFee;
    private double medicineCost;
    private double totalBill;
    
    // Constructor
    public Bill(int id, String createdDate, String updatedDate,
               String patientName, int age, String gender, String contactNumber,
               String admissionDate, String roomNumber, double roomCharges,
               String diagnosis, String treatmentGiven, double treatmentCost,
               double doctorFee, double medicineCost) throws HospitalDataException {
        super(id, createdDate, updatedDate, patientName, age, gender, contactNumber,
              admissionDate, roomNumber, roomCharges, diagnosis, treatmentGiven, treatmentCost);
        setDoctorFee(doctorFee);
        setMedicineCost(medicineCost);
    }
    
    // Getters and Setters with validation
    public double getDoctorFee() {
        return doctorFee;
    }
    
    public void setDoctorFee(double doctorFee) throws HospitalDataException {
        if (doctorFee <= 0) {
            throw new HospitalDataException("Doctor fee must be greater than 0");
        }
        this.doctorFee = doctorFee;
    }
    
    public double getMedicineCost() {
        return medicineCost;
    }
    
    public void setMedicineCost(double medicineCost) throws HospitalDataException {
        if (medicineCost <= 0) {
            throw new HospitalDataException("Medicine cost must be greater than 0");
        }
        this.medicineCost = medicineCost;
    }
    
    public double getTotalBill() {
        return totalBill;
    }
    
    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nDoctor Fee: $" + String.format("%.2f", doctorFee) + 
               ", Medicine Cost: $" + String.format("%.2f", medicineCost) + 
               ", Total Bill: $" + String.format("%.2f", totalBill);
    }
}

