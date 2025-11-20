package _27150.q8;

/**
 * Book class extending Section with book details.
 */
public class Book extends Section {
    private String title;
    private String author;
    private String isbn;

    public Book(int id, String createdDate, String updatedDate,
                String libraryName, String location, String phoneNumber,
                String sectionName, String sectionCode,
                String title, String author, String isbn)
                throws LibraryDataException {
        super(id, createdDate, updatedDate, libraryName, location, phoneNumber,
              sectionName, sectionCode);
        setTitle(title);
        setAuthor(author);
        setIsbn(isbn);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws LibraryDataException {
        if (title == null || title.trim().isEmpty()) {
            throw new LibraryDataException("Title cannot be null or empty");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws LibraryDataException {
        if (author == null || author.trim().isEmpty()) {
            throw new LibraryDataException("Author cannot be null or empty");
        }
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) throws LibraryDataException {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new LibraryDataException("ISBN cannot be null or empty");
        }
        if (isbn.replaceAll("[^0-9A-Za-z]", "").length() < 10) {
            throw new LibraryDataException("ISBN must be at least 10 characters");
        }
        this.isbn = isbn.toUpperCase();
    }

    @Override
    public String toString() {
        return super.toString() + "\nBook: " + title + " by " + author + " (ISBN: " + isbn + ")";
    }
}


