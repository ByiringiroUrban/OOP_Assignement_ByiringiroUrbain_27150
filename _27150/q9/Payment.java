package _27150.q9;

/**
 * Payment class extending Baggage with payment details.
 */
public class Payment extends Baggage {
    private String paymentDate;
    private String paymentMode;

    public Payment(int id, String createdDate, String updatedDate,
                   String airlineName, String address, String contactEmail,
                   String flightNumber, String destination, String departureTime,
                   String passengerName, String passportNumber, String nationality,
                   String seatNumber, String seatType,
                   String ticketNumber, double price,
                   double baggageWeight, double baggageFee,
                   String paymentDate, String paymentMode)
                   throws TicketingDataException {
        super(id, createdDate, updatedDate, airlineName, address, contactEmail,
              flightNumber, destination, departureTime,
              passengerName, passportNumber, nationality,
              seatNumber, seatType,
              ticketNumber, price,
              baggageWeight, baggageFee);
        setPaymentDate(paymentDate);
        setPaymentMode(paymentMode);
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) throws TicketingDataException {
        if (paymentDate == null || paymentDate.trim().isEmpty()) {
            throw new TicketingDataException("Payment date cannot be null or empty");
        }
        this.paymentDate = paymentDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) throws TicketingDataException {
        if (paymentMode == null || paymentMode.trim().isEmpty()) {
            throw new TicketingDataException("Payment mode cannot be null or empty");
        }
        this.paymentMode = paymentMode;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPayment: " + paymentMode + " on " + paymentDate;
    }
}


