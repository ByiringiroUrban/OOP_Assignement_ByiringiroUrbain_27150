package _27150.q10;

/**
 * Order class extending Customer with order details.
 */
public class Order extends Customer {
    private String orderDate;
    private String orderId;

    public Order(int id, String createdDate, String updatedDate,
                 String storeName, String storeAddress, String email,
                 String categoryName, String categoryCode,
                 String productName, String productCode, double price,
                 String customerName, String contactNumber, String address,
                 String orderDate, String orderId)
                 throws ShoppingDataException {
        super(id, createdDate, updatedDate, storeName, storeAddress, email,
              categoryName, categoryCode,
              productName, productCode, price,
              customerName, contactNumber, address);
        setOrderDate(orderDate);
        setOrderId(orderId);
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) throws ShoppingDataException {
        if (orderDate == null || orderDate.trim().isEmpty()) {
            throw new ShoppingDataException("Order date cannot be null or empty");
        }
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) throws ShoppingDataException {
        if (orderId == null || orderId.trim().isEmpty()) {
            throw new ShoppingDataException("Order ID cannot be null or empty");
        }
        this.orderId = orderId.toUpperCase();
    }

    @Override
    public String toString() {
        return super.toString() + "\nOrder ID: " + orderId + ", Order Date: " + orderDate;
    }
}


