package LMS.user;

import java.util.List;
import java.util.Scanner;

import LMS.GlobalConfig;
import LMS.system.FileManager;

public class Admin extends User {

    public Admin() {
        super();
    }

    public Admin(int id, String name, String email, String password) {
        super(id, name, email, password, GlobalConfig.USER_TYPE_ADMIN.getTypeName());
    }

    // public List<UserPrivilege> getPrivileges() {
    //     return privileges;
    // }

    // public void addPrivilege(UserPrivilege privilege) {
    //     privileges.add(privilege);
    // }

    // public void removePrivilege(UserPrivilege privilege) {
    //     privileges.remove(privilege);
    // }

    public static void addInstructor(Scanner scanner) {
        System.out.println("Add Instructor");

        FileManager<Instructor> fileManager = new FileManager<Instructor>(".//target//data//Instructor.json", Instructor.class);
        List<Instructor> instructors = fileManager.readFromFile();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Instructor newInstructor = new Instructor(instructors.size() + 1, name, email, password);

        fileManager.appendToFile(instructors, newInstructor);

        System.out.println("Instructor added successfully.");
    }

    public static void addStudent(Scanner scanner) {
        System.out.println("Add Student");

        FileManager<Student> fileManager = new FileManager<Student>(".//target//data//Student.json", Student.class);
        List<Student> students = fileManager.readFromFile();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Student newStudent = new Student(students.size() + 1, name, email, password, 0.0);

        fileManager.appendToFile(students, newStudent);

        System.out.println("Student added successfully.");
    }

    public void viewUsers() {
        System.out.println("View Users");

        FileManager<User> fileManager = new FileManager<User>(".//target//data//User.json", User.class);
        List<User> users = fileManager.readFromFile();

        for (User user : users) {
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
            System.out.println();
        }
    }

    public void addUserType() {
    }

    public void editUserType() {
    }

    public void deleteUserType() {
    }

    public void removePrivilege() {
    }

    public void editPrivilege() {
    }

    public static void deleteInstructor(Scanner scanner) {
        
    }

    public static void editInstructor(Scanner scanner) {
    }
}

