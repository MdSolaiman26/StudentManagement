import models.Student;
import services.StudentService;
import java.util.*;

public class Main {
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);

      StudentService service = new StudentService();
      int choice;

      do{
        System.out.println("\n=== Student Management System===");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Update Student");
        System.out.println("4. Show All Students");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");

        choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Department: ");
                String dept = sc.nextLine();

                service.addStudent(new Student(id, name, age, dept));
                break;
            case 2:
                System.out.print("Enter ID to update: ");
                int removeId = sc.nextInt();
                service.removeStudent(removeId);
                break;

            case 3:
                System.out.print("Enter ID to update: ");
                int updateId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter new Name: ");
                String newName = sc.nextLine();

                System.out.print("Enter new age: ");
                int newAge = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter new Department: ");
                String newDept = sc.nextLine();

                service.updateStudent(updateId, newName, newAge, newDept);
                break;
            
            case 4:
                service .showStudents();
                break;
            case 0:
                System.out.println("Exiting... Goodby ");
            default:
                System.out.println("Invalid Choice! Try again.");
                break;
        }
      }while(choice != 0);
      sc.close();
   }
}