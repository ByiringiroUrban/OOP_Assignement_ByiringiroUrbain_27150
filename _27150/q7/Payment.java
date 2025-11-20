package _27150.q7;

/**
 * Payment class extending Agreement with payment details.
 */
public class Payment extends Agreement {
    private double paymentAmount;
    private String paymentDate;

    public Payment(int id, String createdDate, String updatedDate,
                   String agencyName, String location, String phoneNumber,
                   String agentName, String email, String licenseNumber,
                   String propertyCode, String propertyType, double price,
                   String sellerName, String contactNumber,
                   String buyerName, String buyerEmail,
                   String agreementDate, String terms,
                   double paymentAmount, String paymentDate)
                   throws RealEstateDataException {
        super(id, createdDate, updatedDate, agencyName, location, phoneNumber,
              agentName, email, licenseNumber,
              propertyCode, propertyType, price,
              sellerName, contactNumber,
              buyerName, buyerEmail,
              agreementDate, terms);
        setPaymentAmount(paymentAmount);
        setPaymentDate(paymentDate);
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) throws RealEstateDataException {
        if (paymentAmount <= 0) {
            throw new RealEstateDataException("Payment amount must be greater than 0");
        }
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) throws RealEstateDataException {
        if (paymentDate == null || paymentDate.trim().isEmpty()) {
            throw new RealEstateDataException("Payment date cannot be null or empty");
        }
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPayment: $" + String.format("%.2f", paymentAmount) +
               " on " + paymentDate;
    }
}


