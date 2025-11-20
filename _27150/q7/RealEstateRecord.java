package _27150.q7;

/**
 * Final RealEstateRecord class extending Commission with calculations.
 */
public final class RealEstateRecord extends Commission {
    public RealEstateRecord(int id, String createdDate, String updatedDate,
                            String agencyName, String location, String phoneNumber,
                            String agentName, String email, String licenseNumber,
                            String propertyCode, String propertyType, double price,
                            String sellerName, String contactNumber,
                            String buyerName, String buyerEmail,
                            String agreementDate, String terms,
                            double paymentAmount, String paymentDate,
                            double commissionRate)
                            throws RealEstateDataException {
        super(id, createdDate, updatedDate,
              agencyName, location, phoneNumber,
              agentName, email, licenseNumber,
              propertyCode, propertyType, price,
              sellerName, contactNumber,
              buyerName, buyerEmail,
              agreementDate, terms,
              paymentAmount, paymentDate,
              commissionRate, 0.0);
        calculateCommission();
    }

    public double calculateCommission() {
        double commission = (getPrice() * getCommissionRate()) / 100.0;
        try {
            setCommissionAmount(commission);
        } catch (RealEstateDataException e) {
            throw new IllegalStateException("Failed to set commission amount: " + e.getMessage(), e);
        }
        return commission;
    }

    public void displayRecord() {
        System.out.println("\n========== REAL ESTATE RECORD ==========");
        System.out.println("Agency: " + getAgencyName() + " (" + getLocation() + ")");
        System.out.println("Agent: " + getAgentName() + " - " + getEmail());

        System.out.println("\n--- PROPERTY ---");
        System.out.println("Code: " + getPropertyCode());
        System.out.println("Type: " + getPropertyType());
        System.out.println("Price: $" + String.format("%.2f", getPrice()));

        System.out.println("\n--- SELLER ---");
        System.out.println("Name: " + getSellerName());
        System.out.println("Contact: " + getContactNumber());

        System.out.println("\n--- BUYER ---");
        System.out.println("Name: " + getBuyerName());
        System.out.println("Email: " + getBuyerEmail());

        System.out.println("\n--- AGREEMENT ---");
        System.out.println("Date: " + getAgreementDate());
        System.out.println("Terms: " + getTerms());

        System.out.println("\n--- PAYMENT ---");
        System.out.println("Amount: $" + String.format("%.2f", getPaymentAmount()));
        System.out.println("Date: " + getPaymentDate());

        System.out.println("\n--- COMMISSION ---");
        System.out.println("Rate: " + getCommissionRate() + "%");
        System.out.println("Commission Amount: $" + String.format("%.2f", getCommissionAmount()));
        System.out.println("=========================================\n");
    }
}


