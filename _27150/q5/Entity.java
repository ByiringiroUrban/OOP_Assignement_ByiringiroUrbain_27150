package _27150.q5;

/**
 * Base Entity class for shared attributes.
 */
public class Entity {
    private int id;
    private String createdDate;
    private String updatedDate;

    public Entity(int id, String createdDate, String updatedDate) throws RentalDataException {
        setId(id);
        setCreatedDate(createdDate);
        setUpdatedDate(updatedDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws RentalDataException {
        if (id <= 0) {
            throw new RentalDataException("ID must be greater than 0");
        }
        this.id = id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) throws RentalDataException {
        if (createdDate == null || createdDate.trim().isEmpty()) {
            throw new RentalDataException("Created date cannot be null or empty");
        }
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) throws RentalDataException {
        if (updatedDate == null || updatedDate.trim().isEmpty()) {
            throw new RentalDataException("Updated date cannot be null or empty");
        }
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Created: " + createdDate + ", Updated: " + updatedDate;
    }
}


