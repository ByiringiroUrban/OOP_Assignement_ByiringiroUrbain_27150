package _27150.q9;

import _27150.StudentOutput;

/**
 * Test harness for the Airline Ticketing System classes.
 */
public class TestTicketingSystem {
    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== TESTING AIRLINE TICKETING SYSTEM ==========\n");

        // Test 1: Valid ticket record
        System.out.println("TEST 1: Creating TicketRecord with valid data...");
        try {
            TicketRecord record = createSampleRecord(1, "Economy");
            record.displayRecord();
            System.out.println("✓ TEST 1 PASSED\n");
        } catch (TicketingDataException e) {
            System.out.println("✗ TEST 1 FAILED: " + e.getMessage() + "\n");
        }

        // Test 2: Invalid seat type
        System.out.println("TEST 2: Expecting failure for invalid seat type...");
        try {
            createSampleRecord(2, "Premium");
            System.out.println("✗ TEST 2 FAILED: Exception expected for invalid seat type\n");
        } catch (TicketingDataException e) {
            System.out.println("✓ TEST 2 PASSED: " + e.getMessage() + "\n");
        }

        // Test 3: Invoice calculation
        System.out.println("TEST 3: Verifying invoice calculation...");
        try {
            TicketRecord record = createSampleRecord(3, "Business");
            double expectedTotal = record.getPrice() + record.getBaggageFee();
            if (Math.abs(record.getTotalFare() - expectedTotal) < 0.001) {
                System.out.println("✓ TEST 3 PASSED: Invoice total correct\n");
            } else {
                System.out.println("✗ TEST 3 FAILED: Expected " + expectedTotal +
                                   " but got " + record.getTotalFare() + "\n");
            }
        } catch (TicketingDataException e) {
            System.out.println("✗ TEST 3 FAILED: " + e.getMessage() + "\n");
        }

        System.out.println("========== TESTING COMPLETE ==========");
    }

    private static TicketRecord createSampleRecord(int id, String seatType) throws TicketingDataException {
        TicketRecord record = new TicketRecord(
            id, "2025-01-01", "2025-01-02",
            "SkyAir", "123 Aviation Ave", "support@skyair.com",
            "SK123", "Paris", "2025-03-01 10:00",
            "Liam Brown", "P1234567", "USA",
            "12A", seatType,
            "TCKT100" + id, 500.0,
            15.0, 50.0,
            "2025-02-10", "Credit Card"
        );
        record.generateInvoice();
        return record;
    }
}


