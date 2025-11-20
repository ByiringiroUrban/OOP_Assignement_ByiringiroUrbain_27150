package _27150.q10;

/**
 * Final OrderRecord class extending Invoice with total calculation.
 */
public final class OrderRecord extends Invoice {
    public OrderRecord(int id, String createdDate, String updatedDate,
                       String storeName, String storeAddress, String email,
                       String categoryName, String categoryCode,
                       String productName, String productCode, double price,
                       String customerName, String contactNumber, String address,
                       String orderDate, String orderId,
                       String paymentMethod, String paymentStatus,
                       String shippingAddress, double shippingCost)
                       throws ShoppingDataException {
        super(id, createdDate, updatedDate,
              storeName, storeAddress, email,
              categoryName, categoryCode,
              productName, productCode, price,
              customerName, contactNumber, address,
              orderDate, orderId,
              paymentMethod, paymentStatus,
              shippingAddress, shippingCost,
              Math.max(0.01, price + shippingCost));
        calculateTotalAmount();
    }

    public double calculateTotalAmount() {
        double total = getPrice() + getShippingCost();
        if (total <= 0) {
            total = getPrice();
        }
        try {
            setTotalAmount(total);
        } catch (ShoppingDataException e) {
            throw new IllegalStateException("Failed to set total amount: " + e.getMessage(), e);
        }
        return total;
    }

    public void displayRecord() {
        System.out.println("\n========== ORDER RECORD ==========");
        System.out.println("Store: " + getStoreName() + " (" + getEmail() + ")");
        System.out.println("Category: " + getCategoryName() + " [" + getCategoryCode() + "]");

        System.out.println("\n--- PRODUCT ---");
        System.out.println("Name: " + getProductName());
        System.out.println("Code: " + getProductCode());
        System.out.println("Price: $" + String.format("%.2f", getPrice()));

        System.out.println("\n--- CUSTOMER ---");
        System.out.println("Name: " + getCustomerName());
        System.out.println("Contact: " + getContactNumber());
        System.out.println("Address: " + getAddress());

        System.out.println("\n--- ORDER ---");
        System.out.println("Order ID: " + getOrderId());
        System.out.println("Order Date: " + getOrderDate());

        System.out.println("\n--- PAYMENT ---");
        System.out.println("Method: " + getPaymentMethod());
        System.out.println("Status: " + getPaymentStatus());

        System.out.println("\n--- SHIPPING ---");
        System.out.println("Shipping Address: " + getShippingAddress());
        System.out.println("Shipping Cost: $" + String.format("%.2f", getShippingCost()));

        System.out.println("\n--- INVOICE ---");
        System.out.println("Total Amount: $" + String.format("%.2f", getTotalAmount()));
        System.out.println("=================================\n");
    }
}


