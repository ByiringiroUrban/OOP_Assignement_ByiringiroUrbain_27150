package _27150.q7;

/**
 * Commission class extending Payment with commission data.
 */
public class Commission extends Payment {
    private double commissionRate;
    private double commissionAmount;

    public Commission(int id, String createdDate, String updatedDate,
                      String agencyName, String location, String phoneNumber,
                      String agentName, String email, String licenseNumber,
                      String propertyCode, String propertyType, double price,
                      String sellerName, String contactNumber,
                      String buyerName, String buyerEmail,
                      String agreementDate, String terms,
                      double paymentAmount, String paymentDate,
                      double commissionRate, double commissionAmount)
                      throws RealEstateDataException {
        super(id, createdDate, updatedDate, agencyName, location, phoneNumber,
              agentName, email, licenseNumber,
              propertyCode, propertyType, price,
              sellerName, contactNumber,
              buyerName, buyerEmail,
              agreementDate, terms,
              paymentAmount, paymentDate);
        setCommissionRate(commissionRate);
        setCommissionAmount(commissionAmount);
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) throws RealEstateDataException {
        if (commissionRate < 0) {
            throw new RealEstateDataException("Commission rate cannot be negative");
        }
        this.commissionRate = commissionRate;
    }

    public double getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(double commissionAmount) throws RealEstateDataException {
        if (commissionAmount < 0) {
            throw new RealEstateDataException("Commission amount cannot be negative");
        }
        this.commissionAmount = commissionAmount;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCommission: Rate " + commissionRate + "%, Amount $" +
               String.format("%.2f", commissionAmount);
    }
}


