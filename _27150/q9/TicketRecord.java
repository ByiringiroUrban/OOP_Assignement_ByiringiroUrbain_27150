package _27150.q9;

/**
 * Final TicketRecord class extending Invoice with invoice generation.
 */
public final class TicketRecord extends Invoice {
    public TicketRecord(int id, String createdDate, String updatedDate,
                        String airlineName, String address, String contactEmail,
                        String flightNumber, String destination, String departureTime,
                        String passengerName, String passportNumber, String nationality,
                        String seatNumber, String seatType,
                        String ticketNumber, double price,
                        double baggageWeight, double baggageFee,
                        String paymentDate, String paymentMode)
                        throws TicketingDataException {
        super(id, createdDate, updatedDate,
              airlineName, address, contactEmail,
              flightNumber, destination, departureTime,
              passengerName, passportNumber, nationality,
              seatNumber, seatType,
              ticketNumber, price,
              baggageWeight, baggageFee,
              paymentDate, paymentMode,
              Math.max(0.01, price + baggageFee));
        generateInvoice();
    }

    public double generateInvoice() {
        double total = getPrice() + getBaggageFee();
        if (total <= 0) {
            total = getPrice();
        }
        try {
            setTotalFare(total);
        } catch (TicketingDataException e) {
            throw new IllegalStateException("Failed to set total fare: " + e.getMessage(), e);
        }
        return total;
    }

    public void displayRecord() {
        System.out.println("\n========== TICKET RECORD ==========");
        System.out.println("Airline: " + getAirlineName() + " (" + getContactEmail() + ")");
        System.out.println("Flight: " + getFlightNumber() + " to " + getDestination());
        System.out.println("Departure: " + getDepartureTime());

        System.out.println("\n--- PASSENGER ---");
        System.out.println("Name: " + getPassengerName());
        System.out.println("Passport: " + getPassportNumber());
        System.out.println("Nationality: " + getNationality());

        System.out.println("\n--- SEAT ---");
        System.out.println("Seat Number: " + getSeatNumber());
        System.out.println("Seat Type: " + getSeatType());

        System.out.println("\n--- TICKET ---");
        System.out.println("Ticket Number: " + getTicketNumber());
        System.out.println("Ticket Price: $" + String.format("%.2f", getPrice()));

        System.out.println("\n--- BAGGAGE ---");
        System.out.println("Weight: " + getBaggageWeight() + " kg");
        System.out.println("Baggage Fee: $" + String.format("%.2f", getBaggageFee()));

        System.out.println("\n--- PAYMENT ---");
        System.out.println("Date: " + getPaymentDate());
        System.out.println("Mode: " + getPaymentMode());

        System.out.println("\n--- INVOICE ---");
        System.out.println("Total Fare: $" + String.format("%.2f", getTotalFare()));
        System.out.println("===================================\n");
    }
}


