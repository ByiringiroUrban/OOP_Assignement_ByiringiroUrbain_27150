package _27150.q4;

/**
 * Feedback class extending Bill with customer feedback data.
 */
public class Feedback extends Bill {
    private int rating;
    private String comments;

    public Feedback(int id, String createdDate, String updatedDate,
                    String hotelName, String address, String phoneNumber, String email,
                    String roomNumber, String roomType, double pricePerNight,
                    String customerName, String customerEmail, String contactNumber,
                    String bookingDate, String checkInDate, String checkOutDate,
                    String serviceName, double serviceCost,
                    String paymentMethod, String paymentDate,
                    double roomCharge, double serviceCharge, double totalBill,
                    int rating, String comments)
                    throws ReservationDataException {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email,
              roomNumber, roomType, pricePerNight,
              customerName, customerEmail, contactNumber,
              bookingDate, checkInDate, checkOutDate,
              serviceName, serviceCost,
              paymentMethod, paymentDate,
              roomCharge, serviceCharge, totalBill);
        setRating(rating);
        setComments(comments);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) throws ReservationDataException {
        if (rating < 1 || rating > 5) {
            throw new ReservationDataException("Rating must be between 1 and 5");
        }
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) throws ReservationDataException {
        if (comments == null || comments.trim().isEmpty()) {
            throw new ReservationDataException("Comments cannot be null or empty");
        }
        this.comments = comments;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFeedback: Rating " + rating + "/5, Comments: " + comments;
    }
}


