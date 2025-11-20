package _27150.q2;

/**
 * Base class Entity with shared attributes across hierarchy.
 */
public class Entity {
    private int id;
    private String createdDate;
    private String updatedDate;

    public Entity(int id, String createdDate, String updatedDate) throws SchoolDataException {
        setId(id);
        setCreatedDate(createdDate);
        setUpdatedDate(updatedDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws SchoolDataException {
        if (id <= 0) {
            throw new SchoolDataException("ID must be greater than 0");
        }
        this.id = id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) throws SchoolDataException {
        if (createdDate == null || createdDate.trim().isEmpty()) {
            throw new SchoolDataException("Created date cannot be null or empty");
        }
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) throws SchoolDataException {
        if (updatedDate == null || updatedDate.trim().isEmpty()) {
            throw new SchoolDataException("Updated date cannot be null or empty");
        }
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Created Date: " + createdDate + ", Updated Date: " + updatedDate;
    }
}


