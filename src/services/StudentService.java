package services;

import models.Student;
import utils.FileUtils;
import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class StudentService {
    private List<Student> students;
    private final String filename = "students.txt";

    public StudentService() {
        students = FileUtils.loadStudents(filename);
    }

    public void addStudent(Student student) {
        students.add(student);
        FileUtils.saveStudents(students, filename);
        System.out.println("Student added successfully!");
    }

    public void removeStudent(String id) {
        boolean removed = students.removeIf(s -> s.getId().equals(id));
        FileUtils.saveStudents(students, filename);
        System.out.println(removed ? "Student removed!" : "Student not found!");
    }

    public void updateStudent(String id, String name, int age, String dept) {
        boolean found = false;
        for (Student s : students) {
            if (s.getId().equals(id)) {
                s.setName(name);
                s.setAge(age);
                s.setDepartment(dept);
                found = true;
                break;
            }
        }
        FileUtils.saveStudents(students, filename);
        System.out.println(found ? "Student updated!" : "Student not found!");
    }

    public void showStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }
}