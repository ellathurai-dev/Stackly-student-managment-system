package projects.Student;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService service = new StudentService();
        StudentFileService fileService = new StudentFileService();

        service.loadStudents(fileService.loadStudents());

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search by ID");
            System.out.println("4. Search by Name");
            System.out.println("5. Update Marks");
            System.out.println("6. Update Attendance");
            System.out.println("7. Calculate Grade");
            System.out.println("8. Remove Student");
            System.out.println("9. Display Topper");
            System.out.println("10. Save Students");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Email: ");
                    String email = sc.next();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    System.out.print("Enter Attendance: ");
                    int attendance = sc.nextInt();

                    System.out.println("1.ACTIVE 2.INACTIVE 3.COMPLETED");
                    System.out.print("Enter Status: ");
                    int statusChoice = sc.nextInt();

                    StudentStatus status =
                            StudentStatus.values()[statusChoice - 1];

                    System.out.print("Enter Course Name: ");
                    String courseName = sc.next();

                    System.out.print("Enter Course Duration: ");
                    int duration = sc.nextInt();

                    Course course = new Course(courseName, duration);

                    Student student = new Student(
                            id, name, email, marks, attendance, status, course
                    );

                    service.addStudent(student);
                    break;

                case 2:
                    service.displayAllStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    System.out.println(service.searchById(sc.nextInt()));
                    break;

                case 4:
                    System.out.print("Enter Name: ");
                    service.searchByName(sc.next());
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    int markId = sc.nextInt();

                    System.out.print("Enter New Marks: ");
                    service.updateMarks(markId, sc.nextDouble());
                    break;

                case 6:
                    System.out.print("Enter ID: ");
                    int attendanceId = sc.nextInt();

                    System.out.print("Enter New Attendance: ");
                    service.updateAttendance(attendanceId, sc.nextInt());
                    break;

                case 7:
                    System.out.print("Enter ID: ");
                    Student s = service.searchById(sc.nextInt());

                    System.out.println("Grade: " + s.calculateGrade());
                    break;

                case 8:
                    System.out.print("Enter ID: ");
                    service.removeStudent(sc.nextInt());
                    break;

                case 9:
                    service.displayTopper();
                    break;

                case 10:
                    fileService.saveStudents(service.getStudents());
                    break;

                case 0:
                    fileService.saveStudents(service.getStudents());
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }
        
        while (choice != 0);

        sc.close();
    
    
    }
    
    
}