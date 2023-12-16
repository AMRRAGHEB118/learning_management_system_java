package LMS.user;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

import LMS.GlobalConfig;
import LMS.course.Assignment;
import LMS.course.Course;
import LMS.course.Lecture;
import LMS.system.FileManager;

public class Instructor extends User {
    public Instructor() {
        super();
    }

    public Instructor(int id, String name, String email, String password) {
        super(id, name, email, password, GlobalConfig.USER_TYPE_INSTRUCTOR.getTypeName());
    }

    public void generateReport() {
    }

    public void editCourse(Scanner scanner) {
        System.out.println("Edit Course");
        boolean isExists = false;
        
        FileManager<Course> fileManager = new FileManager<Course>(".//target//data//Course.json", Course.class);
        List<Course> courses = fileManager.readFromFile();

        System.out.print("Enter course id: ");
        int id = scanner.nextInt();

        for (Course course : courses) {
            if (course.getId() == id) {
                System.out.print("Enter course name: ");
                String name = scanner.next();
                
                System.out.print("Enter course description: ");
                String description = scanner.next();

                course.setName(name);
                course.setDescription(description);

                fileManager.updateFile(courses, course);
                isExists = true;
                break;
            }
        }

        if (!isExists) {
            System.out.println("Course does not exist.");
        } else {
            System.out.println("Course updated successfully.");
        }
    }

    public void addLecture(Scanner scanner) {
        System.out.println("Add Lecture");

        FileManager<Lecture> fileManager = new FileManager<Lecture>(".//target//data//Lecture.json", Lecture.class);
        List<Lecture> lectures = fileManager.readFromFile();

        System.out.print("Enter course id: ");
        int courseId = scanner.nextInt();
        
        System.out.print("Enter lecture name: ");
        String lectureName = scanner.next();

        System.out.print("Enter lecture Content: ");
        String lectureContent = scanner.next();

        Lecture lecture = new Lecture(courseId, lectures.size() + 1, lectureName, lectureContent);
        fileManager.appendToFile(lectures, lecture);
    }

    public void editLecture(Scanner scanner) {
        System.out.println("Edit Lecture");
        boolean isExists = false;

        FileManager<Lecture> fileManager = new FileManager<Lecture>(".//target//data//Lecture.json", Lecture.class);
        List<Lecture> lectures = fileManager.readFromFile();

        System.out.print("Enter lecture id: ");
        int lectureId = scanner.nextInt();

        for (Lecture lecture : lectures) {
            if (lecture.getLectureId() == lectureId) {

                System.out.print("Enter lecture Content: ");
                String lectureContent = scanner.next();

                lecture.setLectureContent(lectureContent);

                fileManager.updateFile(lectures, lecture);
                isExists = true;
                break;
            }
        }

        if (!isExists) {
            System.out.println("Lecture does not exist.");
        } else {
            System.out.println("Lecture updated successfully.");
        }
    }

    public void deleteLecture(Scanner scanner) {
        System.out.println("Delete Lecture");
        boolean isExists = false;

        FileManager<Lecture> fileManager = new FileManager<Lecture>(".//target//data//Lecture.json", Lecture.class);
        List<Lecture> lectures = fileManager.readFromFile();

        System.out.print("Enter lecture id: ");
        int lectureId = scanner.nextInt();

        for (Lecture lecture : lectures) {
            if (lecture.getLectureId() == lectureId) {

                fileManager.deleteFromFile(lectures, lecture);
                isExists = true;
                break;
            }
        }

        if (!isExists) {
            System.out.println("Lecture does not exist.");
        } else {
            System.out.println("Lecture deleted successfully.");
        }
    }

    public void addAssignment(Scanner scanner) {
        System.out.println("Add Assignment");

        FileManager<Assignment> fileManager = new FileManager<Assignment>(".//target//data//Assignment.json", Assignment.class);
        List<Assignment> assignments = fileManager.readFromFile();

        System.out.print("Enter Lecture id: ");
        int lectureId = scanner.nextInt();
        
        System.out.print("Enter assignment name: ");
        String assignmentName = scanner.next();

        System.out.print("Enter assignment Content: ");
        String assignmentContent = scanner.next();

        System.out.print("Enter due date: ");
        String dueDate = scanner.next();

        System.out.print("Enter task type: ");
        String taskType = scanner.next();


        Assignment lecture = new Assignment(lectureId, assignments.size() + 1, assignmentName, assignmentContent, dueDate, taskType);
        fileManager.appendToFile(assignments, lecture);
    }

    public void editAssignment(Scanner scanner) {
        System.out.println("Edit Assignment");
        boolean isExists = false;

        FileManager<Assignment> fileManager = new FileManager<Assignment>(".//target//data//Assignment.json", Assignment.class);
        List<Assignment> assignments = fileManager.readFromFile();

        System.out.print("Enter assignment id: ");
        int assignmentId = scanner.nextInt();

        for (Assignment assignment  : assignments) {
            if (assignment.getAssignmentId() == assignmentId){

                System.out.print("Enter assignment Content: ");
                String assignmentContent = scanner.next();

                assignment.setAssignmentContent(assignmentContent);

                System.out.print("Enter due date: ");
                String dueDate = scanner.next();

                assignment.setDueDate(dueDate);

                System.out.print("Enter task type: ");
                String taskType = scanner.next();

                assignment.setTaskType(taskType);

                fileManager.updateFile(assignments, assignment);
                isExists = true;
                break;
            }
        }

        if (!isExists) {
            System.out.println("Lecture does not exist.");
        } else {
            System.out.println("Lecture updated successfully.");
        }
    }

    public void deleteAssignment(Scanner scanner) {
        System.out.println("Delete Assignment");
        boolean isExists = false;

        FileManager<Assignment> fileManager = new FileManager<Assignment>(".//target//data//Assignment.json", Assignment.class);
        List<Assignment> assignments = fileManager.readFromFile();

        System.out.print("Enter assignment id: ");
        int assignmentId = scanner.nextInt();

        for (Assignment assignment  : assignments) {
            if (assignment.getAssignmentId() == assignmentId){
                fileManager.deleteFromFile(assignments, assignment);
                isExists = true;
                break;
            }
        }

        if (!isExists) {
            System.out.println("Lecture does not exist.");
        } else {
            System.out.println("Lecture deleted successfully.");
        }
    }
}
