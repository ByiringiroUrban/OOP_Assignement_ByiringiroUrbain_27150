package _27150.q3;

/**
 * Base Entity class shared across the payroll hierarchy.
 */
public class Entity {
    private int id;
    private String createdDate;
    private String updatedDate;

    public Entity(int id, String createdDate, String updatedDate) throws PayrollDataException {
        setId(id);
        setCreatedDate(createdDate);
        setUpdatedDate(updatedDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws PayrollDataException {
        if (id <= 0) {
            throw new PayrollDataException("ID must be greater than 0");
        }
        this.id = id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) throws PayrollDataException {
        if (createdDate == null || createdDate.trim().isEmpty()) {
            throw new PayrollDataException("Created date cannot be null or empty");
        }
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) throws PayrollDataException {
        if (updatedDate == null || updatedDate.trim().isEmpty()) {
            throw new PayrollDataException("Updated date cannot be null or empty");
        }
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Created: " + createdDate + ", Updated: " + updatedDate;
    }
}


