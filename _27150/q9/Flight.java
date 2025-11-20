package _27150.q9;

/**
 * Flight class extending Airline with flight details.
 */
public class Flight extends Airline {
    private String flightNumber;
    private String destination;
    private String departureTime;

    public Flight(int id, String createdDate, String updatedDate,
                  String airlineName, String address, String contactEmail,
                  String flightNumber, String destination, String departureTime)
                  throws TicketingDataException {
        super(id, createdDate, updatedDate, airlineName, address, contactEmail);
        setFlightNumber(flightNumber);
        setDestination(destination);
        setDepartureTime(departureTime);
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) throws TicketingDataException {
        if (flightNumber == null || flightNumber.trim().isEmpty()) {
            throw new TicketingDataException("Flight number cannot be null or empty");
        }
        this.flightNumber = flightNumber.toUpperCase();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) throws TicketingDataException {
        if (destination == null || destination.trim().isEmpty()) {
            throw new TicketingDataException("Destination cannot be null or empty");
        }
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) throws TicketingDataException {
        if (departureTime == null || departureTime.trim().isEmpty()) {
            throw new TicketingDataException("Departure time cannot be null or empty");
        }
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFlight: " + flightNumber + ", Destination: " + destination +
               ", Departure: " + departureTime;
    }
}


