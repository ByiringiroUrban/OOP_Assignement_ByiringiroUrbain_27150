package _27150.q9;

/**
 * Passenger class extending Flight with passenger details.
 */
public class Passenger extends Flight {
    private String passengerName;
    private String passportNumber;
    private String nationality;

    public Passenger(int id, String createdDate, String updatedDate,
                     String airlineName, String address, String contactEmail,
                     String flightNumber, String destination, String departureTime,
                     String passengerName, String passportNumber, String nationality)
                     throws TicketingDataException {
        super(id, createdDate, updatedDate, airlineName, address, contactEmail,
              flightNumber, destination, departureTime);
        setPassengerName(passengerName);
        setPassportNumber(passportNumber);
        setNationality(nationality);
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) throws TicketingDataException {
        if (passengerName == null || passengerName.trim().isEmpty()) {
            throw new TicketingDataException("Passenger name cannot be null or empty");
        }
        this.passengerName = passengerName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) throws TicketingDataException {
        if (passportNumber == null || passportNumber.trim().isEmpty()) {
            throw new TicketingDataException("Passport number cannot be null or empty");
        }
        this.passportNumber = passportNumber.toUpperCase();
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) throws TicketingDataException {
        if (nationality == null || nationality.trim().isEmpty()) {
            throw new TicketingDataException("Nationality cannot be null or empty");
        }
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPassenger: " + passengerName +
               ", Passport: " + passportNumber + ", Nationality: " + nationality;
    }
}


