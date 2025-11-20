package _27150.q10;

import _27150.StudentOutput;

/**
 * Test harness for the Online Shopping System classes.
 */
public class TestShoppingSystem {
    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== TESTING ONLINE SHOPPING SYSTEM ==========\n");

        // Test 1: Valid order record
        System.out.println("TEST 1: Creating OrderRecord with valid data...");
        try {
            OrderRecord record = createSampleRecord(1, 15.0);
            record.displayRecord();
            System.out.println("✓ TEST 1 PASSED\n");
        } catch (ShoppingDataException e) {
            System.out.println("✗ TEST 1 FAILED: " + e.getMessage() + "\n");
        }

        // Test 2: Invalid price
        System.out.println("TEST 2: Expecting failure for price <= 0...");
        try {
            createSampleRecordWithPrice(0);
            System.out.println("✗ TEST 2 FAILED: Exception expected for invalid price\n");
        } catch (ShoppingDataException e) {
            System.out.println("✓ TEST 2 PASSED: " + e.getMessage() + "\n");
        }

        // Test 3: Total amount calculation
        System.out.println("TEST 3: Verifying total amount calculation...");
        try {
            OrderRecord record = createSampleRecord(3, 20.0);
            double expectedTotal = record.getPrice() + record.getShippingCost();
            if (Math.abs(record.getTotalAmount() - expectedTotal) < 0.001) {
                System.out.println("✓ TEST 3 PASSED: Total amount correct\n");
            } else {
                System.out.println("✗ TEST 3 FAILED: Expected " + expectedTotal +
                                   " but got " + record.getTotalAmount() + "\n");
            }
        } catch (ShoppingDataException e) {
            System.out.println("✗ TEST 3 FAILED: " + e.getMessage() + "\n");
        }

        System.out.println("========== TESTING COMPLETE ==========");
    }

    private static OrderRecord createSampleRecord(int id, double shippingCost) throws ShoppingDataException {
        OrderRecord record = new OrderRecord(
            id, "2025-01-01", "2025-01-02",
            "Mega Store", "123 Commerce St", "info@megastore.com",
            "Electronics", "ELC",
            "Smartphone", "PRD100", 650.0,
            "Ava Stone", "555-1234", "456 Market Ave",
            "2025-02-10", "ORD100" + id,
            "Card", "Paid",
            "789 Delivery Rd", shippingCost
        );
        record.calculateTotalAmount();
        return record;
    }

    private static void createSampleRecordWithPrice(double price) throws ShoppingDataException {
        new OrderRecord(
            2, "2025-01-01", "2025-01-02",
            "Mega Store", "123 Commerce St", "info@megastore.com",
            "Electronics", "ELC",
            "Smartphone", "PRD101", price,
            "Ava Stone", "555-1234", "456 Market Ave",
            "2025-02-10", "ORD101",
            "Card", "Paid",
            "789 Delivery Rd", 15.0
        );
    }
}


