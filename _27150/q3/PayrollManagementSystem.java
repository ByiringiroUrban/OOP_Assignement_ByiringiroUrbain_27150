package _27150.q3;

import java.util.Scanner;
import _27150.StudentOutput;

/**
 * Console runner for the Employee Payroll System.
 */
public class PayrollManagementSystem {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== EMPLOYEE PAYROLL SYSTEM ==========");
        System.out.println("Enter the required details to generate payroll.\n");

        try {
            int id = getInt("Enter Entity ID (> 0): ");
            String createdDate = getString("Created Date: ");
            String updatedDate = getString("Updated Date: ");

            System.out.println("\n--- COMPANY INFO ---");
            String companyName = getString("Company Name: ");
            String address = getString("Address: ");
            String companyPhone = getString("Company Phone (10 digits): ");
            String companyEmail = getString("Company Email: ");

            System.out.println("\n--- DEPARTMENT INFO ---");
            String departmentName = getString("Department Name: ");
            String departmentCode = getString("Department Code (>=3 chars): ");

            System.out.println("\n--- MANAGER INFO ---");
            String managerName = getString("Manager Name: ");
            String managerEmail = getString("Manager Email: ");
            String managerPhone = getString("Manager Phone (10 digits): ");

            System.out.println("\n--- EMPLOYEE INFO ---");
            String employeeName = getString("Employee Name: ");
            int employeeId = getInt("Employee ID (> 0): ");
            String designation = getString("Designation: ");
            String employeeContact = getString("Employee Contact (10 digits): ");

            System.out.println("\n--- ATTENDANCE INFO ---");
            int totalDays = getInt("Total Days (>= 0): ");
            int presentDays = getInt("Present Days (>= 0): ");
            int leaveDays = getInt("Leave Days (>= 0): ");

            System.out.println("\n--- ALLOWANCE INFO ---");
            double housingAllowance = getDouble("Housing Allowance (>= 0): ");
            double transportAllowance = getDouble("Transport Allowance (>= 0): ");

            System.out.println("\n--- DEDUCTION INFO ---");
            double taxDeduction = getDouble("Tax Deduction (>= 0): ");
            double loanDeduction = getDouble("Loan Deduction (>= 0): ");

            System.out.println("\n--- SALARY INFO ---");
            double basicSalary = getDouble("Basic Salary (> 0): ");

            PayrollRecord record = new PayrollRecord(
                id, createdDate, updatedDate,
                companyName, address, companyPhone, companyEmail,
                departmentName, departmentCode,
                managerName, managerEmail, managerPhone,
                employeeName, employeeId, designation, employeeContact,
                totalDays, presentDays, leaveDays,
                housingAllowance, transportAllowance,
                taxDeduction, loanDeduction,
                basicSalary
            );

            record.calculateNetSalary();
            record.displayRecord();

        } catch (PayrollDataException e) {
            System.out.println("\nERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\nUNEXPECTED ERROR: " + e.getMessage());
            e.printStackTrace();
        } finally {
            SCANNER.close();
        }
    }

    private static String getString(String prompt) {
        System.out.print(prompt);
        String value = SCANNER.nextLine().trim();
        while (value.isEmpty()) {
            System.out.print("Value cannot be empty. " + prompt);
            value = SCANNER.nextLine().trim();
        }
        return value;
    }

    private static int getInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(SCANNER.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid integer. Try again.");
            }
        }
    }

    private static double getDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(SCANNER.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }
}


