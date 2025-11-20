package _27150.q3;

/**
 * Final PayrollRecord class extending Salary and implementing calculations.
 */
public final class PayrollRecord extends Salary {
    public PayrollRecord(int id, String createdDate, String updatedDate,
                         String companyName, String address, String phoneNumber, String email,
                         String departmentName, String departmentCode,
                         String managerName, String managerEmail, String managerPhone,
                         String employeeName, int employeeId, String designation, String contactNumber,
                         int totalDays, int presentDays, int leaveDays,
                         double housingAllowance, double transportAllowance,
                         double taxDeduction, double loanDeduction,
                         double basicSalary)
                         throws PayrollDataException {
        super(id, createdDate, updatedDate,
              companyName, address, phoneNumber, email,
              departmentName, departmentCode,
              managerName, managerEmail, managerPhone,
              employeeName, employeeId, designation, contactNumber,
              totalDays, presentDays, leaveDays,
              housingAllowance, transportAllowance,
              taxDeduction, loanDeduction,
              basicSalary,
              basicSalary + housingAllowance + transportAllowance,
              basicSalary); // temporary net, will be recalculated
        calculateNetSalary();
    }

    /**
     * Calculates and updates gross and net salary.
     * Formula: gross = basic + allowances, net = gross - deductions.
     */
    public double calculateNetSalary() {
        double allowances = getHousingAllowance() + getTransportAllowance();
        double deductions = getTaxDeduction() + getLoanDeduction();
        double gross = getBasicSalary() + allowances;
        double net = gross - deductions;
        try {
            setGrossSalary(gross);
            if (net <= 0) {
                throw new PayrollDataException("Net salary must be greater than 0");
            }
            setNetSalary(net);
        } catch (PayrollDataException e) {
            throw new IllegalStateException("Salary calculation failed: " + e.getMessage(), e);
        }
        return net;
    }

    public void displayRecord() {
        System.out.println("\n========== EMPLOYEE PAYROLL RECORD ==========");
        System.out.println("Company: " + getCompanyName());
        System.out.println("Department: " + getDepartmentName() + " (" + getDepartmentCode() + ")");
        System.out.println("Manager: " + getManagerName());

        System.out.println("\n--- EMPLOYEE DETAILS ---");
        System.out.println("Employee Name: " + getEmployeeName());
        System.out.println("Employee ID: " + getEmployeeId());
        System.out.println("Designation: " + getDesignation());
        System.out.println("Contact: " + getContactNumber());

        System.out.println("\n--- ATTENDANCE ---");
        System.out.println("Total Days: " + getTotalDays());
        System.out.println("Present Days: " + getPresentDays());
        System.out.println("Leave Days: " + getLeaveDays());

        System.out.println("\n--- ALLOWANCES ---");
        System.out.println("Housing Allowance: $" + String.format("%.2f", getHousingAllowance()));
        System.out.println("Transport Allowance: $" + String.format("%.2f", getTransportAllowance()));

        System.out.println("\n--- DEDUCTIONS ---");
        System.out.println("Tax Deduction: $" + String.format("%.2f", getTaxDeduction()));
        System.out.println("Loan Deduction: $" + String.format("%.2f", getLoanDeduction()));

        System.out.println("\n--- SALARY SUMMARY ---");
        System.out.println("Basic Salary: $" + String.format("%.2f", getBasicSalary()));
        System.out.println("Gross Salary: $" + String.format("%.2f", getGrossSalary()));
        System.out.println("Net Salary: $" + String.format("%.2f", getNetSalary()));
        System.out.println("====================================================\n");
    }
}


