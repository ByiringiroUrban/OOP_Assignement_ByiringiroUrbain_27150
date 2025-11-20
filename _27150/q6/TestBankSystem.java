package _27150.q6;

import _27150.StudentOutput;

/**
 * Test harness for the Banking System classes.
 */
public class TestBankSystem {
    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== TESTING BANKING SYSTEM ==========\n");

        // Test 1: Valid record
        System.out.println("TEST 1: Creating AccountRecord with valid data...");
        try {
            AccountRecord record = createSampleRecord(1, 5000, 2000);
            record.displayRecord();
            System.out.println("✓ TEST 1 PASSED\n");
        } catch (BankDataException e) {
            System.out.println("✗ TEST 1 FAILED: " + e.getMessage() + "\n");
        }

        // Test 2: Invalid account ID
        System.out.println("TEST 2: Expecting failure for invalid ID (0)...");
        try {
            createSampleRecord(0, 3000, 1000);
            System.out.println("✗ TEST 2 FAILED: Exception expected for invalid ID\n");
        } catch (BankDataException e) {
            System.out.println("✓ TEST 2 PASSED: " + e.getMessage() + "\n");
        }

        // Test 3: Negative balance
        System.out.println("TEST 3: Expecting failure for negative balance...");
        try {
            new AccountRecord(
                3, "2025-01-01", "2025-01-05",
                "Unity Bank", "UB001", "456 Finance St",
                "AC5678", "Current", -100,
                "Nora Lee", "nora@bank.com", "1234567890",
                "TX1003", "Withdrawal", 150,
                500, "2025-02-01",
                300, "2025-02-10",
                8000, 6.5, 4,
                400, "2025-02-15"
            );
            System.out.println("✗ TEST 3 FAILED: Exception expected for balance\n");
        } catch (BankDataException e) {
            System.out.println("✓ TEST 3 PASSED: " + e.getMessage() + "\n");
        }

        // Test 4: Interest calculation
        System.out.println("TEST 4: Verifying interest calculation...");
        try {
            AccountRecord record = createSampleRecord(4, 6000, 2500);
            double expectedInterest = (record.getLoanAmount() * record.getInterestRate() * record.getDuration()) / 100.0;
            double actualInterest = record.calculateInterest();
            if (Math.abs(actualInterest - expectedInterest) < 0.001) {
                System.out.println("✓ TEST 4 PASSED: Interest calculation correct\n");
            } else {
                System.out.println("✗ TEST 4 FAILED: Expected " + expectedInterest +
                                   " but got " + actualInterest + "\n");
            }
        } catch (BankDataException e) {
            System.out.println("✗ TEST 4 FAILED: " + e.getMessage() + "\n");
        }

        System.out.println("========== TESTING COMPLETE ==========");
    }

    private static AccountRecord createSampleRecord(int id, double loanAmount, double paymentAmount)
            throws BankDataException {
        return new AccountRecord(
            id, "2025-01-01", "2025-01-02",
            "Unity Bank", "UB001", "123 Finance St",
            "AC1234", "Savings", 2500,
            "Ava Carter", "ava@bank.com", "0987654321",
            "TX1001", "Deposit", 300,
            300, "2025-02-01",
            200, "2025-02-05",
            loanAmount, 5.5, 3,
            paymentAmount, "2025-02-10"
        );
    }
}


