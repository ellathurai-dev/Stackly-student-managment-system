package projects.Student;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StudentFileService {

    private String fileName = "students.txt";

    public void saveStudents(Map<Integer, Student> students) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            for (Student s : students.values()) {

                String data = s.getId() + "," +
                        s.getName() + "," +
                        s.getEmail() + "," +
                        s.getMarks() + "," +
                        s.getAttendance() + "," +
                        s.getStatus() + "," +
                        s.getCourse().getCourseName() + "," +
                        s.getCourse().getDuration();

                writer.write(data);
                writer.newLine();
            }

            writer.close();
            System.out.println("Students saved successfully!");

        } catch (IOException e) {
            System.out.println("File save error!");
        }
    }

    public Map<Integer, Student> loadStudents() {

    	
             Map<Integer, Student> students = new HashMap<>();

        try {
              BufferedReader reader = new BufferedReader(new FileReader(fileName));

                  String line;

            while ((line = reader.readLine()) != null) {
            	
            	

                String[] data = line.split(",");

                
                
               int id = Integer.parseInt(data[0]);
                String name = data[1];
                 String email = data[2];
              double marks = Double.parseDouble(data[3]);
             int attendance = Integer.parseInt(data[4]);
               StudentStatus status = StudentStatus.valueOf(data[5]);

                String courseName = data[6];
                   int duration = Integer.parseInt(data[7]);
                 Course course = new Course(courseName, duration);
 
                  Student student = new Student(
                        id, name, email, marks, attendance, status, course
                );

                students.put(id, student);
            }
  
              reader.close();

        } catch (FileNotFoundException e) {
                 System.out.println("No previous student file found.");
       } catch (IOException e) {
            System.out.println("File loading error!");
              }

        return students;
    
    }
    
    
    
}