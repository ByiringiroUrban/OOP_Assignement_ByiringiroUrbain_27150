package _27150.q8;

/**
 * Section class extending Library with section-specific info.
 */
public class Section extends Library {
    private String sectionName;
    private String sectionCode;

    public Section(int id, String createdDate, String updatedDate,
                   String libraryName, String location, String phoneNumber,
                   String sectionName, String sectionCode)
                   throws LibraryDataException {
        super(id, createdDate, updatedDate, libraryName, location, phoneNumber);
        setSectionName(sectionName);
        setSectionCode(sectionCode);
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) throws LibraryDataException {
        if (sectionName == null || sectionName.trim().isEmpty()) {
            throw new LibraryDataException("Section name cannot be null or empty");
        }
        this.sectionName = sectionName;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) throws LibraryDataException {
        if (sectionCode == null || sectionCode.trim().isEmpty()) {
            throw new LibraryDataException("Section code cannot be null or empty");
        }
        if (sectionCode.length() < 3) {
            throw new LibraryDataException("Section code must be at least 3 characters");
        }
        this.sectionCode = sectionCode.toUpperCase();
    }

    @Override
    public String toString() {
        return super.toString() + "\nSection: " + sectionName + " (" + sectionCode + ")";
    }
}


