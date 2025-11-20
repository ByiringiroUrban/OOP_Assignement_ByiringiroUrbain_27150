package _27150.q1;

/**
 * Nurse class extending Department
 * Contains nurse-specific information
 */
public class Nurse extends Department {
    private String nurseName;
    private String shift;
    private int yearsOfExperience;
    
    // Constructor
    public Nurse(int id, String createdDate, String updatedDate,
                String hospitalName, String address, String phoneNumber, String email,
                String departmentName, String departmentCode,
                String nurseName, String shift, int yearsOfExperience) 
                throws HospitalDataException {
        super(id, createdDate, updatedDate, hospitalName, address, phoneNumber, email,
              departmentName, departmentCode);
        setNurseName(nurseName);
        setShift(shift);
        setYearsOfExperience(yearsOfExperience);
    }
    
    // Getters and Setters with validation
    public String getNurseName() {
        return nurseName;
    }
    
    public void setNurseName(String nurseName) throws HospitalDataException {
        if (nurseName == null || nurseName.trim().isEmpty()) {
            throw new HospitalDataException("Nurse name cannot be null or empty");
        }
        this.nurseName = nurseName;
    }
    
    public String getShift() {
        return shift;
    }
    
    public void setShift(String shift) throws HospitalDataException {
        if (shift == null || shift.trim().isEmpty()) {
            throw new HospitalDataException("Shift cannot be null or empty");
        }
        // Validate shift is either "Day" or "Night"
        if (!shift.equalsIgnoreCase("Day") && !shift.equalsIgnoreCase("Night")) {
            throw new HospitalDataException("Shift must be either 'Day' or 'Night'");
        }
        this.shift = shift;
    }
    
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    
    public void setYearsOfExperience(int yearsOfExperience) throws HospitalDataException {
        if (yearsOfExperience < 0) {
            throw new HospitalDataException("Years of experience must be greater than or equal to 0");
        }
        this.yearsOfExperience = yearsOfExperience;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nNurse Name: " + nurseName + 
               ", Shift: " + shift + ", Years of Experience: " + yearsOfExperience;
    }
}

