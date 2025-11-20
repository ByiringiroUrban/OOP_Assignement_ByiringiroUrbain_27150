package _27150.q10;

/**
 * Invoice class extending Shipping with invoice totals.
 */
public class Invoice extends Shipping {
    private double totalAmount;

    public Invoice(int id, String createdDate, String updatedDate,
                   String storeName, String storeAddress, String email,
                   String categoryName, String categoryCode,
                   String productName, String productCode, double price,
                   String customerName, String contactNumber, String address,
                   String orderDate, String orderId,
                   String paymentMethod, String paymentStatus,
                   String shippingAddress, double shippingCost,
                   double totalAmount)
                   throws ShoppingDataException {
        super(id, createdDate, updatedDate, storeName, storeAddress, email,
              categoryName, categoryCode,
              productName, productCode, price,
              customerName, contactNumber, address,
              orderDate, orderId,
              paymentMethod, paymentStatus,
              shippingAddress, shippingCost);
        setTotalAmount(totalAmount);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) throws ShoppingDataException {
        if (totalAmount <= 0) {
            throw new ShoppingDataException("Total amount must be greater than 0");
        }
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return super.toString() + "\nInvoice Total: $" + String.format("%.2f", totalAmount);
    }
}


