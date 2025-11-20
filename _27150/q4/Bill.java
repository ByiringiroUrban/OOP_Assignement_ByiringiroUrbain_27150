package _27150.q4;

/**
 * Bill class extending Payment with billing amounts.
 */
public class Bill extends Payment {
    private double roomCharge;
    private double serviceCharge;
    private double totalBill;

    public Bill(int id, String createdDate, String updatedDate,
                String hotelName, String address, String phoneNumber, String email,
                String roomNumber, String roomType, double pricePerNight,
                String customerName, String customerEmail, String contactNumber,
                String bookingDate, String checkInDate, String checkOutDate,
                String serviceName, double serviceCost,
                String paymentMethod, String paymentDate,
                double roomCharge, double serviceCharge, double totalBill)
                throws ReservationDataException {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email,
              roomNumber, roomType, pricePerNight,
              customerName, customerEmail, contactNumber,
              bookingDate, checkInDate, checkOutDate,
              serviceName, serviceCost,
              paymentMethod, paymentDate);
        setRoomCharge(roomCharge);
        setServiceCharge(serviceCharge);
        setTotalBill(totalBill);
    }

    public double getRoomCharge() {
        return roomCharge;
    }

    public void setRoomCharge(double roomCharge) throws ReservationDataException {
        if (roomCharge <= 0) {
            throw new ReservationDataException("Room charge must be greater than 0");
        }
        this.roomCharge = roomCharge;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) throws ReservationDataException {
        if (serviceCharge <= 0) {
            throw new ReservationDataException("Service charge must be greater than 0");
        }
        this.serviceCharge = serviceCharge;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) throws ReservationDataException {
        if (totalBill <= 0) {
            throw new ReservationDataException("Total bill must be greater than 0");
        }
        this.totalBill = totalBill;
    }

    @Override
    public String toString() {
        return super.toString() + "\nBill: Room $" + roomCharge +
               ", Service $" + serviceCharge + ", Total $" + totalBill;
    }
}


