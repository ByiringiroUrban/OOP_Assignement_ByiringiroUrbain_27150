package _27150.q4;

/**
 * Payment class extending Service with payment details.
 */
public class Payment extends Service {
    private String paymentMethod;
    private String paymentDate;

    public Payment(int id, String createdDate, String updatedDate,
                   String hotelName, String address, String phoneNumber, String email,
                   String roomNumber, String roomType, double pricePerNight,
                   String customerName, String customerEmail, String contactNumber,
                   String bookingDate, String checkInDate, String checkOutDate,
                   String serviceName, double serviceCost,
                   String paymentMethod, String paymentDate)
                   throws ReservationDataException {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email,
              roomNumber, roomType, pricePerNight,
              customerName, customerEmail, contactNumber,
              bookingDate, checkInDate, checkOutDate,
              serviceName, serviceCost);
        setPaymentMethod(paymentMethod);
        setPaymentDate(paymentDate);
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) throws ReservationDataException {
        if (paymentMethod == null || paymentMethod.trim().isEmpty()) {
            throw new ReservationDataException("Payment method cannot be null or empty");
        }
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) throws ReservationDataException {
        if (paymentDate == null || paymentDate.trim().isEmpty()) {
            throw new ReservationDataException("Payment date cannot be null or empty");
        }
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPayment: " + paymentMethod + ", Date: " + paymentDate;
    }
}


