package _27150.q1;

/**
 * Treatment class extending Admission
 * Contains treatment-specific information
 */
public class Treatment extends Admission {
    private String diagnosis;
    private String treatmentGiven;
    private double treatmentCost;
    
    // Constructor
    public Treatment(int id, String createdDate, String updatedDate,
                    String patientName, int age, String gender, String contactNumber,
                    String admissionDate, String roomNumber, double roomCharges,
                    String diagnosis, String treatmentGiven, double treatmentCost) 
                    throws HospitalDataException {
        super(id, createdDate, updatedDate, patientName, age, gender, contactNumber,
              admissionDate, roomNumber, roomCharges);
        setDiagnosis(diagnosis);
        setTreatmentGiven(treatmentGiven);
        setTreatmentCost(treatmentCost);
    }
    
    // Getters and Setters with validation
    public String getDiagnosis() {
        return diagnosis;
    }
    
    public void setDiagnosis(String diagnosis) throws HospitalDataException {
        if (diagnosis == null || diagnosis.trim().isEmpty()) {
            throw new HospitalDataException("Diagnosis cannot be null or empty");
        }
        this.diagnosis = diagnosis;
    }
    
    public String getTreatmentGiven() {
        return treatmentGiven;
    }
    
    public void setTreatmentGiven(String treatmentGiven) throws HospitalDataException {
        if (treatmentGiven == null || treatmentGiven.trim().isEmpty()) {
            throw new HospitalDataException("Treatment given cannot be null or empty");
        }
        this.treatmentGiven = treatmentGiven;
    }
    
    public double getTreatmentCost() {
        return treatmentCost;
    }
    
    public void setTreatmentCost(double treatmentCost) throws HospitalDataException {
        if (treatmentCost <= 0) {
            throw new HospitalDataException("Treatment cost must be greater than 0");
        }
        this.treatmentCost = treatmentCost;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nDiagnosis: " + diagnosis + 
               ", Treatment Given: " + treatmentGiven + 
               ", Treatment Cost: $" + String.format("%.2f", treatmentCost);
    }
}

