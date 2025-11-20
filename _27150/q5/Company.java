package _27150.q5;

/**
 * Company class extending Entity with company-specific info.
 */
public class Company extends Entity {
    private String companyName;
    private String address;
    private String phoneNumber;

    public Company(int id, String createdDate, String updatedDate,
                   String companyName, String address, String phoneNumber)
                   throws RentalDataException {
        super(id, createdDate, updatedDate);
        setCompanyName(companyName);
        setAddress(address);
        setPhoneNumber(phoneNumber);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) throws RentalDataException {
        if (companyName == null || companyName.trim().isEmpty()) {
            throw new RentalDataException("Company name cannot be null or empty");
        }
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws RentalDataException {
        if (address == null || address.trim().isEmpty()) {
            throw new RentalDataException("Address cannot be null or empty");
        }
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws RentalDataException {
        validatePhone(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    protected void validatePhone(String phone) throws RentalDataException {
        if (phone == null || phone.trim().isEmpty()) {
            throw new RentalDataException("Phone number cannot be null or empty");
        }
        String digitsOnly = phone.replaceAll("[^0-9]", "");
        if (digitsOnly.length() != 10) {
            throw new RentalDataException("Phone number must contain exactly 10 digits");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nCompany: " + companyName + ", Address: " + address +
               ", Phone: " + phoneNumber;
    }
}


