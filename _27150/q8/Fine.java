package _27150.q8;

/**
 * Fine class extending Borrow with fine information.
 */
public class Fine extends Borrow {
    private double fineAmount;
    private int daysLate;

    public Fine(int id, String createdDate, String updatedDate,
                String libraryName, String location, String phoneNumber,
                String sectionName, String sectionCode,
                String title, String author, String isbn,
                String memberName, int memberId, String contactNumber,
                String borrowDate, String returnDate,
                double fineAmount, int daysLate)
                throws LibraryDataException {
        super(id, createdDate, updatedDate, libraryName, location, phoneNumber,
              sectionName, sectionCode,
              title, author, isbn,
              memberName, memberId, contactNumber,
              borrowDate, returnDate);
        setFineAmount(fineAmount);
        setDaysLate(daysLate);
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) throws LibraryDataException {
        if (fineAmount < 0) {
            throw new LibraryDataException("Fine amount cannot be negative");
        }
        this.fineAmount = fineAmount;
    }

    public int getDaysLate() {
        return daysLate;
    }

    public void setDaysLate(int daysLate) throws LibraryDataException {
        if (daysLate < 0) {
            throw new LibraryDataException("Days late cannot be negative");
        }
        this.daysLate = daysLate;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFine: $" + String.format("%.2f", fineAmount) +
               ", Days Late: " + daysLate;
    }
}


