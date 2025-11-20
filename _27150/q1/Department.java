package _27150.q1;

/**
 * Department class extending Hospital
 * Contains department-specific information
 */
public class Department extends Hospital {
    private String departmentName;
    private String departmentCode;
    
    // Constructor
    public Department(int id, String createdDate, String updatedDate,
                     String hospitalName, String address, String phoneNumber, String email,
                     String departmentName, String departmentCode) throws HospitalDataException {
        super(id, createdDate, updatedDate, hospitalName, address, phoneNumber, email);
        setDepartmentName(departmentName);
        setDepartmentCode(departmentCode);
    }
    
    // Getters and Setters with validation
    public String getDepartmentName() {
        return departmentName;
    }
    
    public void setDepartmentName(String departmentName) throws HospitalDataException {
        if (departmentName == null || departmentName.trim().isEmpty()) {
            throw new HospitalDataException("Department name cannot be null or empty");
        }
        this.departmentName = departmentName;
    }
    
    public String getDepartmentCode() {
        return departmentCode;
    }
    
    public void setDepartmentCode(String departmentCode) throws HospitalDataException {
        if (departmentCode == null || departmentCode.trim().isEmpty()) {
            throw new HospitalDataException("Department code cannot be null or empty");
        }
        // Validate: alphanumeric and at least 3 characters
        if (!departmentCode.matches("^[A-Za-z0-9]{3,}$")) {
            throw new HospitalDataException("Department code must be alphanumeric and at least 3 characters");
        }
        this.departmentCode = departmentCode;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nDepartment Name: " + departmentName + 
               ", Department Code: " + departmentCode;
    }
}

