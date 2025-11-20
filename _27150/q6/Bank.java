package _27150.q6;

/**
 * Bank class extending Entity with bank details.
 */
public class Bank extends Entity {
    private String bankName;
    private String branchCode;
    private String address;

    public Bank(int id, String createdDate, String updatedDate,
                String bankName, String branchCode, String address)
                throws BankDataException {
        super(id, createdDate, updatedDate);
        setBankName(bankName);
        setBranchCode(branchCode);
        setAddress(address);
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) throws BankDataException {
        if (bankName == null || bankName.trim().isEmpty()) {
            throw new BankDataException("Bank name cannot be null or empty");
        }
        this.bankName = bankName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) throws BankDataException {
        if (branchCode == null || branchCode.trim().isEmpty()) {
            throw new BankDataException("Branch code cannot be null or empty");
        }
        if (branchCode.length() < 3) {
            throw new BankDataException("Branch code must be at least 3 characters");
        }
        this.branchCode = branchCode.toUpperCase();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws BankDataException {
        if (address == null || address.trim().isEmpty()) {
            throw new BankDataException("Address cannot be null or empty");
        }
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() + "\nBank: " + bankName + ", Branch Code: " + branchCode +
               ", Address: " + address;
    }
}


