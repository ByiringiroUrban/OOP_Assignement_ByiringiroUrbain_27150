package _27150.q4;

import _27150.StudentOutput;

/**
 * Test harness for the Hotel Reservation System classes.
 */
public class TestHotelSystem {
    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== TESTING HOTEL RESERVATION SYSTEM ==========\n");

        // Test 1: Valid reservation
        System.out.println("TEST 1: Creating ReservationRecord with valid data...");
        try {
            ReservationRecord record = createSampleRecord(1, 4);
            record.displayRecord();
            System.out.println("✓ TEST 1 PASSED\n");
        } catch (ReservationDataException e) {
            System.out.println("✗ TEST 1 FAILED: " + e.getMessage() + "\n");
        }

        // Test 2: Invalid rating
        System.out.println("TEST 2: Expecting failure for rating outside range...");
        try {
            createSampleRecord(2, 6);
            System.out.println("✗ TEST 2 FAILED: Exception expected for invalid rating\n");
        } catch (ReservationDataException e) {
            System.out.println("✓ TEST 2 PASSED: " + e.getMessage() + "\n");
        }

        // Test 3: Negative service charge
        System.out.println("TEST 3: Expecting failure for negative service charge...");
        try {
            ReservationRecord record = new ReservationRecord(
                3, "2025-01-01", "2025-01-02",
                "Grand Plaza", "789 City Rd", "1234567890", "info@grandplaza.com",
                "305", "Suite", 250.0,
                "Lara West", "lara@example.com", "0987654321",
                "2025-02-01", "2025-02-10", "2025-02-15",
                "Spa Package", -50.0,
                "Credit Card", "2025-01-02",
                1000.0, 200.0,
                5, "Excellent stay!"
            );
            record.displayRecord();
            System.out.println("✗ TEST 3 FAILED: Exception expected for invalid service cost\n");
        } catch (ReservationDataException e) {
            System.out.println("✓ TEST 3 PASSED: " + e.getMessage() + "\n");
        }

        // Test 4: Bill calculation
        System.out.println("TEST 4: Verifying total bill calculation...");
        try {
            ReservationRecord record = createSampleRecord(4, 5);
            double expectedTotal = record.getRoomCharge() + record.getServiceCharge();
            if (Math.abs(record.getTotalBill() - expectedTotal) < 0.001) {
                System.out.println("✓ TEST 4 PASSED: Total bill matches expected value\n");
            } else {
                System.out.println("✗ TEST 4 FAILED: Expected " + expectedTotal +
                                   " but got " + record.getTotalBill() + "\n");
            }
        } catch (ReservationDataException e) {
            System.out.println("✗ TEST 4 FAILED: " + e.getMessage() + "\n");
        }

        System.out.println("========== TESTING COMPLETE ==========");
    }

    private static ReservationRecord createSampleRecord(int id, int rating) throws ReservationDataException {
        ReservationRecord record = new ReservationRecord(
            id, "2025-01-01", "2025-01-02",
            "Grand Plaza", "456 Main St", "1234567890", "info@grandplaza.com",
            "204", "Deluxe", 180.0,
            "Mia Johnson", "mia@example.com", "0987654321",
            "2025-03-01", "2025-03-10", "2025-03-15",
            "Breakfast Package", 50.0,
            "Credit Card", "2025-01-02",
            900.0, 150.0,
            rating, "Wonderful experience."
        );
        record.generateBill();
        return record;
    }
}


