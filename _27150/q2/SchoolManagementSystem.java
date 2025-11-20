package _27150.q2;

import java.util.Scanner;
import _27150.StudentOutput;

/**
 * Console runner for the School Management System (Question 2).
 */
public class SchoolManagementSystem {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        StudentOutput.enable();
        System.out.println("========== SCHOOL MANAGEMENT SYSTEM ==========");
        System.out.println("Enter the requested details to create a student record.\n");

        try {
            int id = getIntInput("Enter Entity ID (> 0): ");
            String createdDate = getNonEmptyString("Enter Created Date: ");
            String updatedDate = getNonEmptyString("Enter Updated Date: ");

            System.out.println("\n--- SCHOOL INFORMATION ---");
            String schoolName = getNonEmptyString("School Name: ");
            String schoolAddress = getNonEmptyString("School Address: ");
            String schoolPhone = getNonEmptyString("School Phone (10 digits): ");
            String schoolEmail = getNonEmptyString("School Email: ");

            System.out.println("\n--- DEPARTMENT INFORMATION ---");
            String departmentName = getNonEmptyString("Department Name: ");
            String departmentCode = getNonEmptyString("Department Code (>= 3 chars): ");

            System.out.println("\n--- TEACHER INFORMATION ---");
            String teacherName = getNonEmptyString("Teacher Name: ");
            String teacherSubject = getNonEmptyString("Subject: ");
            String teacherEmail = getNonEmptyString("Teacher Email: ");
            String teacherPhone = getNonEmptyString("Teacher Phone (10 digits): ");

            System.out.println("\n--- STUDENT INFORMATION ---");
            String studentName = getNonEmptyString("Student Name: ");
            int rollNumber = getIntInput("Roll Number (> 0): ");
            String grade = getNonEmptyString("Grade: ");
            String studentContact = getNonEmptyString("Student Contact (10 digits): ");

            System.out.println("\n--- COURSE INFORMATION ---");
            String courseName = getNonEmptyString("Course Name: ");
            String courseCode = getNonEmptyString("Course Code (>= 3 chars): ");
            int creditHours = getIntInput("Credit Hours (> 0): ");

            System.out.println("\n--- EXAM INFORMATION ---");
            String examName = getNonEmptyString("Exam Name: ");
            double maxMarks = getDoubleInput("Max Marks (> 0): ");
            String examDate = getNonEmptyString("Exam Date: ");

            System.out.println("\n--- RESULT INFORMATION ---");
            double obtainedMarks = getDoubleInput("Obtained Marks (>= 0): ");
            String remarks = getNonEmptyString("Remarks: ");

            System.out.println("\n--- FEE INFORMATION ---");
            double tuitionFee = getDoubleInput("Tuition Fee (> 0): ");
            double examFee = getDoubleInput("Exam Fee (> 0): ");

            StudentRecord record = new StudentRecord(
                id, createdDate, updatedDate,
                schoolName, schoolAddress, schoolPhone, schoolEmail,
                departmentName, departmentCode,
                teacherName, teacherSubject, teacherEmail, teacherPhone,
                studentName, rollNumber, grade, studentContact,
                courseName, courseCode, creditHours,
                examName, maxMarks, examDate,
                obtainedMarks, remarks,
                tuitionFee, examFee
            );

            record.generateBill();
            record.calculateAverageMarks();
            record.displayRecord();

        } catch (SchoolDataException e) {
            System.out.println("\nERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\nUNEXPECTED ERROR: " + e.getMessage());
            e.printStackTrace();
        } finally {
            SCANNER.close();
        }
    }

    private static String getNonEmptyString(String prompt) {
        System.out.print(prompt);
        String input = SCANNER.nextLine().trim();
        while (input.isEmpty()) {
            System.out.print("Value cannot be empty. " + prompt);
            input = SCANNER.nextLine().trim();
        }
        return input;
    }

    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(SCANNER.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid integer.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(SCANNER.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid decimal value.");
            }
        }
    }
}


