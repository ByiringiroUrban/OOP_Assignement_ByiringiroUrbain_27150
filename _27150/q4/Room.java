package _27150.q4;

/**
 * Room class extending Hotel with room-specific information.
 */
public class Room extends Hotel {
    private String roomNumber;
    private String roomType;
    private double pricePerNight;

    public Room(int id, String createdDate, String updatedDate,
                String hotelName, String address, String phoneNumber, String email,
                String roomNumber, String roomType, double pricePerNight)
                throws ReservationDataException {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email);
        setRoomNumber(roomNumber);
        setRoomType(roomType);
        setPricePerNight(pricePerNight);
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) throws ReservationDataException {
        if (roomNumber == null || roomNumber.trim().isEmpty()) {
            throw new ReservationDataException("Room number cannot be null or empty");
        }
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) throws ReservationDataException {
        if (roomType == null || roomType.trim().isEmpty()) {
            throw new ReservationDataException("Room type cannot be null or empty");
        }
        this.roomType = roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) throws ReservationDataException {
        if (pricePerNight <= 0) {
            throw new ReservationDataException("Price per night must be greater than 0");
        }
        this.pricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return super.toString() + "\nRoom: " + roomNumber + " (" + roomType + "), $" + pricePerNight + " per night";
    }
}


