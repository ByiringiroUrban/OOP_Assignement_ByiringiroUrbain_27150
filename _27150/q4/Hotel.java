package _27150.q4;

/**
 * Hotel class extending Entity with hotel-specific details.
 */
public class Hotel extends Entity {
    private String hotelName;
    private String address;
    private String phoneNumber;
    private String email;

    public Hotel(int id, String createdDate, String updatedDate,
                 String hotelName, String address, String phoneNumber, String email)
                 throws ReservationDataException {
        super(id, createdDate, updatedDate);
        setHotelName(hotelName);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) throws ReservationDataException {
        if (hotelName == null || hotelName.trim().isEmpty()) {
            throw new ReservationDataException("Hotel name cannot be null or empty");
        }
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws ReservationDataException {
        if (address == null || address.trim().isEmpty()) {
            throw new ReservationDataException("Address cannot be null or empty");
        }
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws ReservationDataException {
        validatePhone(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ReservationDataException {
        validateEmail(email);
        this.email = email;
    }

    protected void validatePhone(String phone) throws ReservationDataException {
        if (phone == null || phone.trim().isEmpty()) {
            throw new ReservationDataException("Phone number cannot be null or empty");
        }
        String digitsOnly = phone.replaceAll("[^0-9]", "");
        if (digitsOnly.length() != 10) {
            throw new ReservationDataException("Phone number must contain exactly 10 digits");
        }
    }

    protected void validateEmail(String email) throws ReservationDataException {
        if (email == null || email.trim().isEmpty()) {
            throw new ReservationDataException("Email cannot be null or empty");
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new ReservationDataException("Invalid email format");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nHotel: " + hotelName + ", Address: " + address +
               ", Phone: " + phoneNumber + ", Email: " + email;
    }
}


