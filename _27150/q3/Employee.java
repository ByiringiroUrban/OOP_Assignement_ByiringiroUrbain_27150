package _27150.q3;

/**
 * Employee class extending Manager with employee-specific details.
 */
public class Employee extends Manager {
    private String employeeName;
    private int employeeId;
    private String designation;
    private String contactNumber;

    public Employee(int id, String createdDate, String updatedDate,
                    String companyName, String address, String phoneNumber, String email,
                    String departmentName, String departmentCode,
                    String managerName, String managerEmail, String managerPhone,
                    String employeeName, int employeeId, String designation, String contactNumber)
                    throws PayrollDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
              departmentName, departmentCode,
              managerName, managerEmail, managerPhone);
        setEmployeeName(employeeName);
        setEmployeeId(employeeId);
        setDesignation(designation);
        setContactNumber(contactNumber);
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) throws PayrollDataException {
        if (employeeName == null || employeeName.trim().isEmpty()) {
            throw new PayrollDataException("Employee name cannot be null or empty");
        }
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) throws PayrollDataException {
        if (employeeId <= 0) {
            throw new PayrollDataException("Employee ID must be greater than 0");
        }
        this.employeeId = employeeId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) throws PayrollDataException {
        if (designation == null || designation.trim().isEmpty()) {
            throw new PayrollDataException("Designation cannot be null or empty");
        }
        this.designation = designation;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) throws PayrollDataException {
        validatePhone(contactNumber);
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEmployee: " + employeeName + " (ID: " + employeeId +
               "), Designation: " + designation + ", Contact: " + contactNumber;
    }
}


