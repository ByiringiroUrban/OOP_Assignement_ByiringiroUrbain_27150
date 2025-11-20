package _27150.q10;

import java.util.Scanner;
import _27150.StudentOutput;

/**
 * Console runner for the Online Shopping System.
 */
public class OnlineShoppingSystem {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== ONLINE SHOPPING SYSTEM ==========");

        try {
            int id = getInt("Enter Entity ID (> 0): ");
            String createdDate = getString("Created Date: ");
            String updatedDate = getString("Updated Date: ");

            System.out.println("\n--- STORE INFO ---");
            String storeName = getString("Store Name: ");
            String storeAddress = getString("Store Address: ");
            String storeEmail = getString("Store Email: ");

            System.out.println("\n--- CATEGORY INFO ---");
            String categoryName = getString("Category Name: ");
            String categoryCode = getString("Category Code (>= 3 chars): ");

            System.out.println("\n--- PRODUCT INFO ---");
            String productName = getString("Product Name: ");
            String productCode = getString("Product Code: ");
            double price = getDouble("Product Price (> 0): ");

            System.out.println("\n--- CUSTOMER INFO ---");
            String customerName = getString("Customer Name: ");
            String contactNumber = getString("Customer Contact: ");
            String customerAddress = getString("Customer Address: ");

            System.out.println("\n--- ORDER INFO ---");
            String orderDate = getString("Order Date: ");
            String orderId = getString("Order ID: ");

            System.out.println("\n--- PAYMENT INFO ---");
            String paymentMethod = getString("Payment Method: ");
            String paymentStatus = getString("Payment Status: ");

            System.out.println("\n--- SHIPPING INFO ---");
            String shippingAddress = getString("Shipping Address: ");
            double shippingCost = getDouble("Shipping Cost (>= 0): ");

            OrderRecord record = new OrderRecord(
                id, createdDate, updatedDate,
                storeName, storeAddress, storeEmail,
                categoryName, categoryCode,
                productName, productCode, price,
                customerName, contactNumber, customerAddress,
                orderDate, orderId,
                paymentMethod, paymentStatus,
                shippingAddress, shippingCost
            );

            record.calculateTotalAmount();
            record.displayRecord();

        } catch (ShoppingDataException e) {
            System.out.println("\nERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\nUNEXPECTED ERROR: " + e.getMessage());
            e.printStackTrace();
        } finally {
            SCANNER.close();
        }
    }

    private static String getString(String prompt) {
        System.out.print(prompt);
        String value = SCANNER.nextLine().trim();
        while (value.isEmpty()) {
            System.out.print("Value cannot be empty. " + prompt);
            value = SCANNER.nextLine().trim();
        }
        return value;
    }

    private static int getInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(SCANNER.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid integer. Try again.");
            }
        }
    }

    private static double getDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(SCANNER.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }
}


