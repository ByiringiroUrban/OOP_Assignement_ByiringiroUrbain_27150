package _27150.q10;

/**
 * Product class extending Category with product information.
 */
public class Product extends Category {
    private String productName;
    private String productCode;
    private double price;

    public Product(int id, String createdDate, String updatedDate,
                   String storeName, String address, String email,
                   String categoryName, String categoryCode,
                   String productName, String productCode, double price)
                   throws ShoppingDataException {
        super(id, createdDate, updatedDate, storeName, address, email,
              categoryName, categoryCode);
        setProductName(productName);
        setProductCode(productCode);
        setPrice(price);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) throws ShoppingDataException {
        if (productName == null || productName.trim().isEmpty()) {
            throw new ShoppingDataException("Product name cannot be null or empty");
        }
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) throws ShoppingDataException {
        if (productCode == null || productCode.trim().isEmpty()) {
            throw new ShoppingDataException("Product code cannot be null or empty");
        }
        this.productCode = productCode.toUpperCase();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws ShoppingDataException {
        if (price <= 0) {
            throw new ShoppingDataException("Product price must be greater than 0");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString() + "\nProduct: " + productName + " (" + productCode + ")" +
               ", Price: $" + String.format("%.2f", price);
    }
}


