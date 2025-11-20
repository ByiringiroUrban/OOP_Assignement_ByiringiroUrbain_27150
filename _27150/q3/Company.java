package _27150.q3;

/**
 * Company class extending Entity with organization details.
 */
public class Company extends Entity {
    private String companyName;
    private String address;
    private String phoneNumber;
    private String email;

    public Company(int id, String createdDate, String updatedDate,
                   String companyName, String address, String phoneNumber, String email)
                   throws PayrollDataException {
        super(id, createdDate, updatedDate);
        setCompanyName(companyName);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) throws PayrollDataException {
        if (companyName == null || companyName.trim().isEmpty()) {
            throw new PayrollDataException("Company name cannot be null or empty");
        }
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws PayrollDataException {
        if (address == null || address.trim().isEmpty()) {
            throw new PayrollDataException("Address cannot be null or empty");
        }
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws PayrollDataException {
        validatePhone(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws PayrollDataException {
        validateEmail(email);
        this.email = email;
    }

    protected void validatePhone(String phone) throws PayrollDataException {
        if (phone == null || phone.trim().isEmpty()) {
            throw new PayrollDataException("Phone number cannot be null or empty");
        }
        String digitsOnly = phone.replaceAll("[^0-9]", "");
        if (digitsOnly.length() != 10) {
            throw new PayrollDataException("Phone number must have exactly 10 digits");
        }
    }

    protected void validateEmail(String email) throws PayrollDataException {
        if (email == null || email.trim().isEmpty()) {
            throw new PayrollDataException("Email cannot be null or empty");
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new PayrollDataException("Invalid email format");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nCompany: " + companyName + ", Address: " + address +
               ", Phone: " + phoneNumber + ", Email: " + email;
    }
}


