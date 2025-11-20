package _27150.q2;

/**
 * Fee class extending Result with fee-related attributes.
 */
public class Fee extends Result {
    private double tuitionFee;
    private double examFee;
    private double totalFee;

    public Fee(int id, String createdDate, String updatedDate,
               String schoolName, String address, String phoneNumber, String email,
               String departmentName, String departmentCode,
               String teacherName, String subject, String teacherEmail, String teacherPhone,
               String studentName, int rollNumber, String grade, String contactNumber,
               String courseName, String courseCode, int creditHours,
               String examName, double maxMarks, String examDate,
               double obtainedMarks, String remarks,
               double tuitionFee, double examFee, double totalFee)
               throws SchoolDataException {
        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email,
              departmentName, departmentCode, teacherName, subject, teacherEmail, teacherPhone,
              studentName, rollNumber, grade, contactNumber,
              courseName, courseCode, creditHours,
              examName, maxMarks, examDate,
              obtainedMarks, remarks);
        setTuitionFee(tuitionFee);
        setExamFee(examFee);
        setTotalFee(totalFee);
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) throws SchoolDataException {
        if (tuitionFee <= 0) {
            throw new SchoolDataException("Tuition fee must be greater than 0");
        }
        this.tuitionFee = tuitionFee;
    }

    public double getExamFee() {
        return examFee;
    }

    public void setExamFee(double examFee) throws SchoolDataException {
        if (examFee <= 0) {
            throw new SchoolDataException("Exam fee must be greater than 0");
        }
        this.examFee = examFee;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) throws SchoolDataException {
        if (totalFee <= 0) {
            throw new SchoolDataException("Total fee must be greater than 0");
        }
        this.totalFee = totalFee;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFees: Tuition $" + String.format("%.2f", tuitionFee) +
               ", Exam $" + String.format("%.2f", examFee) +
               ", Total $" + String.format("%.2f", totalFee);
    }
}


