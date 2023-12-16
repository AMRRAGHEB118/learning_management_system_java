package LMS.system;

import java.util.Scanner;

import LMS.user.Admin;

public class AdminMenu {

    public static void showDashboard(Scanner scanner) {
        System.out.println("Welcome, " + Auth.currentAdmin.getName() + "!");
        System.out.println("Admin Dashboard: Manage Courses, Users, etc.");
        System.out.println("1. Add Instructor");
        System.out.println("2. Edit Instructor");
        System.out.println("3. Delete Instructor");
        System.out.println("4. Add Student");
        System.out.println("5. Edit Student");
        System.out.println("6. Delete Student");

        try {
            boolean exit = false;
    
            while (!exit) {
                System.out.print("Enter your choice: ");
    
                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    scanner.nextLine();
    
                    switch (choice) {
                        case 1:
                            Admin.addInstructor(scanner);
                            break;
                        case 2:
                            Admin.editInstructor(scanner);
                            break;
                        case 3:
                            Admin.deleteInstructor(scanner);
                            break;
                        case 4:
                            Admin.addStudent(scanner);
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