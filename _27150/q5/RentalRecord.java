package _27150.q5;

/**
 * Final RentalRecord class extending Invoice and computing totals.
 */
public final class RentalRecord extends Invoice {
    public RentalRecord(int id, String createdDate, String updatedDate,
                        String companyName, String address, String phoneNumber,
                        String branchName, String locationCode,
                        String vehicleType, String registrationNumber, double dailyRate,
                        String customerName, String licenseNumber, String contactNumber,
                        String rentalDate, String returnDate, int rentalDays,
                        double rentalCharge, double penaltyCharge,
                        String paymentMode, String transactionId)
                        throws RentalDataException {
        super(id, createdDate, updatedDate,
              companyName, address, phoneNumber,
              branchName, locationCode,
              vehicleType, registrationNumber, dailyRate,
              customerName, licenseNumber, contactNumber,
              rentalDate, returnDate, rentalDays,
              rentalCharge, penaltyCharge,
              paymentMode, transactionId,
              rentalCharge + penaltyCharge);
        calculateTotalCharge();
    }

    /**
     * Calculates total charge as rental + penalty.
     */
    public double calculateTotalCharge() {
        double total = getRentalCharge() + getPenaltyCharge();
        try {
            setTotalCharge(total);
        } catch (RentalDataException e) {
            throw new IllegalStateException("Failed to set total charge: " + e.getMessage(), e);
        }
        return total;
    }

    public void displayRecord() {
        System.out.println("\n========== VEHICLE RENTAL RECORD ==========");
        System.out.println("Company: " + getCompanyName());
        System.out.println("Branch: " + getBranchName() + " (" + getLocationCode() + ")");

        System.out.println("\n--- VEHICLE ---");
        System.out.println("Type: " + getVehicleType());
        System.out.println("Registration #: " + getRegistrationNumber());
        System.out.println("Daily Rate: $" + String.format("%.2f", getDailyRate()));

        System.out.println("\n--- CUSTOMER ---");
        System.out.println("Name: " + getCustomerName());
        System.out.println("License: " + getLicenseNumber());
        System.out.println("Contact: " + getContactNumber());

        System.out.println("\n--- RENTAL DETAILS ---");
        System.out.println("Rental Date: " + getRentalDate());
        System.out.println("Return Date: " + getReturnDate());
        System.out.println("Rental Days: " + getRentalDays());

        System.out.println("\n--- CHARGES ---");
        System.out.println("Rental Charge: $" + String.format("%.2f", getRentalCharge()));
        System.out.println("Penalty Charge: $" + String.format("%.2f", getPenaltyCharge()));
        System.out.println("TOTAL CHARGE: $" + String.format("%.2f", getTotalCharge()));

        System.out.println("\n--- PAYMENT ---");
        System.out.println("Mode: " + getPaymentMode());
        System.out.println("Transaction ID: " + getTransactionId());
        System.out.println("===========================================\n");
    }
}


