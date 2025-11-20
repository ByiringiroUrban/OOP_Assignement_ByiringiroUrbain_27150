package _27150.q2;

/**
 * Teacher class extending Department with teacher-specific attributes.
 */
public class Teacher extends Department {
    private String teacherName;
    private String subject;
    private String teacherEmail;
    private String phone;

    public Teacher(int id, String createdDate, String updatedDate,
                   String schoolName, String address, String phoneNumber, String email,
                   String departmentName, String departmentCode,
                   String teacherName, String subject, String teacherEmail, String phone)
                   throws SchoolDataException {
        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email,
              departmentName, departmentCode);
        setTeacherName(teacherName);
        setSubject(subject);
        setTeacherEmail(teacherEmail);
        setPhone(phone);
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) throws SchoolDataException {
        if (teacherName == null || teacherName.trim().isEmpty()) {
            throw new SchoolDataException("Teacher name cannot be null or empty");
        }
        this.teacherName = teacherName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) throws SchoolDataException {
        if (subject == null || subject.trim().isEmpty()) {
            throw new SchoolDataException("Subject cannot be null or empty");
        }
        this.subject = subject;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) throws SchoolDataException {
        validateEmail(teacherEmail);
        this.teacherEmail = teacherEmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws SchoolDataException {
        validatePhone(phone);
        this.phone = phone;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTeacher: " + teacherName + ", Subject: " + subject +
               ", Email: " + teacherEmail + ", Phone: " + phone;
    }
}


