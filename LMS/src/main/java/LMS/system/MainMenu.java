package LMS.system;

import java.util.InputMismatchException;
import java.util.Scanner;

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

                switch (choice) {
                    case 1:
                        Auth.currentAdmin = Auth.loginAsAdmin(scanner);
                        if (Auth.currentAdmin != null) {
                            AdminMenu.showDashboard(scanner);
                        } else {
                            System.out.println("Login failed. Admin not found.");
                        }
                        break;
                    case 2:
                        InstructorMenu.showDashboard();
                        break;
                    case 3:
                        StudentMenu.showDashboard();
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
