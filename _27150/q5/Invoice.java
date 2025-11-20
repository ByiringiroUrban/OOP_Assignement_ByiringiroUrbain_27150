package _27150.q5;

/**
 * Invoice class extending Payment with total charge.
 */
public class Invoice extends Payment {
    private double totalCharge;

    public Invoice(int id, String createdDate, String updatedDate,
                   String companyName, String address, String phoneNumber,
                   String branchName, String locationCode,
                   String vehicleType, String registrationNumber, double dailyRate,
                   String customerName, String licenseNumber, String contactNumber,
                   String rentalDate, String returnDate, int rentalDays,
                   double rentalCharge, double penaltyCharge,
                   String paymentMode, String transactionId,
                   double totalCharge)
                   throws RentalDataException {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber,
              branchName, locationCode,
              vehicleType, registrationNumber, dailyRate,
              customerName, licenseNumber, contactNumber,
              rentalDate, returnDate, rentalDays,
              rentalCharge, penaltyCharge,
              paymentMode, transactionId);
        setTotalCharge(totalCharge);
    }

    public double getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(double totalCharge) throws RentalDataException {
        if (totalCharge <= 0) {
            throw new RentalDataException("Total charge must be greater than 0");
        }
        this.totalCharge = totalCharge;
    }

    @Override
    public String toString() {
        return super.toString() + "\nInvoice: Total $" + totalCharge;
    }
}


