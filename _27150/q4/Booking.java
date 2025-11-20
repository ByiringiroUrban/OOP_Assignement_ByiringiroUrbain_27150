package _27150.q4;

/**
 * Booking class extending Customer with booking dates.
 */
public class Booking extends Customer {
    private String bookingDate;
    private String checkInDate;
    private String checkOutDate;

    public Booking(int id, String createdDate, String updatedDate,
                   String hotelName, String address, String phoneNumber, String email,
                   String roomNumber, String roomType, double pricePerNight,
                   String customerName, String customerEmail, String contactNumber,
                   String bookingDate, String checkInDate, String checkOutDate)
                   throws ReservationDataException {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email,
              roomNumber, roomType, pricePerNight,
              customerName, customerEmail, contactNumber);
        setBookingDate(bookingDate);
        setCheckInDate(checkInDate);
        setCheckOutDate(checkOutDate);
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) throws ReservationDataException {
        if (bookingDate == null || bookingDate.trim().isEmpty()) {
            throw new ReservationDataException("Booking date cannot be null or empty");
        }
        this.bookingDate = bookingDate;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) throws ReservationDataException {
        if (checkInDate == null || checkInDate.trim().isEmpty()) {
            throw new ReservationDataException("Check-in date cannot be null or empty");
        }
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) throws ReservationDataException {
        if (checkOutDate == null || checkOutDate.trim().isEmpty()) {
            throw new ReservationDataException("Check-out date cannot be null or empty");
        }
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return super.toString() + "\nBooking: " + bookingDate + ", Check-in: " + checkInDate +
               ", Check-out: " + checkOutDate;
    }
}


