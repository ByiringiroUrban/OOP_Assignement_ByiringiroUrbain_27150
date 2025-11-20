package _27150.q3;

/**
 * Allowance class extending Attendance with allowance figures.
 */
public class Allowance extends Attendance {
    private double housingAllowance;
    private double transportAllowance;

    public Allowance(int id, String createdDate, String updatedDate,
                     String companyName, String address, String phoneNumber, String email,
                     String departmentName, String departmentCode,
                     String managerName, String managerEmail, String managerPhone,
                     String employeeName, int employeeId, String designation, String contactNumber,
                     int totalDays, int presentDays, int leaveDays,
                     double housingAllowance, double transportAllowance)
                     throws PayrollDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
              departmentName, departmentCode, managerName, managerEmail, managerPhone,
              employeeName, employeeId, designation, contactNumber,
              totalDays, presentDays, leaveDays);
        setHousingAllowance(housingAllowance);
        setTransportAllowance(transportAllowance);
    }

    public double getHousingAllowance() {
        return housingAllowance;
    }

    public void setHousingAllowance(double housingAllowance) throws PayrollDataException {
        if (housingAllowance < 0) {
            throw new PayrollDataException("Housing allowance cannot be negative");
        }
        this.housingAllowance = housingAllowance;
    }

    public double getTransportAllowance() {
        return transportAllowance;
    }

    public void setTransportAllowance(double transportAllowance) throws PayrollDataException {
        if (transportAllowance < 0) {
            throw new PayrollDataException("Transport allowance cannot be negative");
        }
        this.transportAllowance = transportAllowance;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAllowances: Housing $" + housingAllowance +
               ", Transport $" + transportAllowance;
    }
}


