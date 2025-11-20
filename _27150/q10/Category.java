package _27150.q10;

/**
 * Category class extending Store with category details.
 */
public class Category extends Store {
    private String categoryName;
    private String categoryCode;

    public Category(int id, String createdDate, String updatedDate,
                    String storeName, String address, String email,
                    String categoryName, String categoryCode)
                    throws ShoppingDataException {
        super(id, createdDate, updatedDate, storeName, address, email);
        setCategoryName(categoryName);
        setCategoryCode(categoryCode);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) throws ShoppingDataException {
        if (categoryName == null || categoryName.trim().isEmpty()) {
            throw new ShoppingDataException("Category name cannot be null or empty");
        }
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) throws ShoppingDataException {
        if (categoryCode == null || categoryCode.trim().isEmpty()) {
            throw new ShoppingDataException("Category code cannot be null or empty");
        }
        if (categoryCode.length() < 3) {
            throw new ShoppingDataException("Category code must be at least 3 characters");
        }
        this.categoryCode = categoryCode.toUpperCase();
    }

    @Override
    public String toString() {
        return super.toString() + "\nCategory: " + categoryName + " (" + categoryCode + ")";
    }
}


