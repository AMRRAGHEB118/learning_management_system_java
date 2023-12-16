package LMS.system;

import java.util.Scanner;

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
        System.out.println("7. Add User Privilege");
        System.out.println("8. Edit User Privilege");
        System.out.println("9. Delete User Privilege");
        System.out.println("10. Add Course");
        System.out.println("11. DeleteCourse");
        System.out.println("12. Logout");

        try {
            boolean exit = false;
    
            while (!exit) {
                System.out.print("Enter your choice: ");
    
                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    scanner.nextLine();
    
                    switch (choice) {
                        case 1:
                            Auth.currentAdmin.addInstructor(scanner);
                            break;
                        case 2:
                            Auth.currentAdmin.editInstructor(scanner);
                            break;
                        case 3:
                            Auth.currentAdmin.deleteInstructor(scanner);
                            break;
                        case 4:
                            Auth.currentAdmin.addStudent(scanner);
                            break;
                        case 5:
                            Auth.currentAdmin.editStudent(scanner);
                            break;
                        case 6:
                            Auth.currentAdmin.deleteStudent(scanner);
                            break;
                        case 7:
                            Auth.currentAdmin.addUserPrivilege(scanner);
                            break;
                        case 8:
                            Auth.currentAdmin.editUserPrivilege(scanner);
                            break;
                        case 9:
                            Auth.currentAdmin.deleteUserPrivilege(scanner);
                            break;
                        case 10:
                            Auth.currentAdmin.addCourse(scanner);
                            break;
                        case 11:
                            Auth.currentAdmin.deleteCourse(scanner);
                            break;
                        case 12:
                            Auth.logoutAsAdmin();
                            MainMenu.showDashboard(scanner);
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