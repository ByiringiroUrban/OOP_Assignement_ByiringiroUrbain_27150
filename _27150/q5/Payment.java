package _27150.q5;

/**
 * Payment class extending Charge with payment details.
 */
public class Payment extends Charge {
    private String paymentMode;
    private String transactionId;

    public Payment(int id, String createdDate, String updatedDate,
                   String companyName, String address, String phoneNumber,
                   String branchName, String locationCode,
                   String vehicleType, String registrationNumber, double dailyRate,
                   String customerName, String licenseNumber, String contactNumber,
                   String rentalDate, String returnDate, int rentalDays,
                   double rentalCharge, double penaltyCharge,
                   String paymentMode, String transactionId)
                   throws RentalDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber,
              branchName, locationCode,
              vehicleType, registrationNumber, dailyRate,
              customerName, licenseNumber, contactNumber,
              rentalDate, returnDate, rentalDays,
              rentalCharge, penaltyCharge);
        setPaymentMode(paymentMode);
        setTransactionId(transactionId);
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) throws RentalDataException {
        if (paymentMode == null || paymentMode.trim().isEmpty()) {
            throw new RentalDataException("Payment mode cannot be null or empty");
        }
        this.paymentMode = paymentMode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) throws RentalDataException {
        if (transactionId == null || transactionId.trim().isEmpty()) {
            throw new RentalDataException("Transaction ID cannot be null or empty");
        }
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPayment: Mode " + paymentMode +
               ", Transaction ID: " + transactionId;
    }
}


