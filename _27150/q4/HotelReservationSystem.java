package _27150.q4;

import java.util.Scanner;
import _27150.StudentOutput;

/**
 * Console runner for the Hotel Reservation System.
 */
public class HotelReservationSystem {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== HOTEL RESERVATION SYSTEM ==========");

        try {
            int id = getInt("Enter Entity ID (> 0): ");
            String createdDate = getString("Created Date: ");
            String updatedDate = getString("Updated Date: ");

            System.out.println("\n--- HOTEL INFO ---");
            String hotelName = getString("Hotel Name: ");
            String address = getString("Address: ");
            String phone = getString("Hotel Phone (10 digits): ");
            String email = getString("Hotel Email: ");

            System.out.println("\n--- ROOM INFO ---");
            String roomNumber = getString("Room Number: ");
            String roomType = getString("Room Type: ");
            double pricePerNight = getDouble("Price per Night (> 0): ");

            System.out.println("\n--- CUSTOMER INFO ---");
            String customerName = getString("Customer Name: ");
            String customerEmail = getString("Customer Email: ");
            String contactNumber = getString("Customer Contact (10 digits): ");

            System.out.println("\n--- BOOKING INFO ---");
            String bookingDate = getString("Booking Date: ");
            String checkInDate = getString("Check-in Date: ");
            String checkOutDate = getString("Check-out Date: ");

            System.out.println("\n--- SERVICE INFO ---");
            String serviceName = getString("Service Name: ");
            double serviceCost = getDouble("Service Cost (> 0): ");

            System.out.println("\n--- PAYMENT INFO ---");
            String paymentMethod = getString("Payment Method: ");
            String paymentDate = getString("Payment Date: ");

            System.out.println("\n--- BILL INFO ---");
            double roomCharge = getDouble("Room Charge (> 0): ");
            double serviceCharge = getDouble("Service Charge (> 0): ");

            System.out.println("\n--- FEEDBACK INFO ---");
            int rating = getInt("Rating (1-5): ");
            String comments = getString("Comments: ");

            ReservationRecord record = new ReservationRecord(
                id, createdDate, updatedDate,
                hotelName, address, phone, email,
                roomNumber, roomType, pricePerNight,
                customerName, customerEmail, contactNumber,
                bookingDate, checkInDate, checkOutDate,
                serviceName, serviceCost,
                paymentMethod, paymentDate,
                roomCharge, serviceCharge,
                rating, comments
            );

            record.generateBill();
            record.displayRecord();

        } catch (ReservationDataException e) {
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
                System.out.println("Invalid integer, try again.");
            }
        }
    }

    private static double getDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(SCANNER.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number, try again.");
            }
        }
    }
}


