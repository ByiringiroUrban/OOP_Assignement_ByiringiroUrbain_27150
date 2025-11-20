package _27150.q10;

/**
 * Payment class extending Order with payment details.
 */
public class Payment extends Order {
    private String paymentMethod;
    private String paymentStatus;

    public Payment(int id, String createdDate, String updatedDate,
                   String storeName, String storeAddress, String email,
                   String categoryName, String categoryCode,
                   String productName, String productCode, double price,
                   String customerName, String contactNumber, String address,
                   String orderDate, String orderId,
                   String paymentMethod, String paymentStatus)
                   throws ShoppingDataException {
        super(id, createdDate, updatedDate, storeName, storeAddress, email,
              categoryName, categoryCode,
              productName, productCode, price,
              customerName, contactNumber, address,
              orderDate, orderId);
        setPaymentMethod(paymentMethod);
        setPaymentStatus(paymentStatus);
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) throws ShoppingDataException {
        if (paymentMethod == null || paymentMethod.trim().isEmpty()) {
            throw new ShoppingDataException("Payment method cannot be null or empty");
        }
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) throws ShoppingDataException {
        if (paymentStatus == null || paymentStatus.trim().isEmpty()) {
            throw new ShoppingDataException("Payment status cannot be null or empty");
        }
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPayment: " + paymentMethod + " (" + paymentStatus + ")";
    }
}


