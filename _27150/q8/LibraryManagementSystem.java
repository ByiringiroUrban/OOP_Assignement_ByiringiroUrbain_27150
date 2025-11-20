package _27150.q8;

import java.util.Scanner;
import _27150.StudentOutput;

/**
 * Console runner for the Library Management System.
 */
public class LibraryManagementSystem {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== LIBRARY MANAGEMENT SYSTEM ==========");

        try {
            int id = getInt("Enter Entity ID (> 0): ");
            String createdDate = getString("Created Date: ");
            String updatedDate = getString("Updated Date: ");

            System.out.println("\n--- LIBRARY INFO ---");
            String libraryName = getString("Library Name: ");
            String location = getString("Location: ");
            String phone = getString("Library Phone (10 digits): ");

            System.out.println("\n--- SECTION INFO ---");
            String sectionName = getString("Section Name: ");
            String sectionCode = getString("Section Code (>= 3 chars): ");

            System.out.println("\n--- BOOK INFO ---");
            String title = getString("Book Title: ");
            String author = getString("Author: ");
            String isbn = getString("ISBN (>= 10 chars): ");

            System.out.println("\n--- MEMBER INFO ---");
            String memberName = getString("Member Name: ");
            int memberId = getInt("Member ID (> 0): ");
            String contactNumber = getString("Member Contact (10 digits): ");

            System.out.println("\n--- BORROW INFO ---");
            String borrowDate = getString("Borrow Date: ");
            String returnDate = getString("Return Date: ");

            System.out.println("\n--- FINE INFO ---");
            double fineAmount = getDouble("Fine Amount (>= 0): ");
            int daysLate = getInt("Days Late (>= 0): ");

            System.out.println("\n--- PAYMENT INFO ---");
            String paymentDate = getString("Payment Date: ");
            String paymentMode = getString("Payment Mode: ");

            LibraryRecord record = new LibraryRecord(
                id, createdDate, updatedDate,
                libraryName, location, phone,
                sectionName, sectionCode,
                title, author, isbn,
                memberName, memberId, contactNumber,
                borrowDate, returnDate,
                fineAmount, daysLate,
                paymentDate, paymentMode
            );

            record.calculateFine();
            record.displayRecord();

        } catch (LibraryDataException e) {
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


