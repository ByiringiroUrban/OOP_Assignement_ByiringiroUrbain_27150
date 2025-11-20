package _27150.q7;

import java.util.Scanner;
import _27150.StudentOutput;

/**
 * Console runner for the Real Estate Management System.
 */
public class RealEstateManagementSystem {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== REAL ESTATE MANAGEMENT SYSTEM ==========");

        try {
            int id = getInt("Enter Entity ID (> 0): ");
            String createdDate = getString("Created Date: ");
            String updatedDate = getString("Updated Date: ");

            System.out.println("\n--- AGENCY INFO ---");
            String agencyName = getString("Agency Name: ");
            String location = getString("Location: ");
            String phone = getString("Agency Phone (10 digits): ");

            System.out.println("\n--- AGENT INFO ---");
            String agentName = getString("Agent Name: ");
            String agentEmail = getString("Agent Email: ");
            String licenseNumber = getString("License Number: ");

            System.out.println("\n--- PROPERTY INFO ---");
            String propertyCode = getString("Property Code: ");
            String propertyType = getString("Property Type: ");
            double price = getDouble("Property Price (> 0): ");

            System.out.println("\n--- SELLER INFO ---");
            String sellerName = getString("Seller Name: ");
            String sellerContact = getString("Seller Contact (10 digits): ");

            System.out.println("\n--- BUYER INFO ---");
            String buyerName = getString("Buyer Name: ");
            String buyerEmail = getString("Buyer Email: ");

            System.out.println("\n--- AGREEMENT INFO ---");
            String agreementDate = getString("Agreement Date: ");
            String terms = getString("Agreement Terms: ");

            System.out.println("\n--- PAYMENT INFO ---");
            double paymentAmount = getDouble("Payment Amount (> 0): ");
            String paymentDate = getString("Payment Date: ");

            System.out.println("\n--- COMMISSION INFO ---");
            double commissionRate = getDouble("Commission Rate (>= 0): ");

            RealEstateRecord record = new RealEstateRecord(
                id, createdDate, updatedDate,
                agencyName, location, phone,
                agentName, agentEmail, licenseNumber,
                propertyCode, propertyType, price,
                sellerName, sellerContact,
                buyerName, buyerEmail,
                agreementDate, terms,
                paymentAmount, paymentDate,
                commissionRate
            );

            record.calculateCommission();
            record.displayRecord();

        } catch (RealEstateDataException e) {
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


