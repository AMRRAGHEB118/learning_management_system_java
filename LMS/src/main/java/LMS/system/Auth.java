package LMS.system;

import java.util.List;
import java.util.Scanner;

import LMS.user.Admin;
import LMS.user.Instructor;
import LMS.user.Student;
import LMS.user.User;

public class Auth {
    static Admin currentAdmin;
    static Instructor currentInstructor;
    private static Student currentStudent;

    public static User loginAsAdmin(Scanner scanner) {
        try {
            System.out.println("Login");
            System.out.print("Enter email: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            return validateAdmin(username, password);
        }catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return null;
    }

    public static User loginAsInstructor(Scanner scanner) {
        try {
            System.out.println("Login");
            System.out.print("Enter email: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            return validateInstructor(username, password);
        }catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return null;
    }

    public static User loginAsStudent(Scanner scanner) {
        try {
            System.out.println("Login");
            System.out.print("Enter email: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            return validateStudent(username, password);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return null;
    }

    private static User validateUser(List<? extends User> users, String email, String password) {
    for (User user : users) {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            return user;
        }
    }
    return null;
    }



    private static User validateAdmin(String email, String password) {
        FileManager<Admin> fileManager = new FileManager<Admin>(".//target//data//Admin.json", Admin.class);
        List<Admin> admins = fileManager.readFromFile();
        return validateUser(admins, email, password);
        }

    private static User validateInstructor(String email, String password) {
        FileManager<Instructor> fileManager = new FileManager<Instructor>(".//target//data//Instructor.json", Instructor.class);
        List<Instructor> instructors = fileManager.readFromFile();
        return validateUser(instructors, email, password);
    }

    private static User validateStudent(String email, String password) {
        FileManager<Student> fileManager = new FileManager<>(".//target//data//Student.json", Student.class);
        List<Student> students = fileManager.readFromFile();
        return validateUser(students, email, password);
    }

    public static void logoutAsAdmin() {
        currentAdmin = null;
        System.out.println("Logout successful. Goodbye!");
    }

    public static void logoutAsInstructor() {
        currentInstructor = null;
        System.out.println("Logout successful. Goodbye!");
    }

    public static void logoutAsStudent() {
        currentStudent = null;
        System.out.println("Logout successful. Goodbye!");
    }
}

