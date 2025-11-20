package _27150.q7;

/**
 * Agent class extending Agency with agent details.
 */
public class Agent extends Agency {
    private String agentName;
    private String email;
    private String licenseNumber;

    public Agent(int id, String createdDate, String updatedDate,
                 String agencyName, String location, String phoneNumber,
                 String agentName, String email, String licenseNumber)
                 throws RealEstateDataException {
        super(id, createdDate, updatedDate, agencyName, location, phoneNumber);
        setAgentName(agentName);
        setEmail(email);
        setLicenseNumber(licenseNumber);
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) throws RealEstateDataException {
        if (agentName == null || agentName.trim().isEmpty()) {
            throw new RealEstateDataException("Agent name cannot be null or empty");
        }
        this.agentName = agentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws RealEstateDataException {
        if (email == null || email.trim().isEmpty()) {
            throw new RealEstateDataException("Email cannot be null or empty");
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new RealEstateDataException("Invalid email format");
        }
        this.email = email;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) throws RealEstateDataException {
        if (licenseNumber == null || licenseNumber.trim().isEmpty()) {
            throw new RealEstateDataException("License number cannot be null or empty");
        }
        this.licenseNumber = licenseNumber.toUpperCase();
    }

    @Override
    public String toString() {
        return super.toString() + "\nAgent: " + agentName + ", Email: " + email +
               ", License: " + licenseNumber;
    }
}


