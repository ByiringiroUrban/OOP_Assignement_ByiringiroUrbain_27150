package _27150.q3;

/**
 * Manager class extending Department with manager-specific data.
 */
public class Manager extends Department {
    private String managerName;
    private String managerEmail;
    private String managerPhone;

    public Manager(int id, String createdDate, String updatedDate,
                   String companyName, String address, String phoneNumber, String email,
                   String departmentName, String departmentCode,
                   String managerName, String managerEmail, String managerPhone)
                   throws PayrollDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
              departmentName, departmentCode);
        setManagerName(managerName);
        setManagerEmail(managerEmail);
        setManagerPhone(managerPhone);
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) throws PayrollDataException {
        if (managerName == null || managerName.trim().isEmpty()) {
            throw new PayrollDataException("Manager name cannot be null or empty");
        }
        this.managerName = managerName;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) throws PayrollDataException {
        validateEmail(managerEmail);
        this.managerEmail = managerEmail;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) throws PayrollDataException {
        validatePhone(managerPhone);
        this.managerPhone = managerPhone;
    }

    @Override
    public String toString() {
        return super.toString() + "\nManager: " + managerName +
               ", Email: " + managerEmail + ", Phone: " + managerPhone;
    }
}


