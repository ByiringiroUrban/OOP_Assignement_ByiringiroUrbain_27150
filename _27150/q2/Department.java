package _27150.q2;

/**
 * Department class extending School with department details.
 */
public class Department extends School {
    private String departmentName;
    private String departmentCode;

    public Department(int id, String createdDate, String updatedDate,
                      String schoolName, String address, String phoneNumber, String email,
                      String departmentName, String departmentCode) throws SchoolDataException {
        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email);
        setDepartmentName(departmentName);
        setDepartmentCode(departmentCode);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) throws SchoolDataException {
        if (departmentName == null || departmentName.trim().isEmpty()) {
            throw new SchoolDataException("Department name cannot be null or empty");
        }
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) throws SchoolDataException {
        if (departmentCode == null || departmentCode.trim().isEmpty()) {
            throw new SchoolDataException("Department code cannot be null or empty");
        }
        if (departmentCode.length() < 3 || !departmentCode.matches("^[A-Za-z0-9]+$")) {
            throw new SchoolDataException("Department code must be at least 3 alphanumeric characters");
        }
        this.departmentCode = departmentCode.toUpperCase();
    }

    @Override
    public String toString() {
        return super.toString() + "\nDepartment: " + departmentName + " (" + departmentCode + ")";
    }
}


