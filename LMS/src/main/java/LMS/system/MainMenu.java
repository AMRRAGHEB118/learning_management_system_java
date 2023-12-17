package LMS.system;

import java.util.InputMismatchException;
import java.util.Scanner;

import LMS.user.Admin;
import LMS.user.Instructor;
import LMS.user.Student;
import LMS.user.User;

public class MainMenu implements Menu {

    public static void showDashboard(Scanner scanner) {
        System.out.println("Welcome!");
        System.out.println("1. Login as Admin");
        System.out.println("2. Login as Instructor");
        System.out.println("3. Login as Student");
        System.out.println("4. Exit");

        try {
            boolean exit = false;

            while (!exit) {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                User currentUser = null;

                switch (choice) {
                    case 1:
                        currentUser = Auth.loginAsAdmin(scanner);
                        if (currentUser instanceof Admin) {
                            Auth.currentAdmin = (Admin) currentUser;
                            AdminMenu.showDashboard(scanner);
                        } else {
                            System.out.println("Login failed. Admin not found.");
                        }
                        break;
                    case 2:
                        currentUser = Auth.loginAsInstructor(scanner);
                        if (currentUser instanceof Instructor) {
                            Auth.currentInstructor = (Instructor) currentUser;
                            InstructorMenu.showDashboard(scanner);
                        } else {
                            System.out.println("Login failed. Instructor not found.");
                        }
                        break;
                    case 3:
                        currentUser = Auth.loginAsStudent(scanner);
                        if (currentUser instanceof Student) {
                            Auth.currentStudent = (Student) currentUser;
                            StudentMenu.showDashboard(scanner);
                        } else {
                            System.out.println("Login failed. Student not found.");
                        }
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Exiting the program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
