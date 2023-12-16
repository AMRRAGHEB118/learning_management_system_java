package LMS.system;

import java.util.Scanner;
import LMS.user.UserPrivilege;

public class AdminMenu {

    public static void showDashboard(Scanner scanner) {
        System.out.println("Welcome, " + Auth.currentAdmin.getName() + "!");
        System.out.println("Admin Dashboard: Manage Courses, Users, etc.");
        System.out.println("1. Add User");
        System.out.println("2. Edit User");
        System.out.println("3. Delete User");

        try {
            boolean exit = false;
    
            while (!exit) {
                System.out.print("Enter your choice: ");
    
                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    scanner.nextLine();  // consume the newline character
    
                    switch (choice) {
                        case 1:
                            Auth.currentAdmin.addUser();
                            break;
                        case 2:
                            Auth.currentAdmin.editUser();
                            break;
                        case 3:
                            Auth.currentAdmin.deleteUser();
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();  // consume the invalid input
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }    
}