package _27150.q6;

/**
 * Loan class extending Withdrawal with loan attributes.
 */
public class Loan extends Withdrawal {
    private double loanAmount;
    private double interestRate;
    private double duration;

    public Loan(int id, String createdDate, String updatedDate,
                String bankName, String branchCode, String address,
                String accountNumber, String accountType, double balance,
                String customerName, String email, String phoneNumber,
                String transactionId, String transactionType, double amount,
                double depositAmount, String depositDate,
                double withdrawalAmount, String withdrawalDate,
                double loanAmount, double interestRate, double duration)
                throws BankDataException {
        super(id, createdDate, updatedDate, bankName, branchCode, address,
              accountNumber, accountType, balance,
              customerName, email, phoneNumber,
              transactionId, transactionType, amount,
              depositAmount, depositDate,
              withdrawalAmount, withdrawalDate);
        setLoanAmount(loanAmount);
        setInterestRate(interestRate);
        setDuration(duration);
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) throws BankDataException {
        if (loanAmount <= 0) {
            throw new BankDataException("Loan amount must be greater than 0");
        }
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) throws BankDataException {
        if (interestRate <= 0) {
            throw new BankDataException("Interest rate must be greater than 0");
        }
        this.interestRate = interestRate;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) throws BankDataException {
        if (duration <= 0) {
            throw new BankDataException("Duration must be greater than 0");
        }
        this.duration = duration;
    }

    public double calculateInterest() {
        return (loanAmount * interestRate * duration) / 100.0;
    }

    @Override
    public String toString() {
        return super.toString() + "\nLoan: Amount $" + loanAmount +
               ", Rate " + interestRate + "%, Duration " + duration + " years";
    }
}


