package projects.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentService {

    
	
	private Map<Integer, Student> students = new HashMap<>();

   public void addStudent(Student student) {

        if (students.containsKey(student.getId())) {
               throw new IllegalArgumentException("ID already exists!");
        }

     students.put(student.getId(), student);
        System.out.println("Student added!");
    }

    public void displayAllStudents() {

        if (students.isEmpty()) {
               System.out.println("No students available!");
            return;
        }

        for (Student student : students.values()) {
          System.out.println(student);
        }
    }

    public Student searchById(int id) {

          Student student = students.get(id);

        if (student == null) {
         throw new IllegalArgumentException("Student not found!");
        }

            return student;
    }

    public void searchByName(String name) {

            boolean found = false;

        for (Student student : students.values()) {
           if (student.getName().equalsIgnoreCase(name)) {
                System.out.println(student);
                    found = true;
            }
        }

        if (!found) {
               System.out.println("Student not found!");
        }
    }

    public void updateMarks(int id, double marks) {
         Student student = searchById(id);
          student.setMarks(marks);
           System.out.println("Marks updated!");
    }

    public void updateAttendance(int id, int attendance) {
        Student student = searchById(id);
        student.setAttendance(attendance);
       System.out.println("Attendance updated!");
    }

    public void removeStudent(int id) {

        if (students.remove(id) == null) {
            throw new IllegalArgumentException("Student not found!");
        }

             System.out.println("Student removed!");
    }

    public void displayTopper() {

        if (students.isEmpty()) {
            System.out.println("No students available!");
            return;
        }

        Student topper = null;

        for (Student student : students.values()) {
            if (topper == null || student.getMarks() > topper.getMarks()) {
                topper = student;
            }
        }

          System.out.println("Topper:");
        System.out.println(topper);
    }
    

    public Map<Integer, Student> getStudents() {
        return students;
    }
    
    

    public void loadStudents(Map<Integer, Student> savedStudents) {
        students = savedStudents;
    
    
    }
    
    
    
}