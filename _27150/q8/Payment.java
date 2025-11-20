package _27150.q8;

/**
 * Payment class extending Fine with payment details.
 */
public class Payment extends Fine {
    private String paymentDate;
    private String paymentMode;

    public Payment(int id, String createdDate, String updatedDate,
                   String libraryName, String location, String phoneNumber,
                   String sectionName, String sectionCode,
                   String title, String author, String isbn,
                   String memberName, int memberId, String contactNumber,
                   String borrowDate, String returnDate,
                   double fineAmount, int daysLate,
                   String paymentDate, String paymentMode)
                   throws LibraryDataException {
        super(id, createdDate, updatedDate, libraryName, location, phoneNumber,
              sectionName, sectionCode,
              title, author, isbn,
              memberName, memberId, contactNumber,
              borrowDate, returnDate,
              fineAmount, daysLate);
        setPaymentDate(paymentDate);
        setPaymentMode(paymentMode);
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) throws LibraryDataException {
        if (paymentDate == null || paymentDate.trim().isEmpty()) {
            throw new LibraryDataException("Payment date cannot be null or empty");
        }
        this.paymentDate = paymentDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) throws LibraryDataException {
        if (paymentMode == null || paymentMode.trim().isEmpty()) {
            throw new LibraryDataException("Payment mode cannot be null or empty");
        }
        this.paymentMode = paymentMode;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPayment: " + paymentMode + " on " + paymentDate;
    }
}


