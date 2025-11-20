package _27150.q2;

/**
 * Course class extending Student with course information.
 */
public class Course extends Student {
    private String courseName;
    private String courseCode;
    private int creditHours;

    public Course(int id, String createdDate, String updatedDate,
                  String schoolName, String address, String phoneNumber, String email,
                  String departmentName, String departmentCode,
                  String teacherName, String subject, String teacherEmail, String teacherPhone,
                  String studentName, int rollNumber, String grade, String contactNumber,
                  String courseName, String courseCode, int creditHours)
                  throws SchoolDataException {
        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email,
              departmentName, departmentCode, teacherName, subject, teacherEmail, teacherPhone,
              studentName, rollNumber, grade, contactNumber);
        setCourseName(courseName);
        setCourseCode(courseCode);
        setCreditHours(creditHours);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) throws SchoolDataException {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new SchoolDataException("Course name cannot be null or empty");
        }
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) throws SchoolDataException {
        if (courseCode == null || courseCode.trim().isEmpty()) {
            throw new SchoolDataException("Course code cannot be null or empty");
        }
        if (courseCode.length() < 3 || !courseCode.matches("^[A-Za-z0-9]+$")) {
            throw new SchoolDataException("Course code must be at least 3 alphanumeric characters");
        }
        this.courseCode = courseCode.toUpperCase();
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) throws SchoolDataException {
        if (creditHours <= 0) {
            throw new SchoolDataException("Credit hours must be greater than 0");
        }
        this.creditHours = creditHours;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCourse: " + courseName + " (" + courseCode + "), Credits: " + creditHours;
    }
}


