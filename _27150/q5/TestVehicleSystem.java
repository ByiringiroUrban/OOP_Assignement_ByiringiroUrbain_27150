package _27150.q5;

import _27150.StudentOutput;

/**
 * Test harness for Vehicle Rental System classes.
 */
public class TestVehicleSystem {
    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== TESTING VEHICLE RENTAL SYSTEM ==========\n");

        // Test 1: Valid record
        System.out.println("TEST 1: Creating RentalRecord with valid data...");
        try {
            RentalRecord record = createSampleRecord(1, 1500, 100);
            record.displayRecord();
            System.out.println("✓ TEST 1 PASSED\n");
        } catch (RentalDataException e) {
            System.out.println("✗ TEST 1 FAILED: " + e.getMessage() + "\n");
        }

        // Test 2: Invalid rental days
        System.out.println("TEST 2: Expecting failure for rentalDays <= 0...");
        try {
            new RentalRecord(
                2, "2025-01-01", "2025-01-02",
                "DriveNow", "789 Road St", "1234567890",
                "Central", "CTR",
                "SUV", "ABC123", 80.0,
                "Alex Miles", "LIC9876", "0987654321",
                "2025-02-01", "2025-02-05", 0,
                400, 50,
                "Credit Card", "TXN002"
            );
            System.out.println("✗ TEST 2 FAILED: Exception expected for rental days\n");
        } catch (RentalDataException e) {
            System.out.println("✓ TEST 2 PASSED: " + e.getMessage() + "\n");
        }

        // Test 3: Negative penalty
        System.out.println("TEST 3: Expecting failure for negative penalty...");
        try {
            new RentalRecord(
                3, "2025-01-01", "2025-01-02",
                "DriveNow", "789 Road St", "1234567890",
                "Central", "CTR",
                "Sedan", "XYZ789", 70.0,
                "Chris Ray", "LIC2222", "1112223333",
                "2025-02-01", "2025-02-04", 3,
                210, -10,
                "Cash", "TXN003"
            );
            System.out.println("✗ TEST 3 FAILED: Exception expected for penalty\n");
        } catch (RentalDataException e) {
            System.out.println("✓ TEST 3 PASSED: " + e.getMessage() + "\n");
        }

        // Test 4: Total charge calculation
        System.out.println("TEST 4: Verifying total charge calculation...");
        try {
            RentalRecord record = createSampleRecord(4, 1200, 75);
            double expectedTotal = record.getRentalCharge() + record.getPenaltyCharge();
            if (Math.abs(record.getTotalCharge() - expectedTotal) < 0.001) {
                System.out.println("✓ TEST 4 PASSED: Total charge matches expected value\n");
            } else {
                System.out.println("✗ TEST 4 FAILED: Expected " + expectedTotal +
                                   " but got " + record.getTotalCharge() + "\n");
            }
        } catch (RentalDataException e) {
            System.out.println("✗ TEST 4 FAILED: " + e.getMessage() + "\n");
        }

        System.out.println("========== TESTING COMPLETE ==========");
    }

    private static RentalRecord createSampleRecord(int id, double rentalCharge, double penalty)
            throws RentalDataException {
        RentalRecord record = new RentalRecord(
            id, "2025-01-01", "2025-01-02",
            "DriveNow", "123 Mobility Ave", "1234567890",
            "Downtown", "DTN",
            "Sedan", "XYZ123", 65.0,
            "Jordan Smith", "LIC1234", "0987654321",
            "2025-02-01", "2025-02-07", 6,
            rentalCharge, penalty,
            "Credit Card", "TXN001"
        );
        record.calculateTotalCharge();
        return record;
    }
}


