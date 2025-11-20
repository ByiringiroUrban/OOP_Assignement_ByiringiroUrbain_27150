package _27150.q1;

import java.util.Scanner;
import _27150.StudentOutput;

/**
 * Main class for Hospital Management System
 * Handles user input using Scanner and creates HospitalRecord
 */
public class HospitalManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== HOSPITAL MANAGEMENT SYSTEM ==========");
        System.out.println("Please enter the following information:\n");
        
        try {
            // Get Entity information
            System.out.println("--- ENTITY INFORMATION ---");
            int id = getIntInput("Enter ID (must be > 0): ");
            String createdDate = getStringInput("Enter Created Date: ");
            String updatedDate = getStringInput("Enter Updated Date: ");
            
            // Get Patient information
            System.out.println("\n--- PATIENT INFORMATION ---");
            String patientName = getStringInput("Enter Patient Name: ");
            int age = getIntInput("Enter Age (must be > 0): ");
            String gender = getGenderInput("Enter Gender (Male/Female/Other): ");
            String contactNumber = getStringInput("Enter Contact Number: ");
            
            // Get Admission information
            System.out.println("\n--- ADMISSION INFORMATION ---");
            String admissionDate = getStringInput("Enter Admission Date: ");
            String roomNumber = getStringInput("Enter Room Number: ");
            double roomCharges = getDoubleInput("Enter Room Charges (must be > 0): ");
            
            // Get Treatment information
            System.out.println("\n--- TREATMENT INFORMATION ---");
            String diagnosis = getStringInput("Enter Diagnosis: ");
            String treatmentGiven = getStringInput("Enter Treatment Given: ");
            double treatmentCost = getDoubleInput("Enter Treatment Cost (must be > 0): ");
            
            // Get Bill information
            System.out.println("\n--- BILLING INFORMATION ---");
            double doctorFee = getDoubleInput("Enter Doctor Fee (must be > 0): ");
            double medicineCost = getDoubleInput("Enter Medicine Cost (must be > 0): ");
            
            // Create HospitalRecord object
            HospitalRecord record = new HospitalRecord(
                id, createdDate, updatedDate,
                patientName, age, gender, contactNumber,
                admissionDate, roomNumber, roomCharges,
                diagnosis, treatmentGiven, treatmentCost,
                doctorFee, medicineCost
            );
            
            // Generate and display the bill
            record.generateBill();
            record.displayRecord();
            
        } catch (HospitalDataException e) {
            System.out.println("\nERROR: " + e.getMessage());
            System.out.println("Please correct the input and try again.");
        } catch (Exception e) {
            System.out.println("\nUNEXPECTED ERROR: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    
    // Helper methods for input validation
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        while (input.isEmpty()) {
            System.out.print("This field cannot be empty. " + prompt);
            input = scanner.nextLine().trim();
        }
        return input;
    }
    
    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
    
    private static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
    
    private static String getGenderInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String gender = scanner.nextLine().trim();
            if (gender.equalsIgnoreCase("Male") || 
                gender.equalsIgnoreCase("Female") ||
                gender.equalsIgnoreCase("Other")) {
                return gender;
            }
            System.out.println("Invalid gender. Please enter 'Male', 'Female', or 'Other'.");
        }
    }
}

