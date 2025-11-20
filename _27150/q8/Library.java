package _27150.q8;

/**
 * Library class extending Entity with library details.
 */
public class Library extends Entity {
    private String libraryName;
    private String location;
    private String phoneNumber;

    public Library(int id, String createdDate, String updatedDate,
                   String libraryName, String location, String phoneNumber)
                   throws LibraryDataException {
        super(id, createdDate, updatedDate);
        setLibraryName(libraryName);
        setLocation(location);
        setPhoneNumber(phoneNumber);
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) throws LibraryDataException {
        if (libraryName == null || libraryName.trim().isEmpty()) {
            throw new LibraryDataException("Library name cannot be null or empty");
        }
        this.libraryName = libraryName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) throws LibraryDataException {
        if (location == null || location.trim().isEmpty()) {
            throw new LibraryDataException("Location cannot be null or empty");
        }
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws LibraryDataException {
        validatePhone(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    protected void validatePhone(String phone) throws LibraryDataException {
        if (phone == null || phone.trim().isEmpty()) {
            throw new LibraryDataException("Phone number cannot be null or empty");
        }
        String digitsOnly = phone.replaceAll("[^0-9]", "");
        if (digitsOnly.length() != 10) {
            throw new LibraryDataException("Phone number must contain exactly 10 digits");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nLibrary: " + libraryName + ", Location: " + location +
               ", Phone: " + phoneNumber;
    }
}


