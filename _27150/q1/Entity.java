package _27150.q1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Base class Entity with common attributes: id, createdDate, updatedDate
 */
public class Entity {
    private int id;
    private String createdDate;
    private String updatedDate;
    
    // Constructor with validation
    public Entity(int id, String createdDate, String updatedDate) throws HospitalDataException {
        setId(id);
        setCreatedDate(createdDate);
        setUpdatedDate(updatedDate);
    }
    
    // Getters and Setters with validation
    public int getId() {
        return id;
    }
    
    public void setId(int id) throws HospitalDataException {
        if (id <= 0) {
            throw new HospitalDataException("ID must be greater than 0");
        }
        this.id = id;
    }
    
    public String getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedDate(String createdDate) throws HospitalDataException {
        if (createdDate == null || createdDate.trim().isEmpty()) {
            throw new HospitalDataException("Created date cannot be null or empty");
        }
        this.createdDate = createdDate;
    }
    
    public String getUpdatedDate() {
        return updatedDate;
    }
    
    public void setUpdatedDate(String updatedDate) throws HospitalDataException {
        if (updatedDate == null || updatedDate.trim().isEmpty()) {
            throw new HospitalDataException("Updated date cannot be null or empty");
        }
        this.updatedDate = updatedDate;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + ", Created Date: " + createdDate + ", Updated Date: " + updatedDate;
    }
}

