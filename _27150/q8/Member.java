package _27150.q8;

/**
 * Member class extending Book with member information.
 */
public class Member extends Book {
    private String memberName;
    private int memberId;
    private String contactNumber;

    public Member(int id, String createdDate, String updatedDate,
                  String libraryName, String location, String phoneNumber,
                  String sectionName, String sectionCode,
                  String title, String author, String isbn,
                  String memberName, int memberId, String contactNumber)
                  throws LibraryDataException {
        super(id, createdDate, updatedDate, libraryName, location, phoneNumber,
              sectionName, sectionCode,
              title, author, isbn);
        setMemberName(memberName);
        setMemberId(memberId);
        setContactNumber(contactNumber);
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) throws LibraryDataException {
        if (memberName == null || memberName.trim().isEmpty()) {
            throw new LibraryDataException("Member name cannot be null or empty");
        }
        this.memberName = memberName;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) throws LibraryDataException {
        if (memberId <= 0) {
            throw new LibraryDataException("Member ID must be greater than 0");
        }
        this.memberId = memberId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) throws LibraryDataException {
        validatePhone(contactNumber);
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMember: " + memberName + " (ID: " + memberId +
               "), Contact: " + contactNumber;
    }
}


