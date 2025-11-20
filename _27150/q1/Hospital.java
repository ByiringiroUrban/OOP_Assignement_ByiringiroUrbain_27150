package _27150.q1;

/**
 * Hospital class extending Entity
 * Contains hospital-specific information
 */
public class Hospital extends Entity {
    private String hospitalName;
    private String address;
    private String phoneNumber;
    private String email;
    
    // Constructor
    public Hospital(int id, String createdDate, String updatedDate, 
                   String hospitalName, String address, String phoneNumber, String email) 
                   throws HospitalDataException {
        super(id, createdDate, updatedDate);
        setHospitalName(hospitalName);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }
    
    // Getters and Setters with validation
    public String getHospitalName() {
        return hospitalName;
    }
    
    public void setHospitalName(String hospitalName) throws HospitalDataException {
        if (hospitalName == null || hospitalName.trim().isEmpty()) {
            throw new HospitalDataException("Hospital name cannot be null or empty");
        }
        this.hospitalName = hospitalName;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) throws HospitalDataException {
        if (address == null || address.trim().isEmpty()) {
            throw new HospitalDataException("Address cannot be null or empty");
        }
        this.address = address;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) throws HospitalDataException {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new HospitalDataException("Phone number cannot be null or empty");
        }
        // Validate phone number has exactly 10 digits
        String digitsOnly = phoneNumber.replaceAll("[^0-9]", "");
        if (digitsOnly.length() != 10) {
            throw new HospitalDataException("Phone number must contain exactly 10 digits");
        }
        this.phoneNumber = phoneNumber;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) throws HospitalDataException {
        if (email == null || email.trim().isEmpty()) {
            throw new HospitalDataException("Email cannot be null or empty");
        }
        // Basic email validation
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new HospitalDataException("Invalid email format");
        }
        this.email = email;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nHospital Name: " + hospitalName + 
               ", Address: " + address + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}

