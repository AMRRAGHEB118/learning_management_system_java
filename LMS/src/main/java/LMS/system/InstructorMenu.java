package LMS.system;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InstructorMenu implements Menu {
    
    public static void showDashboard(Scanner scanner) {
        System.out.println("Welcome, " + Auth.currentInstructor.getName() + "!");
        System.out.println("Instructor Dashboard: Manage Courses, Users, etc.");

        System.out.println("1. Edit Course");
        System.out.println("2. Add Lecture");
        System.out.println("3. Edit Lecture");
        System.out.println("4. Delete Lecture");
        System.out.println("5. Add Assignment");
        System.out.println("6. Edit Assignment");
        System.out.println("7. Delete Assignment");
        System.out.println("8. Generate Report");
        System.out.println("9. Logout");

        try {
            boolean exit = false;
    
            while (!exit) {
                System.out.print("Enter your choice: ");
    
                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            Auth.currentInstructor.editCourse(scanner);
                            break;
                        case 2:
                            Auth.currentInstructor.deleteLecture(scanner);
                            break;
                        case 3:
                            Auth.currentInstructor.deleteLecture(scanner);
                            break;
                        case 4:
                            Auth.currentInstructor.deleteLecture(scanner);
                            break;
                        case 5:
                            Auth.currentInstructor.deleteAssignment(scanner);
                            break;
                        case 6:
                            Auth.currentInstructor.deleteAssignment(scanner);
                            break;
                        case 7:
                            Auth.currentInstructor.deleteAssignment(scanner);
                            break;
                        case 8:
                            Auth.currentInstructor.generateReport();
                            break;
                        case 9:
                            Auth.logoutAsInstructor();
                            MainMenu.showDashboard(scanner);
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
}
