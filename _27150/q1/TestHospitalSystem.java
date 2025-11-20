package _27150.q1;

import _27150.StudentOutput;

/**
 * Test class to verify Hospital Management System functionality
 */
public class TestHospitalSystem {
    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== TESTING HOSPITAL MANAGEMENT SYSTEM ==========\n");
        
        // Test 1: Valid data
        System.out.println("TEST 1: Creating HospitalRecord with valid data...");
        try {
            HospitalRecord record1 = new HospitalRecord(
                1, "2024-01-15", "2024-01-20",
                "John Doe", 35, "Male", "1234567890",
                "2024-01-15", "101", 500.00,
                "Fever", "Antibiotics and rest", 200.00,
                300.00, 150.00
            );
            record1.generateBill();
            record1.displayRecord();
            System.out.println("✓ TEST 1 PASSED: Valid data accepted\n");
        } catch (HospitalDataException e) {
            System.out.println("✗ TEST 1 FAILED: " + e.getMessage() + "\n");
        }
        
        // Test 2: Invalid ID (should fail)
        System.out.println("TEST 2: Testing invalid ID (0)...");
        try {
            HospitalRecord record2 = new HospitalRecord(
                0, "2024-01-15", "2024-01-20",
                "Jane Smith", 28, "Female", "9876543210",
                "2024-01-15", "102", 600.00,
                "Cold", "Medication", 150.00,
                250.00, 100.00
            );
            System.out.println("✗ TEST 2 FAILED: Should have thrown exception for invalid ID\n");
        } catch (HospitalDataException e) {
            System.out.println("✓ TEST 2 PASSED: Correctly caught invalid ID - " + e.getMessage() + "\n");
        }
        
        // Test 3: Invalid age (should fail)
        System.out.println("TEST 3: Testing invalid age (0)...");
        try {
            HospitalRecord record3 = new HospitalRecord(
                2, "2024-01-15", "2024-01-20",
                "Bob Johnson", 0, "Male", "5555555555",
                "2024-01-15", "103", 700.00,
                "Injury", "Surgery", 500.00,
                400.00, 200.00
            );
            System.out.println("✗ TEST 3 FAILED: Should have thrown exception for invalid age\n");
        } catch (HospitalDataException e) {
            System.out.println("✓ TEST 3 PASSED: Correctly caught invalid age - " + e.getMessage() + "\n");
        }
        
        // Test 4: Invalid gender (should fail)
        System.out.println("TEST 4: Testing invalid gender...");
        try {
            HospitalRecord record4 = new HospitalRecord(
                3, "2024-01-15", "2024-01-20",
                "Alice Brown", 45, "Unknown", "1111111111",
                "2024-01-15", "104", 550.00,
                "Checkup", "Routine exam", 100.00,
                200.00, 50.00
            );
            System.out.println("✗ TEST 4 FAILED: Should have thrown exception for invalid gender\n");
        } catch (HospitalDataException e) {
            System.out.println("✓ TEST 4 PASSED: Correctly caught invalid gender - " + e.getMessage() + "\n");
        }
        
        // Test 5: Invalid room charges (should fail)
        System.out.println("TEST 5: Testing invalid room charges (0)...");
        try {
            HospitalRecord record5 = new HospitalRecord(
                4, "2024-01-15", "2024-01-20",
                "Charlie Wilson", 30, "Male", "2222222222",
                "2024-01-15", "105", 0.00,
                "Fever", "Treatment", 150.00,
                250.00, 100.00
            );
            System.out.println("✗ TEST 5 FAILED: Should have thrown exception for invalid room charges\n");
        } catch (HospitalDataException e) {
            System.out.println("✓ TEST 5 PASSED: Correctly caught invalid room charges - " + e.getMessage() + "\n");
        }
        
        // Test 6: Bill calculation verification
        System.out.println("TEST 6: Verifying bill calculation...");
        try {
            HospitalRecord record6 = new HospitalRecord(
                5, "2024-01-15", "2024-01-20",
                "Diana Prince", 40, "Female", "3333333333",
                "2024-01-15", "106", 1000.00,  // roomCharges
                "Surgery", "Operation", 2000.00,  // treatmentCost
                1500.00,  // doctorFee
                500.00    // medicineCost
            );
            record6.generateBill();
            double expectedTotal = 1000.00 + 2000.00 + 1500.00 + 500.00; // 5000.00
            if (Math.abs(record6.getTotalBill() - expectedTotal) < 0.01) {
                System.out.println("✓ TEST 6 PASSED: Bill calculation is correct");
                System.out.println("  Expected: $" + String.format("%.2f", expectedTotal));
                System.out.println("  Actual: $" + String.format("%.2f", record6.getTotalBill()) + "\n");
            } else {
                System.out.println("✗ TEST 6 FAILED: Bill calculation is incorrect");
                System.out.println("  Expected: $" + String.format("%.2f", expectedTotal));
                System.out.println("  Actual: $" + String.format("%.2f", record6.getTotalBill()) + "\n");
            }
        } catch (HospitalDataException e) {
            System.out.println("✗ TEST 6 FAILED: " + e.getMessage() + "\n");
        }
        
        System.out.println("========== TESTING COMPLETE ==========");
    }
}

