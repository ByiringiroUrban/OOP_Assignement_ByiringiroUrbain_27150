package _27150.q8;

/**
 * Final LibraryRecord class extending Record with calculations.
 */
public final class LibraryRecord extends Record {
    public LibraryRecord(int id, String createdDate, String updatedDate,
                         String libraryName, String location, String phoneNumber,
                         String sectionName, String sectionCode,
                         String title, String author, String isbn,
                         String memberName, int memberId, String contactNumber,
                         String borrowDate, String returnDate,
                         double fineAmount, int daysLate,
                         String paymentDate, String paymentMode)
                         throws LibraryDataException {
        super(id, createdDate, updatedDate,
              libraryName, location, phoneNumber,
              sectionName, sectionCode,
              title, author, isbn,
              memberName, memberId, contactNumber,
              borrowDate, returnDate,
              fineAmount, daysLate,
              paymentDate, paymentMode,
              Math.max(0.01, fineAmount * Math.max(daysLate, 1)));
        calculateFine();
    }

    public double calculateFine() {
        double total = getFineAmount() * getDaysLate();
        if (total <= 0) {
            total = getFineAmount(); // if no late days, still at least base fine
        }
        try {
            setTotalFine(total);
        } catch (LibraryDataException e) {
            throw new IllegalStateException("Failed to set total fine: " + e.getMessage(), e);
        }
        return total;
    }

    public void displayRecord() {
        System.out.println("\n========== LIBRARY RECORD ==========");
        System.out.println("Library: " + getLibraryName() + " (" + getLocation() + ")");
        System.out.println("Section: " + getSectionName() + " [" + getSectionCode() + "]");

        System.out.println("\n--- BOOK ---");
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("ISBN: " + getIsbn());

        System.out.println("\n--- MEMBER ---");
        System.out.println("Name: " + getMemberName());
        System.out.println("ID: " + getMemberId());
        System.out.println("Contact: " + getContactNumber());

        System.out.println("\n--- BORROW INFO ---");
        System.out.println("Borrow Date: " + getBorrowDate());
        System.out.println("Return Date: " + getReturnDate());

        System.out.println("\n--- FINE ---");
        System.out.println("Fine Amount: $" + String.format("%.2f", getFineAmount()));
        System.out.println("Days Late: " + getDaysLate());
        System.out.println("Total Fine: $" + String.format("%.2f", getTotalFine()));

        System.out.println("\n--- PAYMENT ---");
        System.out.println("Payment Date: " + getPaymentDate());
        System.out.println("Payment Mode: " + getPaymentMode());

        System.out.println("====================================\n");
    }
}


