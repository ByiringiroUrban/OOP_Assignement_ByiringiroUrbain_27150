package _27150.q8;

/**
 * Record class extending Payment with total fine summary.
 */
public class Record extends Payment {
    private double totalFine;

    public Record(int id, String createdDate, String updatedDate,
                  String libraryName, String location, String phoneNumber,
                  String sectionName, String sectionCode,
                  String title, String author, String isbn,
                  String memberName, int memberId, String contactNumber,
                  String borrowDate, String returnDate,
                  double fineAmount, int daysLate,
                  String paymentDate, String paymentMode,
                  double totalFine)
                  throws LibraryDataException {
        super(id, createdDate, updatedDate, libraryName, location, phoneNumber,
              sectionName, sectionCode,
              title, author, isbn,
              memberName, memberId, contactNumber,
              borrowDate, returnDate,
              fineAmount, daysLate,
              paymentDate, paymentMode);
        setTotalFine(totalFine);
    }

    public double getTotalFine() {
        return totalFine;
    }

    public void setTotalFine(double totalFine) throws LibraryDataException {
        if (totalFine <= 0) {
            throw new LibraryDataException("Total fine must be greater than 0");
        }
        this.totalFine = totalFine;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTotal Fine: $" + String.format("%.2f", totalFine);
    }
}


