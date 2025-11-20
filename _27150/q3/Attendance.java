package _27150.q3;

/**
 * Attendance class extending Employee with attendance details.
 */
public class Attendance extends Employee {
    private int totalDays;
    private int presentDays;
    private int leaveDays;

    public Attendance(int id, String createdDate, String updatedDate,
                      String companyName, String address, String phoneNumber, String email,
                      String departmentName, String departmentCode,
                      String managerName, String managerEmail, String managerPhone,
                      String employeeName, int employeeId, String designation, String contactNumber,
                      int totalDays, int presentDays, int leaveDays)
                      throws PayrollDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
              departmentName, departmentCode, managerName, managerEmail, managerPhone,
              employeeName, employeeId, designation, contactNumber);
        setTotalDays(totalDays);
        setPresentDays(presentDays);
        setLeaveDays(leaveDays);
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) throws PayrollDataException {
        if (totalDays < 0) {
            throw new PayrollDataException("Total days cannot be negative");
        }
        this.totalDays = totalDays;
    }

    public int getPresentDays() {
        return presentDays;
    }

    public void setPresentDays(int presentDays) throws PayrollDataException {
        if (presentDays < 0) {
            throw new PayrollDataException("Present days cannot be negative");
        }
        if (presentDays > totalDays) {
            throw new PayrollDataException("Present days cannot exceed total days");
        }
        this.presentDays = presentDays;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) throws PayrollDataException {
        if (leaveDays < 0) {
            throw new PayrollDataException("Leave days cannot be negative");
        }
        this.leaveDays = leaveDays;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAttendance: Total " + totalDays +
               ", Present " + presentDays + ", Leave " + leaveDays;
    }
}


