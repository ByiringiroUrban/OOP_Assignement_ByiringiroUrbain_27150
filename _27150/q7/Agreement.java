package _27150.q7;

/**
 * Agreement class extending Buyer with agreement details.
 */
public class Agreement extends Buyer {
    private String agreementDate;
    private String terms;

    public Agreement(int id, String createdDate, String updatedDate,
                     String agencyName, String location, String phoneNumber,
                     String agentName, String email, String licenseNumber,
                     String propertyCode, String propertyType, double price,
                     String sellerName, String contactNumber,
                     String buyerName, String buyerEmail,
                     String agreementDate, String terms)
                     throws RealEstateDataException {
        super(id, createdDate, updatedDate, agencyName, location, phoneNumber,
              agentName, email, licenseNumber,
              propertyCode, propertyType, price,
              sellerName, contactNumber,
              buyerName, buyerEmail);
        setAgreementDate(agreementDate);
        setTerms(terms);
    }

    public String getAgreementDate() {
        return agreementDate;
    }

    public void setAgreementDate(String agreementDate) throws RealEstateDataException {
        if (agreementDate == null || agreementDate.trim().isEmpty()) {
            throw new RealEstateDataException("Agreement date cannot be null or empty");
        }
        this.agreementDate = agreementDate;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) throws RealEstateDataException {
        if (terms == null || terms.trim().isEmpty()) {
            throw new RealEstateDataException("Agreement terms cannot be null or empty");
        }
        this.terms = terms;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAgreement Date: " + agreementDate + ", Terms: " + terms;
    }
}


