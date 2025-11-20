package _27150.q6;

/**
 * Customer class extending Account with customer details.
 */
public class Customer extends Account {
    private String customerName;
    private String email;
    private String phoneNumber;

    public Customer(int id, String createdDate, String updatedDate,
                    String bankName, String branchCode, String address,
                    String accountNumber, String accountType, double balance,
                    String customerName, String email, String phoneNumber)
                    throws BankDataException {
        super(id, createdDate, updatedDate, bankName, branchCode, address,
              accountNumber, accountType, balance);
        setCustomerName(customerName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) throws BankDataException {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new BankDataException("Customer name cannot be null or empty");
        }
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws BankDataException {
        validateEmail(email);
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws BankDataException {
        validatePhone(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    protected void validateEmail(String email) throws BankDataException {
        if (email == null || email.trim().isEmpty()) {
            throw new BankDataException("Email cannot be null or empty");
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new BankDataException("Invalid email format");
        }
    }

    protected void validatePhone(String phone) throws BankDataException {
        if (phone == null || phone.trim().isEmpty()) {
            throw new BankDataException("Phone number cannot be null or empty");
        }
        String digitsOnly = phone.replaceAll("[^0-9]", "");
        if (digitsOnly.length() != 10) {
            throw new BankDataException("Phone number must contain exactly 10 digits");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nCustomer: " + customerName +
               ", Email: " + email + ", Phone: " + phoneNumber;
    }
}


