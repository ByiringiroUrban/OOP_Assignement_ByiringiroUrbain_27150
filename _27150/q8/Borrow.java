package _27150.q8;

/**
 * Borrow class extending Member with borrowing details.
 */
public class Borrow extends Member {
    private String borrowDate;
    private String returnDate;

    public Borrow(int id, String createdDate, String updatedDate,
                  String libraryName, String location, String phoneNumber,
                  String sectionName, String sectionCode,
                  String title, String author, String isbn,
                  String memberName, int memberId, String contactNumber,
                  String borrowDate, String returnDate)
                  throws LibraryDataException {
        super(id, createdDate, updatedDate, libraryName, location, phoneNumber,
              sectionName, sectionCode,
              title, author, isbn,
              memberName, memberId, contactNumber);
        setBorrowDate(borrowDate);
        setReturnDate(returnDate);
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) throws LibraryDataException {
        if (borrowDate == null || borrowDate.trim().isEmpty()) {
            throw new LibraryDataException("Borrow date cannot be null or empty");
        }
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) throws LibraryDataException {
        if (returnDate == null || returnDate.trim().isEmpty()) {
            throw new LibraryDataException("Return date cannot be null or empty");
        }
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return super.toString() + "\nBorrowed on: " + borrowDate + ", Return by: " + returnDate;
    }
}


