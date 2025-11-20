package _27150.q6;

/**
 * Deposit class extending Transaction with deposit-specific data.
 */
public class Deposit extends Transaction {
    private double depositAmount;
    private String depositDate;

    public Deposit(int id, String createdDate, String updatedDate,
                   String bankName, String branchCode, String address,
                   String accountNumber, String accountType, double balance,
                   String customerName, String email, String phoneNumber,
                   String transactionId, String transactionType, double amount,
                   double depositAmount, String depositDate)
                   throws BankDataException {
        super(id, createdDate, updatedDate, bankName, branchCode, address,
              accountNumber, accountType, balance,
              customerName, email, phoneNumber,
              transactionId, transactionType, amount);
        setDepositAmount(depositAmount);
        setDepositDate(depositDate);
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) throws BankDataException {
        if (depositAmount <= 0) {
            throw new BankDataException("Deposit amount must be greater than 0");
        }
        this.depositAmount = depositAmount;
    }

    public String getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(String depositDate) throws BankDataException {
        if (depositDate == null || depositDate.trim().isEmpty()) {
            throw new BankDataException("Deposit date cannot be null or empty");
        }
        this.depositDate = depositDate;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDeposit: $" + String.format("%.2f", depositAmount) +
               " on " + depositDate;
    }
}


