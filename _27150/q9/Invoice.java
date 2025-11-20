package _27150.q9;

/**
 * Invoice class extending Payment with total fare.
 */
public class Invoice extends Payment {
    private double totalFare;

    public Invoice(int id, String createdDate, String updatedDate,
                   String airlineName, String address, String contactEmail,
                   String flightNumber, String destination, String departureTime,
                   String passengerName, String passportNumber, String nationality,
                   String seatNumber, String seatType,
                   String ticketNumber, double price,
                   double baggageWeight, double baggageFee,
                   String paymentDate, String paymentMode,
                   double totalFare)
                   throws TicketingDataException {
        super(id, createdDate, updatedDate, airlineName, address, contactEmail,
              flightNumber, destination, departureTime,
              passengerName, passportNumber, nationality,
              seatNumber, seatType,
              ticketNumber, price,
              baggageWeight, baggageFee,
              paymentDate, paymentMode);
        setTotalFare(totalFare);
    }

    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) throws TicketingDataException {
        if (totalFare <= 0) {
            throw new TicketingDataException("Total fare must be greater than 0");
        }
        this.totalFare = totalFare;
    }

    @Override
    public String toString() {
        return super.toString() + "\nInvoice Total Fare: $" + String.format("%.2f", totalFare);
    }
}


