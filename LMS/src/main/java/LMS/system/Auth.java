package LMS.system;

import java.util.List;
import java.util.Scanner;

import LMS.user.Admin;
import LMS.user.Instructor;
import LMS.user.Student;

public abstract class Auth {
    static Admin currentAdmin;
    private static Instructor currentInstructor;
    private static Student currentStudent;

    public static Admin loginAsAdmin(Scanner scanner) {
        try {
            System.out.println("Login");
            System.out.print("Enter email: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            Admin admin = validateAdmin(username, password);
            if (admin != null) {
                currentAdmin = admin;
                return admin;
            } else {
                System.out.println("Invalid username or password. Login failed.");
                return admin;
            }
        }catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return null;
    }

    public void loginAsInstructor() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Login");
            System.out.print("Enter email: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            Instructor instructor = validateInstructor(username, password);
            if (instructor != null) {
                currentInstructor = instructor;
                return;
            } else {
                System.out.println("Invalid username or password. Login failed.");
                return;
            }
        }
    }

    public void loginAsStudent() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Login");
            System.out.print("Enter email: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            Student student = validateStudent(username, password);
            if (student != null) {
                currentStudent = student;
                return;
            } else {
                System.out.println("Invalid username or password. Login failed.");
                return;
            }
        }
    }

    private static Admin validateAdmin(String email, String password) {
        FileManager<Admin> fileManager = new FileManager<Admin>(".//target//data//Admin.json", Admin.class);
        List<Admin> admins = fileManager.readFromFile();

        for (Admin admin : admins) {
            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                return admin;
            } else {
                return null;
            }
        }
        return null;
        }

    private Instructor validateInstructor(String email, String password) {
        FileManager<Instructor> fileManager = new FileManager<Instructor>(".//target//data//Instructor.json", Instructor.class);
        List<Instructor> admins = fileManager.readFromFile();

        for (Instructor admin : admins) {
            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                return admin;
            } else {
                return null;
            }
        }

        return null;
    }

    private Student validateStudent(String email, String password) {
        FileManager<Student> fileManager = new FileManager<Student>(".//target//data//Student.json", Student.class);
        List<Student> admins = fileManager.readFromFile();

        for (Student admin : admins) {
            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                return admin;
            } else {
                return null;
            }
        }

        return null;
    }

    public static void logoutAsAdmin() {
        currentAdmin = null;
        System.out.println("Logout successful. Goodbye!");
    }

    public void logoutAsInstructor() {
        currentInstructor = null;
        System.out.println("Logout successful. Goodbye!");
    }

    public void logoutAsStudent() {
        currentStudent = null;
        System.out.println("Logout successful. Goodbye!");
    }
}

