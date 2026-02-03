package utils;

import models.Student;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    // Save students to file
    public static void saveStudents(List<Student> students, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Student s : students) {
                bw.write(s.getId() + "," + s.getName() + "," + s.getAge() + "," + s.getDepartment());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    // Load students from file
    public static List<Student> loadStudents(String filename) {
        List<Student> students = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) return students; // No file yet
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String dept = parts[3];
                    students.add(new Student(id, name, age, dept));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
        return students;
    }
}