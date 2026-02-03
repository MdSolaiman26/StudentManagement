package services;

import models.Student;
import java.util.*;

public class StudentService{
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void removeStudent(int id){
        boolean removed = students.removeIf(student -> student.getId() == id);

        if(removed){
            System.out.println("Student removed successfully!");
        }
        else{
            System.out.println("Student not found!");
        }
    }

    public void updateStudent(int id, String name, int age, String dept){
        for(Student student :students){
            if(student.getId() == id){
                student.setName(name);
                student.setAge(age);
                student.setDepartment(dept);
                System.out.println("Student updated successfully!");
            } 
        }
        System.out.println("Student no found!");
    }

    public void showStudents(){
        if(students.isEmpty()){
            System.out.println("No Students found.");
            return;
        }
        for(Student student : students){
            System.out.println(student);
        }
    }
}