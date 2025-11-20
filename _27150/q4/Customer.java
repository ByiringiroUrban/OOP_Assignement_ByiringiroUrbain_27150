package _27150.q4;

/**
 * Customer class extending Room with customer details.
 */
public class Customer extends Room {
    private String customerName;
    private String customerEmail;
    private String contactNumber;

    public Customer(int id, String createdDate, String updatedDate,
                    String hotelName, String address, String phoneNumber, String email,
                    String roomNumber, String roomType, double pricePerNight,
                    String customerName, String customerEmail, String contactNumber)
                    throws ReservationDataException {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email,
              roomNumber, roomType, pricePerNight);
        setCustomerName(customerName);
        setCustomerEmail(customerEmail);
        setContactNumber(contactNumber);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) throws ReservationDataException {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new ReservationDataException("Customer name cannot be null or empty");
        }
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) throws ReservationDataException {
        validateEmail(customerEmail);
        this.customerEmail = customerEmail;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) throws ReservationDataException {
        validatePhone(contactNumber);
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCustomer: " + customerName +
               ", Email: " + customerEmail + ", Contact: " + contactNumber;
    }
}


