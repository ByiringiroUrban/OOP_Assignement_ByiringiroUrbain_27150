package _27150.q2;

/**
 * School class extending Entity with school-specific details.
 */
public class School extends Entity {
    private String schoolName;
    private String address;
    private String phoneNumber;
    private String email;

    public School(int id, String createdDate, String updatedDate,
                  String schoolName, String address, String phoneNumber, String email)
                  throws SchoolDataException {
        super(id, createdDate, updatedDate);
        setSchoolName(schoolName);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) throws SchoolDataException {
        if (schoolName == null || schoolName.trim().isEmpty()) {
            throw new SchoolDataException("School name cannot be null or empty");
        }
        this.schoolName = schoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws SchoolDataException {
        if (address == null || address.trim().isEmpty()) {
            throw new SchoolDataException("Address cannot be null or empty");
        }
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws SchoolDataException {
        validatePhone(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws SchoolDataException {
        validateEmail(email);
        this.email = email;
    }

    protected void validatePhone(String phone) throws SchoolDataException {
        if (phone == null || phone.trim().isEmpty()) {
            throw new SchoolDataException("Phone number cannot be null or empty");
        }
        String digitsOnly = phone.replaceAll("[^0-9]", "");
        if (digitsOnly.length() != 10) {
            throw new SchoolDataException("Phone number must contain exactly 10 digits");
        }
    }

    protected void validateEmail(String email) throws SchoolDataException {
        if (email == null || email.trim().isEmpty()) {
            throw new SchoolDataException("Email cannot be null or empty");
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new SchoolDataException("Invalid email format");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nSchool: " + schoolName + ", Address: " + address +
               ", Phone: " + phoneNumber + ", Email: " + email;
    }
}


