package _27150.q1;

/**
 * Doctor class extending Department
 * Contains doctor-specific information
 */
public class Doctor extends Department {
    private String doctorName;
    private String specialization;
    private String doctorEmail;
    private String phone;
    
    // Constructor
    public Doctor(int id, String createdDate, String updatedDate,
                 String hospitalName, String address, String phoneNumber, String email,
                 String departmentName, String departmentCode,
                 String doctorName, String specialization, String doctorEmail, String phone) 
                 throws HospitalDataException {
        super(id, createdDate, updatedDate, hospitalName, address, phoneNumber, email,
              departmentName, departmentCode);
        setDoctorName(doctorName);
        setSpecialization(specialization);
        setDoctorEmail(doctorEmail);
        setPhone(phone);
    }
    
    // Getters and Setters with validation
    public String getDoctorName() {
        return doctorName;
    }
    
    public void setDoctorName(String doctorName) throws HospitalDataException {
        if (doctorName == null || doctorName.trim().isEmpty()) {
            throw new HospitalDataException("Doctor name cannot be null or empty");
        }
        this.doctorName = doctorName;
    }
    
    public String getSpecialization() {
        return specialization;
    }
    
    public void setSpecialization(String specialization) throws HospitalDataException {
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new HospitalDataException("Specialization cannot be null or empty");
        }
        this.specialization = specialization;
    }
    
    public String getDoctorEmail() {
        return doctorEmail;
    }
    
    public void setDoctorEmail(String doctorEmail) throws HospitalDataException {
        if (doctorEmail == null || doctorEmail.trim().isEmpty()) {
            throw new HospitalDataException("Doctor email cannot be null or empty");
        }
        // Validate email format
        if (!doctorEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new HospitalDataException("Invalid doctor email format");
        }
        this.doctorEmail = doctorEmail;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) throws HospitalDataException {
        if (phone == null || phone.trim().isEmpty()) {
            throw new HospitalDataException("Phone number cannot be null or empty");
        }
        // Validate phone number has exactly 10 digits
        String digitsOnly = phone.replaceAll("[^0-9]", "");
        if (digitsOnly.length() != 10) {
            throw new HospitalDataException("Phone number must contain exactly 10 digits");
        }
        this.phone = phone;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nDoctor Name: " + doctorName + 
               ", Specialization: " + specialization + ", Email: " + doctorEmail + 
               ", Phone: " + phone;
    }
}

