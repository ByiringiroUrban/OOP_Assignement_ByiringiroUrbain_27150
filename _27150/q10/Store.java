package _27150.q10;

/**
 * Store class extending Entity with store information.
 */
public class Store extends Entity {
    private String storeName;
    private String address;
    private String email;

    public Store(int id, String createdDate, String updatedDate,
                 String storeName, String address, String email)
                 throws ShoppingDataException {
        super(id, createdDate, updatedDate);
        setStoreName(storeName);
        setAddress(address);
        setEmail(email);
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) throws ShoppingDataException {
        if (storeName == null || storeName.trim().isEmpty()) {
            throw new ShoppingDataException("Store name cannot be null or empty");
        }
        this.storeName = storeName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ShoppingDataException {
        if (email == null || email.trim().isEmpty()) {
            throw new ShoppingDataException("Email cannot be null or empty");
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new ShoppingDataException("Invalid email format");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString() + "\nStore: " + storeName + ", Address: " + address +
               ", Email: " + email;
    }
}


