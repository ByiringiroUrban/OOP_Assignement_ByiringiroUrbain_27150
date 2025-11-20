package _27150.q3;

/**
 * Department class extending Company with department-specific details.
 */
public class Department extends Company {
    private String departmentName;
    private String departmentCode;

    public Department(int id, String createdDate, String updatedDate,
                      String companyName, String address, String phoneNumber, String email,
                      String departmentName, String departmentCode) throws PayrollDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email);
        setDepartmentName(departmentName);
        setDepartmentCode(departmentCode);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) throws PayrollDataException {
        if (departmentName == null || departmentName.trim().isEmpty()) {
            throw new PayrollDataException("Department name cannot be null or empty");
        }
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) throws PayrollDataException {
        if (departmentCode == null || departmentCode.trim().isEmpty()) {
            throw new PayrollDataException("Department code cannot be null or empty");
        }
        if (departmentCode.length() < 3 || !departmentCode.matches("^[A-Za-z0-9]+$")) {
            throw new PayrollDataException("Department code must be alphanumeric and at least 3 characters");
        }
        this.departmentCode = departmentCode.toUpperCase();
    }

    @Override
    public String toString() {
        return super.toString() + "\nDepartment: " + departmentName + " (" + departmentCode + ")";
    }
}


