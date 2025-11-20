package _27150.q6;

/**
 * Transaction class extending Customer with transaction details.
 */
public class Transaction extends Customer {
    private String transactionId;
    private String transactionType;
    private double amount;

    public Transaction(int id, String createdDate, String updatedDate,
                       String bankName, String branchCode, String address,
                       String accountNumber, String accountType, double balance,
                       String customerName, String email, String phoneNumber,
                       String transactionId, String transactionType, double amount)
                       throws BankDataException {
        super(id, createdDate, updatedDate, bankName, branchCode, address,
              accountNumber, accountType, balance,
              customerName, email, phoneNumber);
        setTransactionId(transactionId);
        setTransactionType(transactionType);
        setAmount(amount);
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) throws BankDataException {
        if (transactionId == null || transactionId.trim().isEmpty()) {
            throw new BankDataException("Transaction ID cannot be null or empty");
        }
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) throws BankDataException {
        if (transactionType == null || transactionType.trim().isEmpty()) {
            throw new BankDataException("Transaction type cannot be null or empty");
        }
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) throws BankDataException {
        if (amount <= 0) {
            throw new BankDataException("Transaction amount must be greater than 0");
        }
        this.amount = amount;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTransaction: " + transactionId +
               " [" + transactionType + "] Amount $" + String.format("%.2f", amount);
    }
}


