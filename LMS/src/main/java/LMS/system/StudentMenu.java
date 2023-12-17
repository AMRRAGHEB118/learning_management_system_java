package LMS.system;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentMenu implements Menu{
    
    public static void showDashboard(Scanner scanner) {
        System.out.println("Welcome, " + Auth.currentStudent.getName() + "!");
        System.out.println("Student Dashboard: ");

        System.out.println("1. Subscribe to Course");
        System.out.println("2. Unsubscribe from Course");
        System.out.println("3. View Course Details");
        System.out.println("4. View Lecture Details");
        System.out.println("5. View Course Assignments");
        System.out.println("6. View Course Exams");
        System.out.println("7. Logout");

        try {
            boolean exit = false;
    
            while (!exit) {
                System.out.print("Enter your choice: ");
    
                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            Auth.currentStudent.subscribeToCourse(scanner, Auth.currentStudent.getId());
                            break;
                        case 2:
                            Auth.currentStudent.unsubscribeFromCourse(scanner, Auth.currentStudent.getId());
                            break;
                        case 3:
                            Auth.currentStudent.viewCourseDetails(scanner, Auth.currentStudent.getId());
                            break;
                        case 4:
                            Auth.currentStudent.viewLectureDetails(scanner, Auth.currentStudent.getId());
                            break;
                        case 5:
                            Auth.currentStudent.answerCourseExams(scanner, Auth.currentStudent.getId());
                            break;
                        case 6:
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
}
