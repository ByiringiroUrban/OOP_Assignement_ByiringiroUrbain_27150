package _27150.q4;

/**
 * Service class extending Booking with extra service information.
 */
public class Service extends Booking {
    private String serviceName;
    private double serviceCost;

    public Service(int id, String createdDate, String updatedDate,
                   String hotelName, String address, String phoneNumber, String email,
                   String roomNumber, String roomType, double pricePerNight,
                   String customerName, String customerEmail, String contactNumber,
                   String bookingDate, String checkInDate, String checkOutDate,
                   String serviceName, double serviceCost)
                   throws ReservationDataException {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email,
              roomNumber, roomType, pricePerNight,
              customerName, customerEmail, contactNumber,
              bookingDate, checkInDate, checkOutDate);
        setServiceName(serviceName);
        setServiceCost(serviceCost);
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) throws ReservationDataException {
        if (serviceName == null || serviceName.trim().isEmpty()) {
            throw new ReservationDataException("Service name cannot be null or empty");
        }
        this.serviceName = serviceName;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) throws ReservationDataException {
        if (serviceCost <= 0) {
            throw new ReservationDataException("Service cost must be greater than 0");
        }
        this.serviceCost = serviceCost;
    }

    @Override
    public String toString() {
        return super.toString() + "\nService: " + serviceName + ", Cost: $" + serviceCost;
    }
}


