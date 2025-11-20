package _27150.q9;

/**
 * Airline class extending Entity with airline information.
 */
public class Airline extends Entity {
    private String airlineName;
    private String address;
    private String contactEmail;

    public Airline(int id, String createdDate, String updatedDate,
                   String airlineName, String address, String contactEmail)
                   throws TicketingDataException {
        super(id, createdDate, updatedDate);
        setAirlineName(airlineName);
        setAddress(address);
        setContactEmail(contactEmail);
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) throws TicketingDataException {
        if (airlineName == null || airlineName.trim().isEmpty()) {
            throw new TicketingDataException("Airline name cannot be null or empty");
        }
        this.airlineName = airlineName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws TicketingDataException {
        if (address == null || address.trim().isEmpty()) {
            throw new TicketingDataException("Address cannot be null or empty");
        }
        this.address = address;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) throws TicketingDataException {
        if (contactEmail == null || contactEmail.trim().isEmpty()) {
            throw new TicketingDataException("Contact email cannot be null or empty");
        }
        if (!contactEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new TicketingDataException("Invalid email format");
        }
        this.contactEmail = contactEmail;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAirline: " + airlineName + ", Address: " + address +
               ", Email: " + contactEmail;
    }
}


