package _27150.q2;

/**
 * Final StudentRecord class extending Fee with business logic.
 */
public final class StudentRecord extends Fee {
    private double averageMarks;

    public StudentRecord(int id, String createdDate, String updatedDate,
                         String schoolName, String address, String phoneNumber, String email,
                         String departmentName, String departmentCode,
                         String teacherName, String subject, String teacherEmail, String teacherPhone,
                         String studentName, int rollNumber, String grade, String contactNumber,
                         String courseName, String courseCode, int creditHours,
                         String examName, double maxMarks, String examDate,
                         double obtainedMarks, String remarks,
                         double tuitionFee, double examFee)
                         throws SchoolDataException {
        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email,
              departmentName, departmentCode, teacherName, subject, teacherEmail, teacherPhone,
              studentName, rollNumber, grade, contactNumber,
              courseName, courseCode, creditHours,
              examName, maxMarks, examDate,
              obtainedMarks, remarks,
              tuitionFee, examFee, tuitionFee + examFee);
        generateBill();
        calculateAverageMarks();
    }

    public double getAverageMarks() {
        return averageMarks;
    }

    /**
     * Calculates the average marks percentage for the student.
     */
    public double calculateAverageMarks() {
        this.averageMarks = (getObtainedMarks() / getMaxMarks()) * 100.0;
        return this.averageMarks;
    }

    /**
     * Generates the total fee payable by the student.
     * Formula: totalFee = tuitionFee + examFee
     */
    public void generateBill() {
        double total = getTuitionFee() + getExamFee();
        try {
            setTotalFee(total);
        } catch (SchoolDataException e) {
            throw new IllegalStateException("Failed to set total fee: " + e.getMessage(), e);
        }
    }

    /**
     * Display all key information for the student record.
     */
    public void displayRecord() {
        System.out.println("\n========== SCHOOL MANAGEMENT SYSTEM - STUDENT RECORD ==========");
        System.out.println("--- SCHOOL DETAILS ---");
        System.out.println("School: " + getSchoolName());
        System.out.println("Department: " + getDepartmentName() + " (" + getDepartmentCode() + ")");
        System.out.println("Teacher: " + getTeacherName() + " - " + getSubject());

        System.out.println("\n--- STUDENT DETAILS ---");
        System.out.println("Student ID: " + getId());
        System.out.println("Name: " + getStudentName());
        System.out.println("Roll Number: " + getRollNumber());
        System.out.println("Grade: " + getGrade());
        System.out.println("Contact: " + getContactNumber());

        System.out.println("\n--- COURSE DETAILS ---");
        System.out.println("Course: " + getCourseName() + " (" + getCourseCode() + ")");
        System.out.println("Credit Hours: " + getCreditHours());

        System.out.println("\n--- EXAM DETAILS ---");
        System.out.println("Exam: " + getExamName());
        System.out.println("Exam Date: " + getExamDate());
        System.out.println("Max Marks: " + getMaxMarks());
        System.out.println("Obtained Marks: " + getObtainedMarks());
        System.out.println("Remarks: " + getRemarks());
        System.out.println("Average: " + String.format("%.2f", getAverageMarks()) + "%");

        System.out.println("\n--- FEE DETAILS ---");
        System.out.println("Tuition Fee: $" + String.format("%.2f", getTuitionFee()));
        System.out.println("Exam Fee: $" + String.format("%.2f", getExamFee()));
        System.out.println("----------------------------------------");
        System.out.println("TOTAL FEE: $" + String.format("%.2f", getTotalFee()));
        System.out.println("==============================================================\n");
    }
}


