package _27150.q7;

/**
 * Agency class extending Entity with agency details.
 */
public class Agency extends Entity {
    private String agencyName;
    private String location;
    private String phoneNumber;

    public Agency(int id, String createdDate, String updatedDate,
                  String agencyName, String location, String phoneNumber)
                  throws RealEstateDataException {
        super(id, createdDate, updatedDate);
        setAgencyName(agencyName);
        setLocation(location);
        setPhoneNumber(phoneNumber);
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) throws RealEstateDataException {
        if (agencyName == null || agencyName.trim().isEmpty()) {
            throw new RealEstateDataException("Agency name cannot be null or empty");
        }
        this.agencyName = agencyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) throws RealEstateDataException {
        if (location == null || location.trim().isEmpty()) {
            throw new RealEstateDataException("Location cannot be null or empty");
        }
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws RealEstateDataException {
        validatePhone(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    protected void validatePhone(String phone) throws RealEstateDataException {
        if (phone == null || phone.trim().isEmpty()) {
            throw new RealEstateDataException("Phone number cannot be null or empty");
        }
        String digitsOnly = phone.replaceAll("[^0-9]", "");
        if (digitsOnly.length() != 10) {
            throw new RealEstateDataException("Phone number must contain exactly 10 digits");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nAgency: " + agencyName + ", Location: " + location +
               ", Phone: " + phoneNumber;
    }
}


