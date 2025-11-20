package _27150.q9;

/**
 * Seat class extending Passenger with seat information.
 */
public class Seat extends Passenger {
    private String seatNumber;
    private String seatType;

    public Seat(int id, String createdDate, String updatedDate,
                String airlineName, String address, String contactEmail,
                String flightNumber, String destination, String departureTime,
                String passengerName, String passportNumber, String nationality,
                String seatNumber, String seatType)
                throws TicketingDataException {
        super(id, createdDate, updatedDate, airlineName, address, contactEmail,
              flightNumber, destination, departureTime,
              passengerName, passportNumber, nationality);
        setSeatNumber(seatNumber);
        setSeatType(seatType);
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) throws TicketingDataException {
        if (seatNumber == null || seatNumber.trim().isEmpty()) {
            throw new TicketingDataException("Seat number cannot be null or empty");
        }
        this.seatNumber = seatNumber.toUpperCase();
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) throws TicketingDataException {
        if (seatType == null || seatType.trim().isEmpty()) {
            throw new TicketingDataException("Seat type cannot be null or empty");
        }
        if (!(seatType.equalsIgnoreCase("Economy") || seatType.equalsIgnoreCase("Business"))) {
            throw new TicketingDataException("Seat type must be 'Economy' or 'Business'");
        }
        this.seatType = seatType.substring(0, 1).toUpperCase() + seatType.substring(1).toLowerCase();
    }

    @Override
    public String toString() {
        return super.toString() + "\nSeat: " + seatNumber + " (" + seatType + ")";
    }
}


