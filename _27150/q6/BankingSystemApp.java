package _27150.q6;

import java.util.Scanner;
import _27150.StudentOutput;

/**
 * Console runner for Banking System.
 */
public class BankingSystemApp {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== BANKING SYSTEM ==========");

        try {
            int id = getInt("Enter Entity ID (> 0): ");
            String createdDate = getString("Created Date: ");
            String updatedDate = getString("Updated Date: ");

            System.out.println("\n--- BANK INFO ---");
            String bankName = getString("Bank Name: ");
            String branchCode = getString("Branch Code (>= 3 chars): ");
            String address = getString("Bank Address: ");

            System.out.println("\n--- ACCOUNT INFO ---");
            String accountNumber = getString("Account Number: ");
            String accountType = getString("Account Type: ");
            double balance = getDouble("Balance (>= 0): ");

            System.out.println("\n--- CUSTOMER INFO ---");
            String customerName = getString("Customer Name: ");
            String email = getString("Customer Email: ");
            String phone = getString("Customer Phone (10 digits): ");

            System.out.println("\n--- TRANSACTION INFO ---");
            String transactionId = getString("Transaction ID: ");
            String transactionType = getString("Transaction Type: ");
            double transactionAmount = getDouble("Transaction Amount (> 0): ");

            System.out.println("\n--- DEPOSIT INFO ---");
            double depositAmount = getDouble("Deposit Amount (> 0): ");
            String depositDate = getString("Deposit Date: ");

            System.out.println("\n--- WITHDRAWAL INFO ---");
            double withdrawalAmount = getDouble("Withdrawal Amount (> 0): ");
            String withdrawalDate = getString("Withdrawal Date: ");

            System.out.println("\n--- LOAN INFO ---");
            double loanAmount = getDouble("Loan Amount (> 0): ");
            double interestRate = getDouble("Interest Rate (> 0): ");
            double duration = getDouble("Duration in years (> 0): ");

            System.out.println("\n--- PAYMENT INFO ---");
            double paymentAmount = getDouble("Payment Amount (> 0): ");
            String paymentDate = getString("Payment Date: ");

            AccountRecord record = new AccountRecord(
                id, createdDate, updatedDate,
                bankName, branchCode, address,
                accountNumber, accountType, balance,
                customerName, email, phone,
                transactionId, transactionType, transactionAmount,
                depositAmount, depositDate,
                withdrawalAmount, withdrawalDate,
                loanAmount, interestRate, duration,
                paymentAmount, paymentDate
            );

            record.displayRecord();

        } catch (BankDataException e) {
            System.out.println("\nERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\nUNEXPECTED ERROR: " + e.getMessage());
            e.printStackTrace();
        } finally {
            SCANNER.close();
        }
    }

    private static String getString(String prompt) {
        System.out.print(prompt);
        String value = SCANNER.nextLine().trim();
        while (value.isEmpty()) {
            System.out.print("Value cannot be empty. " + prompt);
            value = SCANNER.nextLine().trim();
        }
        return value;
    }

    private static int getInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(SCANNER.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid integer. Try again.");
            }
        }
    }

    private static double getDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(SCANNER.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }
}


