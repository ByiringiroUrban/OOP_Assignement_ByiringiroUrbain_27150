package _27150.q3;

import _27150.StudentOutput;

/**
 * Test harness for the Employee Payroll System classes.
 */
public class TestPayrollSystem {
    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== TESTING EMPLOYEE PAYROLL SYSTEM ==========\n");

        // Test 1: Valid payroll record
        System.out.println("TEST 1: Creating PayrollRecord with valid data...");
        try {
            PayrollRecord record = createSampleRecord(1, 3000);
            record.displayRecord();
            System.out.println("✓ TEST 1 PASSED\n");
        } catch (PayrollDataException e) {
            System.out.println("✗ TEST 1 FAILED: " + e.getMessage() + "\n");
        }

        // Test 2: Invalid entity ID
        System.out.println("TEST 2: Expecting failure for invalid ID (0)...");
        try {
            createSampleRecord(0, 3000);
            System.out.println("✗ TEST 2 FAILED: Exception expected for invalid ID\n");
        } catch (PayrollDataException e) {
            System.out.println("✓ TEST 2 PASSED: " + e.getMessage() + "\n");
        }

        // Test 3: Attendance validation
        System.out.println("TEST 3: Expecting failure for presentDays > totalDays...");
        try {
            PayrollRecord record = new PayrollRecord(
                3, "2025-01-01", "2025-02-01",
                "NextGen Corp", "45 Corporate Blvd", "4445556666", "contact@nextgen.com",
                "Finance", "FIN01",
                "Rachel Kim", "rachel.kim@nextgen.com", "5556667777",
                "Evan Wright", 102, "Accountant", "9998887777",
                20, 25, 0,
                600, 300,
                400, 150,
                3200
            );
            record.displayRecord();
            System.out.println("✗ TEST 3 FAILED: Exception expected for attendance\n");
        } catch (PayrollDataException e) {
            System.out.println("✓ TEST 3 PASSED: " + e.getMessage() + "\n");
        }

        // Test 4: Net salary computation
        System.out.println("TEST 4: Verifying net salary calculation...");
        try {
            PayrollRecord record = createSampleRecord(4, 2500);
            double expectedNet = record.getBasicSalary() +
                                 record.getHousingAllowance() +
                                 record.getTransportAllowance() -
                                 (record.getTaxDeduction() + record.getLoanDeduction());
            if (Math.abs(record.getNetSalary() - expectedNet) < 0.001) {
                System.out.println("✓ TEST 4 PASSED: Net salary matches expected value\n");
            } else {
                System.out.println("✗ TEST 4 FAILED: Expected " + expectedNet +
                                   " but got " + record.getNetSalary() + "\n");
            }
        } catch (PayrollDataException e) {
            System.out.println("✗ TEST 4 FAILED: " + e.getMessage() + "\n");
        }

        System.out.println("========== TESTING COMPLETE ==========");
    }

    private static PayrollRecord createSampleRecord(int id, double basicSalary) throws PayrollDataException {
        PayrollRecord record = new PayrollRecord(
            id, "2025-01-01", "2025-02-01",
            "NextGen Corp", "45 Corporate Blvd", "4445556666", "contact@nextgen.com",
            "Engineering", "ENG01",
            "Rachel Kim", "rachel.kim@nextgen.com", "5556667777",
            "Jordan Lee", 101, "Senior Developer", "8887776666",
            22, 20, 2,
            800, 300,
            500, 200,
            basicSalary
        );
        record.calculateNetSalary();
        return record;
    }
}


