package _27150.q10;

/**
 * Customer class extending Product with customer details.
 */
public class Customer extends Product {
    private String customerName;
    private String contactNumber;
    private String address;

    public Customer(int id, String createdDate, String updatedDate,
                    String storeName, String storeAddress, String email,
                    String categoryName, String categoryCode,
                    String productName, String productCode, double price,
                    String customerName, String contactNumber, String address)
                    throws ShoppingDataException {
        super(id, createdDate, updatedDate, storeName, storeAddress, email,
              categoryName, categoryCode, productName, productCode, price);
        setCustomerName(customerName);
        setContactNumber(contactNumber);
        setAddress(address);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) throws ShoppingDataException {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new ShoppingDataException("Customer name cannot be null or empty");
        }
        this.customerName = customerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) throws ShoppingDataException {
        if (contactNumber == null || contactNumber.trim().isEmpty()) {
            throw new ShoppingDataException("Contact number cannot be null or empty");
        }
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws ShoppingDataException {
        if (address == null || address.trim().isEmpty()) {
            throw new ShoppingDataException("Address cannot be null or empty");
        }
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCustomer: " + customerName +
               ", Contact: " + contactNumber + ", Address: " + address;
    }
}


