package _27150.q7;

/**
 * Seller class extending Property with seller information.
 */
public class Seller extends Property {
    private String sellerName;
    private String contactNumber;

    public Seller(int id, String createdDate, String updatedDate,
                  String agencyName, String location, String phoneNumber,
                  String agentName, String email, String licenseNumber,
                  String propertyCode, String propertyType, double price,
                  String sellerName, String contactNumber)
                  throws RealEstateDataException {
        super(id, createdDate, updatedDate, agencyName, location, phoneNumber,
              agentName, email, licenseNumber,
              propertyCode, propertyType, price);
        setSellerName(sellerName);
        setContactNumber(contactNumber);
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) throws RealEstateDataException {
        if (sellerName == null || sellerName.trim().isEmpty()) {
            throw new RealEstateDataException("Seller name cannot be null or empty");
        }
        this.sellerName = sellerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) throws RealEstateDataException {
        validatePhone(contactNumber);
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSeller: " + sellerName + ", Contact: " + contactNumber;
    }
}


