package _27150.q8;

import _27150.StudentOutput;

/**
 * Test harness for the Library Management System classes.
 */
public class TestLibrarySystem {
    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== TESTING LIBRARY SYSTEM ==========\n");

        // Test 1: Valid record
        System.out.println("TEST 1: Creating LibraryRecord with valid data...");
        try {
            LibraryRecord record = createSampleRecord(1, 5);
            record.displayRecord();
            System.out.println("✓ TEST 1 PASSED\n");
        } catch (LibraryDataException e) {
            System.out.println("✗ TEST 1 FAILED: " + e.getMessage() + "\n");
        }

        // Test 2: Invalid ISBN
        System.out.println("TEST 2: Expecting failure for short ISBN...");
        try {
            new LibraryRecord(
                2, "2025-01-01", "2025-01-02",
                "City Library", "Downtown", "1234567890",
                "Fiction", "FIC",
                "Short ISBN Book", "Author B", "12345",
                "Alice Lee", 101, "0987654321",
                "2025-02-01", "2025-02-10",
                2.0, 1,
                "2025-02-11", "Cash"
            );
            System.out.println("✗ TEST 2 FAILED: Exception expected for short ISBN\n");
        } catch (LibraryDataException e) {
            System.out.println("✓ TEST 2 PASSED: " + e.getMessage() + "\n");
        }

        // Test 3: Total fine calculation
        System.out.println("TEST 3: Verifying fine calculation...");
        try {
            LibraryRecord record = createSampleRecord(3, 3);
            double expectedFine = record.getFineAmount() * record.getDaysLate();
            if (Math.abs(record.getTotalFine() - expectedFine) < 0.001) {
                System.out.println("✓ TEST 3 PASSED: Fine calculation correct\n");
            } else {
                System.out.println("✗ TEST 3 FAILED: Expected " + expectedFine +
                                   " but got " + record.getTotalFine() + "\n");
            }
        } catch (LibraryDataException e) {
            System.out.println("✗ TEST 3 FAILED: " + e.getMessage() + "\n");
        }

        System.out.println("========== TESTING COMPLETE ==========");
    }

    private static LibraryRecord createSampleRecord(int id, int daysLate) throws LibraryDataException {
        LibraryRecord record = new LibraryRecord(
            id, "2025-01-01", "2025-01-02",
            "City Library", "Downtown", "1234567890",
            "Fiction", "FIC",
            "The Great Adventure", "Author A", "ISBN1234567",
            "John Doe", 1001, "0987654321",
            "2025-02-01", "2025-02-10",
            2.5, daysLate,
            "2025-02-12", "Card"
        );
        record.calculateFine();
        return record;
    }
}


