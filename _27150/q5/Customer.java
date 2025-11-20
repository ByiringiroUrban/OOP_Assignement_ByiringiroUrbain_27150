package _27150.q5;

/**
 * Customer class extending Vehicle with customer data.
 */
public class Customer extends Vehicle {
    private String customerName;
    private String licenseNumber;
    private String contactNumber;

    public Customer(int id, String createdDate, String updatedDate,
                    String companyName, String address, String phoneNumber,
                    String branchName, String locationCode,
                    String vehicleType, String registrationNumber, double dailyRate,
                    String customerName, String licenseNumber, String contactNumber)
                    throws RentalDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber,
              branchName, locationCode,
              vehicleType, registrationNumber, dailyRate);
        setCustomerName(customerName);
        setLicenseNumber(licenseNumber);
        setContactNumber(contactNumber);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) throws RentalDataException {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new RentalDataException("Customer name cannot be null or empty");
        }
        this.customerName = customerName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) throws RentalDataException {
        if (licenseNumber == null || licenseNumber.trim().isEmpty()) {
            throw new RentalDataException("License number cannot be null or empty");
        }
        this.licenseNumber = licenseNumber.toUpperCase();
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) throws RentalDataException {
        validatePhone(contactNumber);
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCustomer: " + customerName +
               ", License: " + licenseNumber + ", Contact: " + contactNumber;
    }
}


