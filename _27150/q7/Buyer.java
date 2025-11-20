package _27150.q7;

/**
 * Buyer class extending Seller with buyer information.
 */
public class Buyer extends Seller {
    private String buyerName;
    private String buyerEmail;

    public Buyer(int id, String createdDate, String updatedDate,
                 String agencyName, String location, String phoneNumber,
                 String agentName, String email, String licenseNumber,
                 String propertyCode, String propertyType, double price,
                 String sellerName, String contactNumber,
                 String buyerName, String buyerEmail)
                 throws RealEstateDataException {
        super(id, createdDate, updatedDate, agencyName, location, phoneNumber,
              agentName, email, licenseNumber,
              propertyCode, propertyType, price,
              sellerName, contactNumber);
        setBuyerName(buyerName);
        setBuyerEmail(buyerEmail);
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) throws RealEstateDataException {
        if (buyerName == null || buyerName.trim().isEmpty()) {
            throw new RealEstateDataException("Buyer name cannot be null or empty");
        }
        this.buyerName = buyerName;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) throws RealEstateDataException {
        if (buyerEmail == null || buyerEmail.trim().isEmpty()) {
            throw new RealEstateDataException("Buyer email cannot be null or empty");
        }
        if (!buyerEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new RealEstateDataException("Invalid buyer email format");
        }
        this.buyerEmail = buyerEmail;
    }

    @Override
    public String toString() {
        return super.toString() + "\nBuyer: " + buyerName + ", Email: " + buyerEmail;
    }
}


