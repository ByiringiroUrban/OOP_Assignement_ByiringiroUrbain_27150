package _27150.q6;

/**
 * Withdrawal class extending Deposit with withdrawal details.
 */
public class Withdrawal extends Deposit {
    private double withdrawalAmount;
    private String withdrawalDate;

    public Withdrawal(int id, String createdDate, String updatedDate,
                      String bankName, String branchCode, String address,
                      String accountNumber, String accountType, double balance,
                      String customerName, String email, String phoneNumber,
                      String transactionId, String transactionType, double amount,
                      double depositAmount, String depositDate,
                      double withdrawalAmount, String withdrawalDate)
                      throws BankDataException {
        super(id, createdDate, updatedDate, bankName, branchCode, address,
              accountNumber, accountType, balance,
              customerName, email, phoneNumber,
              transactionId, transactionType, amount,
              depositAmount, depositDate);
        setWithdrawalAmount(withdrawalAmount);
        setWithdrawalDate(withdrawalDate);
    }

    public double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(double withdrawalAmount) throws BankDataException {
        if (withdrawalAmount <= 0) {
            throw new BankDataException("Withdrawal amount must be greater than 0");
        }
        this.withdrawalAmount = withdrawalAmount;
    }

    public String getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(String withdrawalDate) throws BankDataException {
        if (withdrawalDate == null || withdrawalDate.trim().isEmpty()) {
            throw new BankDataException("Withdrawal date cannot be null or empty");
        }
        this.withdrawalDate = withdrawalDate;
    }

    @Override
    public String toString() {
        return super.toString() + "\nWithdrawal: $" + String.format("%.2f", withdrawalAmount) +
               " on " + withdrawalDate;
    }
}


