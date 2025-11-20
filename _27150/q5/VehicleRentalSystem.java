package _27150.q5;

import java.util.Scanner;
import _27150.StudentOutput;

/**
 * Console runner for the Vehicle Rental System.
 */
public class VehicleRentalSystem {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== VEHICLE RENTAL SYSTEM ==========");

        try {
            int id = getInt("Enter Entity ID (> 0): ");
            String createdDate = getString("Created Date: ");
            String updatedDate = getString("Updated Date: ");

            System.out.println("\n--- COMPANY INFO ---");
            String companyName = getString("Company Name: ");
            String companyAddress = getString("Company Address: ");
            String companyPhone = getString("Company Phone (10 digits): ");

            System.out.println("\n--- BRANCH INFO ---");
            String branchName = getString("Branch Name: ");
            String locationCode = getString("Location Code (>= 3 chars): ");

            System.out.println("\n--- VEHICLE INFO ---");
            String vehicleType = getString("Vehicle Type: ");
            String registrationNumber = getString("Registration Number: ");
            double dailyRate = getDouble("Daily Rate (> 0): ");

            System.out.println("\n--- CUSTOMER INFO ---");
            String customerName = getString("Customer Name: ");
            String licenseNumber = getString("License Number: ");
            String contactNumber = getString("Customer Contact (10 digits): ");

            System.out.println("\n--- RENTAL INFO ---");
            String rentalDate = getString("Rental Date: ");
            String returnDate = getString("Return Date: ");
            int rentalDays = getInt("Rental Days (> 0): ");

            System.out.println("\n--- CHARGES INFO ---");
            double rentalCharge = getDouble("Rental Charge (>= 0): ");
            double penaltyCharge = getDouble("Penalty Charge (>= 0): ");

            System.out.println("\n--- PAYMENT INFO ---");
            String paymentMode = getString("Payment Mode: ");
            String transactionId = getString("Transaction ID: ");

            RentalRecord record = new RentalRecord(
                id, createdDate, updatedDate,
                companyName, companyAddress, companyPhone,
                branchName, locationCode,
                vehicleType, registrationNumber, dailyRate,
                customerName, licenseNumber, contactNumber,
                rentalDate, returnDate, rentalDays,
                rentalCharge, penaltyCharge,
                paymentMode, transactionId
            );

            record.calculateTotalCharge();
            record.displayRecord();

        } catch (RentalDataException e) {
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


