package _27150.q6;

/**
 * Final AccountRecord class extending Payment with business logic.
 */
public final class AccountRecord extends Payment {
    public AccountRecord(int id, String createdDate, String updatedDate,
                         String bankName, String branchCode, String address,
                         String accountNumber, String accountType, double balance,
                         String customerName, String email, String phoneNumber,
                         String transactionId, String transactionType, double amount,
                         double depositAmount, String depositDate,
                         double withdrawalAmount, String withdrawalDate,
                         double loanAmount, double interestRate, double duration,
                         double paymentAmount, String paymentDate)
                         throws BankDataException {
        super(id, createdDate, updatedDate, bankName, branchCode, address,
              accountNumber, accountType, balance,
              customerName, email, phoneNumber,
              transactionId, transactionType, amount,
              depositAmount, depositDate,
              withdrawalAmount, withdrawalDate,
              loanAmount, interestRate, duration,
              paymentAmount, paymentDate);
    }

    public double calculateInterest() {
        return (getLoanAmount() * getInterestRate() * getDuration()) / 100.0;
    }

    public void displayRecord() {
        System.out.println("\n========== BANK ACCOUNT RECORD ==========");
        System.out.println("Bank: " + getBankName() + " (" + getBranchCode() + ")");
        System.out.println("Address: " + getAddress());

        System.out.println("\n--- ACCOUNT DETAILS ---");
        System.out.println("Account #: " + getAccountNumber());
        System.out.println("Account Type: " + getAccountType());
        System.out.println("Balance: $" + String.format("%.2f", getBalance()));

        System.out.println("\n--- CUSTOMER DETAILS ---");
        System.out.println("Name: " + getCustomerName());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + getPhoneNumber());

        System.out.println("\n--- TRANSACTION INFO ---");
        System.out.println("Transaction ID: " + getTransactionId());
        System.out.println("Type: " + getTransactionType());
        System.out.println("Amount: $" + String.format("%.2f", getAmount()));

        System.out.println("\n--- DEPOSIT ---");
        System.out.println("Deposit Amount: $" + String.format("%.2f", getDepositAmount()));
        System.out.println("Deposit Date: " + getDepositDate());

        System.out.println("\n--- WITHDRAWAL ---");
        System.out.println("Withdrawal Amount: $" + String.format("%.2f", getWithdrawalAmount()));
        System.out.println("Withdrawal Date: " + getWithdrawalDate());

        System.out.println("\n--- LOAN DETAILS ---");
        System.out.println("Loan Amount: $" + String.format("%.2f", getLoanAmount()));
        System.out.println("Interest Rate: " + getInterestRate() + "%");
        System.out.println("Duration: " + getDuration() + " years");
        System.out.println("Calculated Interest: $" + String.format("%.2f", calculateInterest()));

        System.out.println("\n--- PAYMENT ---");
        System.out.println("Payment Amount: $" + String.format("%.2f", getPaymentAmount()));
        System.out.println("Payment Date: " + getPaymentDate());
        System.out.println("=========================================\n");
    }
}


