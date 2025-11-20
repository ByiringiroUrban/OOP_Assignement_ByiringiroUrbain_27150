package _27150.q7;

import _27150.StudentOutput;

/**
 * Test harness for the Real Estate Management System classes.
 */
public class TestRealEstateSystem {
    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== TESTING REAL ESTATE SYSTEM ==========\n");

        // Test 1: Valid record
        System.out.println("TEST 1: Creating RealEstateRecord with valid data...");
        try {
            RealEstateRecord record = createSampleRecord(1, 2.5);
            record.displayRecord();
            System.out.println("✓ TEST 1 PASSED\n");
        } catch (RealEstateDataException e) {
            System.out.println("✗ TEST 1 FAILED: " + e.getMessage() + "\n");
        }

        // Test 2: Invalid price
        System.out.println("TEST 2: Expecting failure for price <= 0...");
        try {
            createSampleRecordWithPrice(0.0);
            System.out.println("✗ TEST 2 FAILED: Exception expected for invalid price\n");
        } catch (RealEstateDataException e) {
            System.out.println("✓ TEST 2 PASSED: " + e.getMessage() + "\n");
        }

        // Test 3: Invalid commission rate (negative)
        System.out.println("TEST 3: Expecting failure for negative commission rate...");
        try {
            new RealEstateRecord(
                3, "2025-01-01", "2025-01-02",
                "Prime Realty", "Downtown", "1234567890",
                "Elaine Brooks", "elaine@prime.com", "LIC999",
                "PROP303", "Condo", 350000.0,
                "Samuel Green", "0987654321",
                "Olivia White", "olivia@example.com",
                "2025-02-01", "Standard terms apply",
                50000.0, "2025-02-05",
                -2.0
            );
            System.out.println("✗ TEST 3 FAILED: Exception expected for negative commission rate\n");
        } catch (RealEstateDataException e) {
            System.out.println("✓ TEST 3 PASSED: " + e.getMessage() + "\n");
        }

        // Test 4: Commission calculation
        System.out.println("TEST 4: Verifying commission calculation...");
        try {
            RealEstateRecord record = createSampleRecord(4, 3.0);
            double expectedCommission = record.getPrice() * record.getCommissionRate() / 100.0;
            if (Math.abs(record.getCommissionAmount() - expectedCommission) < 0.001) {
                System.out.println("✓ TEST 4 PASSED: Commission calculation correct\n");
            } else {
                System.out.println("✗ TEST 4 FAILED: Expected " + expectedCommission +
                                   " but got " + record.getCommissionAmount() + "\n");
            }
        } catch (RealEstateDataException e) {
            System.out.println("✗ TEST 4 FAILED: " + e.getMessage() + "\n");
        }

        System.out.println("========== TESTING COMPLETE ==========");
    }

    private static RealEstateRecord createSampleRecord(int id, double commissionRate)
            throws RealEstateDataException {
        RealEstateRecord record = new RealEstateRecord(
            id, "2025-01-01", "2025-01-02",
            "Prime Realty", "Downtown", "1234567890",
            "Elaine Brooks", "elaine@prime.com", "LIC123",
            "PROP101", "Apartment", 250000.0,
            "John Miller", "0987654321",
            "Emily Clark", "emily@example.com",
            "2025-02-01", "Standard agreement terms",
            50000.0, "2025-02-05",
            commissionRate
        );
        record.calculateCommission();
        return record;
    }

    private static void createSampleRecordWithPrice(double price) throws RealEstateDataException {
        new RealEstateRecord(
            2, "2025-01-01", "2025-01-02",
            "Prime Realty", "Downtown", "1234567890",
            "Elaine Brooks", "elaine@prime.com", "LIC123",
            "PROP202", "Villa", price,
            "John Miller", "0987654321",
            "Emily Clark", "emily@example.com",
            "2025-02-01", "Standard agreement terms",
            50000.0, "2025-02-05",
            2.5
        );
    }
}


