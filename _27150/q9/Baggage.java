package _27150.q9;

/**
 * Baggage class extending Ticket with baggage information.
 */
public class Baggage extends Ticket {
    private double baggageWeight;
    private double baggageFee;

    public Baggage(int id, String createdDate, String updatedDate,
                   String airlineName, String address, String contactEmail,
                   String flightNumber, String destination, String departureTime,
                   String passengerName, String passportNumber, String nationality,
                   String seatNumber, String seatType,
                   String ticketNumber, double price,
                   double baggageWeight, double baggageFee)
                   throws TicketingDataException {
        super(id, createdDate, updatedDate, airlineName, address, contactEmail,
              flightNumber, destination, departureTime,
              passengerName, passportNumber, nationality,
              seatNumber, seatType,
              ticketNumber, price);
        setBaggageWeight(baggageWeight);
        setBaggageFee(baggageFee);
    }

    public double getBaggageWeight() {
        return baggageWeight;
    }

    public void setBaggageWeight(double baggageWeight) throws TicketingDataException {
        if (baggageWeight < 0) {
            throw new TicketingDataException("Baggage weight cannot be negative");
        }
        this.baggageWeight = baggageWeight;
    }

    public double getBaggageFee() {
        return baggageFee;
    }

    public void setBaggageFee(double baggageFee) throws TicketingDataException {
        if (baggageFee < 0) {
            throw new TicketingDataException("Baggage fee cannot be negative");
        }
        this.baggageFee = baggageFee;
    }

    @Override
    public String toString() {
        return super.toString() + "\nBaggage: " + baggageWeight + "kg, Fee: $" + baggageFee;
    }
}


