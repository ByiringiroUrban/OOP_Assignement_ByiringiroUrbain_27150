package _27150.q6;

/**
 * Account class extending Bank with account specifics.
 */
public class Account extends Bank {
    private String accountNumber;
    private String accountType;
    private double balance;

    public Account(int id, String createdDate, String updatedDate,
                   String bankName, String branchCode, String address,
                   String accountNumber, String accountType, double balance)
                   throws BankDataException {
        super(id, createdDate, updatedDate, bankName, branchCode, address);
        setAccountNumber(accountNumber);
        setAccountType(accountType);
        setBalance(balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) throws BankDataException {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new BankDataException("Account number cannot be null or empty");
        }
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) throws BankDataException {
        if (accountType == null || accountType.trim().isEmpty()) {
            throw new BankDataException("Account type cannot be null or empty");
        }
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) throws BankDataException {
        if (balance < 0) {
            throw new BankDataException("Balance cannot be negative");
        }
        this.balance = balance;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAccount: " + accountNumber + " (" + accountType + ")" +
               ", Balance: $" + String.format("%.2f", balance);
    }
}


