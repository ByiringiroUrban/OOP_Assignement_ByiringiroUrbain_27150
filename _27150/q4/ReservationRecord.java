package _27150.q4;

/**
 * Final ReservationRecord class extending Feedback with business logic.
 */
public final class ReservationRecord extends Feedback {
    public ReservationRecord(int id, String createdDate, String updatedDate,
                             String hotelName, String address, String phoneNumber, String email,
                             String roomNumber, String roomType, double pricePerNight,
                             String customerName, String customerEmail, String contactNumber,
                             String bookingDate, String checkInDate, String checkOutDate,
                             String serviceName, double serviceCost,
                             String paymentMethod, String paymentDate,
                             double roomCharge, double serviceCharge,
                             int rating, String comments)
                             throws ReservationDataException {
        super(id, createdDate, updatedDate,
              hotelName, address, phoneNumber, email,
              roomNumber, roomType, pricePerNight,
              customerName, customerEmail, contactNumber,
              bookingDate, checkInDate, checkOutDate,
              serviceName, serviceCost,
              paymentMethod, paymentDate,
              roomCharge, serviceCharge, roomCharge + serviceCharge,
              rating, comments);
        generateBill();
    }

    /**
     * Calculates total bill as roomCharge + serviceCharge.
     */
    public void generateBill() {
        double total = getRoomCharge() + getServiceCharge();
        try {
            setTotalBill(total);
        } catch (ReservationDataException e) {
            throw new IllegalStateException("Failed to set total bill: " + e.getMessage(), e);
        }
    }

    public void displayRecord() {
        System.out.println("\n========== HOTEL RESERVATION RECORD ==========");
        System.out.println("Hotel: " + getHotelName() + " (" + getRoomType() + ")");
        System.out.println("Room Number: " + getRoomNumber() + ", Price/Night: $" + getPricePerNight());

        System.out.println("\n--- CUSTOMER INFO ---");
        System.out.println("Name: " + getCustomerName());
        System.out.println("Email: " + getCustomerEmail());
        System.out.println("Contact: " + getContactNumber());

        System.out.println("\n--- BOOKING DETAILS ---");
        System.out.println("Booking Date: " + getBookingDate());
        System.out.println("Check-In: " + getCheckInDate());
        System.out.println("Check-Out: " + getCheckOutDate());

        System.out.println("\n--- SERVICES ---");
        System.out.println("Service: " + getServiceName());
        System.out.println("Service Cost: $" + String.format("%.2f", getServiceCost()));

        System.out.println("\n--- PAYMENT ---");
        System.out.println("Method: " + getPaymentMethod());
        System.out.println("Payment Date: " + getPaymentDate());

        System.out.println("\n--- BILL ---");
        System.out.println("Room Charge: $" + String.format("%.2f", getRoomCharge()));
        System.out.println("Service Charge: $" + String.format("%.2f", getServiceCharge()));
        System.out.println("TOTAL BILL: $" + String.format("%.2f", getTotalBill()));

        System.out.println("\n--- FEEDBACK ---");
        System.out.println("Rating: " + getRating() + "/5");
        System.out.println("Comments: " + getComments());
        System.out.println("====================================================\n");
    }
}


