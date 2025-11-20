package _27150.q2;

import _27150.StudentOutput;

/**
 * Test harness for the School Management System classes.
 */
public class TestSchoolSystem {
    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== TESTING SCHOOL MANAGEMENT SYSTEM ==========\n");

        // Test 1: Valid record
        System.out.println("TEST 1: Creating StudentRecord with valid data...");
        try {
            StudentRecord record = createSampleRecord(1, 450);
            record.displayRecord();
            System.out.println("✓ TEST 1 PASSED\n");
        } catch (SchoolDataException e) {
            System.out.println("✗ TEST 1 FAILED: " + e.getMessage() + "\n");
        }

        // Test 2: Invalid ID
        System.out.println("TEST 2: Expecting failure for invalid ID (0)...");
        try {
            createSampleRecord(0, 450);
            System.out.println("✗ TEST 2 FAILED: Exception expected for invalid ID\n");
        } catch (SchoolDataException e) {
            System.out.println("✓ TEST 2 PASSED: " + e.getMessage() + "\n");
        }

        // Test 3: Obtained marks exceeding max
        System.out.println("TEST 3: Expecting failure for obtained marks > max marks...");
        try {
            createSampleRecord(2, 520);
            System.out.println("✗ TEST 3 FAILED: Exception expected for exceeded marks\n");
        } catch (SchoolDataException e) {
            System.out.println("✓ TEST 3 PASSED: " + e.getMessage() + "\n");
        }

        // Test 4: Fee calculation
        System.out.println("TEST 4: Verifying fee calculation...");
        try {
            StudentRecord record = createSampleRecord(3, 420);
            double expectedTotal = 1500.0 + 200.0;
            if (Math.abs(record.getTotalFee() - expectedTotal) < 0.001) {
                System.out.println("✓ TEST 4 PASSED: Total fee matches expected value\n");
            } else {
                System.out.println("✗ TEST 4 FAILED: Expected " + expectedTotal +
                                   " but got " + record.getTotalFee() + "\n");
            }
        } catch (SchoolDataException e) {
            System.out.println("✗ TEST 4 FAILED: " + e.getMessage() + "\n");
        }

        System.out.println("========== TESTING COMPLETE ==========");
    }

    private static StudentRecord createSampleRecord(int id, double obtainedMarks) throws SchoolDataException {
        StudentRecord record = new StudentRecord(
            id, "2025-01-01", "2025-02-01",
            "Bright Future School", "123 Learning Ave", "1234567890", "info@brightfuture.edu",
            "Science", "SCI01",
            "Dr. Elise Park", "Physics", "e.park@brightfuture.edu", "0987654321",
            "Liam Carter", 101, "A", "1112223333",
            "Advanced Physics", "PHY301", 4,
            "Midterm Exam", 500, "2025-03-15",
            obtainedMarks, "Keep it up!",
            1500.0, 200.0
        );
        record.generateBill();
        record.calculateAverageMarks();
        return record;
    }
}


