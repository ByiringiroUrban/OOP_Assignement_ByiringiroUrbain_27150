package _27150.q2;

/**
 * Result class extending Exam with exam outcomes.
 */
public class Result extends Exam {
    private double obtainedMarks;
    private String remarks;

    public Result(int id, String createdDate, String updatedDate,
                  String schoolName, String address, String phoneNumber, String email,
                  String departmentName, String departmentCode,
                  String teacherName, String subject, String teacherEmail, String teacherPhone,
                  String studentName, int rollNumber, String grade, String contactNumber,
                  String courseName, String courseCode, int creditHours,
                  String examName, double maxMarks, String examDate,
                  double obtainedMarks, String remarks)
                  throws SchoolDataException {
        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email,
              departmentName, departmentCode, teacherName, subject, teacherEmail, teacherPhone,
              studentName, rollNumber, grade, contactNumber,
              courseName, courseCode, creditHours,
              examName, maxMarks, examDate);
        setObtainedMarks(obtainedMarks);
        setRemarks(remarks);
    }

    public double getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(double obtainedMarks) throws SchoolDataException {
        if (obtainedMarks < 0) {
            throw new SchoolDataException("Obtained marks cannot be negative");
        }
        if (obtainedMarks > getMaxMarks()) {
            throw new SchoolDataException("Obtained marks cannot exceed max marks");
        }
        this.obtainedMarks = obtainedMarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) throws SchoolDataException {
        if (remarks == null || remarks.trim().isEmpty()) {
            throw new SchoolDataException("Remarks cannot be null or empty");
        }
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return super.toString() + "\nResult: Obtained " + obtainedMarks + " (" + remarks + ")";
    }
}


