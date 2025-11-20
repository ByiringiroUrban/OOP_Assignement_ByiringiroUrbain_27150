package _27150.q9;

/**
 * Ticket class extending Seat with ticket details.
 */
public class Ticket extends Seat {
    private String ticketNumber;
    private double price;

    public Ticket(int id, String createdDate, String updatedDate,
                  String airlineName, String address, String contactEmail,
                  String flightNumber, String destination, String departureTime,
                  String passengerName, String passportNumber, String nationality,
                  String seatNumber, String seatType,
                  String ticketNumber, double price)
                  throws TicketingDataException {
        super(id, createdDate, updatedDate, airlineName, address, contactEmail,
              flightNumber, destination, departureTime,
              passengerName, passportNumber, nationality,
              seatNumber, seatType);
        setTicketNumber(ticketNumber);
        setPrice(price);
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) throws TicketingDataException {
        if (ticketNumber == null || ticketNumber.trim().isEmpty()) {
            throw new TicketingDataException("Ticket number cannot be null or empty");
        }
        this.ticketNumber = ticketNumber.toUpperCase();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws TicketingDataException {
        if (price <= 0) {
            throw new TicketingDataException("Ticket price must be greater than 0");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTicket: " + ticketNumber + ", Price: $" + price;
    }
}


