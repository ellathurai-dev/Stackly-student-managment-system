package projects.Student;

public class Student {

    private int id;
    private String name;
    private String email;
    private double marks;
    private int attendance;
    private StudentStatus status;
    private Course course;

    public Student(int id, String name, String email, double marks,
                   int attendance, StudentStatus status, Course course) {

        this.id = id;
        this.name = name;
        this.email = email;
        
        setMarks(marks);
        setAttendance(attendance);
        
        this.status = status;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getMarks() {
        return marks;
    }

    public int getAttendance() {
        return attendance;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public Course getCourse() {
        return course;
    }

    public void setMarks(double marks) {
        if (marks < 0 || marks > 100) {
              throw new IllegalArgumentException("Marks must be 0 to 100");
        }
        this.marks = marks;
    }

    public void setAttendance(int attendance) {
        if (attendance < 0 || attendance > 100) {
              throw new IllegalArgumentException("Attendance must be 0 to 100");
        }
        this.attendance = attendance;
    }

    public String calculateGrade() {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 75) {
            return "B";
        } else if (marks >= 50) {
            return "C";
        } else {
            return "F";
        }
    }

    public String toString() {
        return "ID: " + id +
                " | Name: " + name +
                " | Email: " + email +
                " | Course: " + course +
                " | Marks: " + marks +
                " | Grade: " + calculateGrade() +
                " | Attendance: " + attendance + "%" +
                " | Status: " + status;
    }
}