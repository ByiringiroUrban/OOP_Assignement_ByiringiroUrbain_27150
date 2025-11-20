package _27150.q9;

import java.util.Scanner;
import _27150.StudentOutput;

/**
 * Console runner for the Airline Ticketing System.
 */
public class AirlineTicketingSystem {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== AIRLINE TICKETING SYSTEM ==========");

        try {
            int id = getInt("Enter Entity ID (> 0): ");
            String createdDate = getString("Created Date: ");
            String updatedDate = getString("Updated Date: ");

            System.out.println("\n--- AIRLINE INFO ---");
            String airlineName = getString("Airline Name: ");
            String address = getString("Airline Address: ");
            String contactEmail = getString("Contact Email: ");

            System.out.println("\n--- FLIGHT INFO ---");
            String flightNumber = getString("Flight Number: ");
            String destination = getString("Destination: ");
            String departureTime = getString("Departure Time: ");

            System.out.println("\n--- PASSENGER INFO ---");
            String passengerName = getString("Passenger Name: ");
            String passportNumber = getString("Passport Number: ");
            String nationality = getString("Nationality: ");

            System.out.println("\n--- SEAT INFO ---");
            String seatNumber = getString("Seat Number: ");
            String seatType = getString("Seat Type (Economy/Business): ");

            System.out.println("\n--- TICKET INFO ---");
            String ticketNumber = getString("Ticket Number: ");
            double price = getDouble("Ticket Price (> 0): ");

            System.out.println("\n--- BAGGAGE INFO ---");
            double baggageWeight = getDouble("Baggage Weight (kg, >= 0): ");
            double baggageFee = getDouble("Baggage Fee (>= 0): ");

            System.out.println("\n--- PAYMENT INFO ---");
            String paymentDate = getString("Payment Date: ");
            String paymentMode = getString("Payment Mode: ");

            TicketRecord record = new TicketRecord(
                id, createdDate, updatedDate,
                airlineName, address, contactEmail,
                flightNumber, destination, departureTime,
                passengerName, passportNumber, nationality,
                seatNumber, seatType,
                ticketNumber, price,
                baggageWeight, baggageFee,
                paymentDate, paymentMode
            );

            record.generateInvoice();
            record.displayRecord();

        } catch (TicketingDataException e) {
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


