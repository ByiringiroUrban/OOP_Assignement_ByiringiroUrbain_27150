package _27150.q10;

/**
 * Shipping class extending Payment with shipping details.
 */
public class Shipping extends Payment {
    private String shippingAddress;
    private double shippingCost;

    public Shipping(int id, String createdDate, String updatedDate,
                    String storeName, String storeAddress, String email,
                    String categoryName, String categoryCode,
                    String productName, String productCode, double price,
                    String customerName, String contactNumber, String address,
                    String orderDate, String orderId,
                    String paymentMethod, String paymentStatus,
                    String shippingAddress, double shippingCost)
                    throws ShoppingDataException {
        super(id, createdDate, updatedDate, storeName, storeAddress, email,
              categoryName, categoryCode,
              productName, productCode, price,
              customerName, contactNumber, address,
              orderDate, orderId,
              paymentMethod, paymentStatus);
        setShippingAddress(shippingAddress);
        setShippingCost(shippingCost);
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) throws ShoppingDataException {
        if (shippingAddress == null || shippingAddress.trim().isEmpty()) {
            throw new ShoppingDataException("Shipping address cannot be null or empty");
        }
        this.shippingAddress = shippingAddress;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) throws ShoppingDataException {
        if (shippingCost < 0) {
            throw new ShoppingDataException("Shipping cost cannot be negative");
        }
        this.shippingCost = shippingCost;
    }

    @Override
    public String toString() {
        return super.toString() + "\nShipping: " + shippingAddress +
               ", Cost: $" + String.format("%.2f", shippingCost);
    }
}


