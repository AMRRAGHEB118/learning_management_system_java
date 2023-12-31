package LMS.user;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import LMS.GlobalConfig;
import LMS.course.Assignment;
import LMS.course.Course;
import LMS.course.Lecture;
import LMS.course.Report;
import LMS.exam.Exam;
import LMS.exam.Questions;
import LMS.system.FileManager;

public class Instructor extends User {
    public Instructor() {
        super();
    }

    public Instructor(int id, String name, String email, String password) {
        super(id, name, email, password, GlobalConfig.USER_TYPE_INSTRUCTOR.getId());
    }

    public void editCourse(Scanner scanner) {
        System.out.println("Edit Course");

        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addLecture(Scanner scanner) {
        System.out.println("Add Lecture");

        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editLecture(Scanner scanner) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteLecture(Scanner scanner) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addAssignment(Scanner scanner) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editAssignment(Scanner scanner) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAssignment(Scanner scanner) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateReport(Scanner scanner, int instructorId) {
    System.out.println("Generate Report");

    try {
        FileManager<Course> courseFileManager = new FileManager<>(".//target//data//Course.json", Course.class);
        FileManager<Student> studentFileManager = new FileManager<>(".//target//data//Student.json", Student.class);
        FileManager<Report> reportFileManager = new FileManager<>(".//target//data//Report.json", Report.class);

        List<Course> courses = courseFileManager.readFromFile();
        List<Student> students = studentFileManager.readFromFile();
        List<Report> reports = reportFileManager.readFromFile();

        Report report = new Report();

        System.out.println("Enter Course id: ");
        int courseId = scanner.nextInt();

        Course selectedCourse = Course.getCourseById(courses, courseId, instructorId);

        for (Student student : students) {
            for (Integer studentCourse : student.getCourses()) {
                if (studentCourse == selectedCourse.getCourseId()) {
                    System.out.println("Enter Grade: ");
                    double grade = scanner.nextDouble();
                    report.addGrade(student.getId(), grade);
                }
            }
        }

        reportFileManager.appendToFile(reports, report);
        System.out.println("Report generated successfully.");
    } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter valid data.");
    }
}

    public void addExam(Scanner scanner, int id) {
        System.out.println("Add Exam");

        try {
            FileManager<Exam> examFileManager = new FileManager<>(".//target//data//Exam.json", Exam.class);
            List<Exam> exams = examFileManager.readFromFile();

            System.out.print("Enter course id: ");
            int courseId = scanner.nextInt();

            System.out.print("Enter exam name: ");
            String examName = scanner.next();

            Exam exam = new Exam(courseId, exams.size() + 1, examName, id);

            examFileManager.appendToFile(exams, exam);

            System.out.println("Exam added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
        }
    }

    public void addQuestions(Scanner scanner, int id) {
        System.out.println("Add Question");

        try {
            FileManager<Questions> questionFileManager = new FileManager<Questions>(GlobalConfig.QUESTION_FILE_PATH, Questions.class);
            FileManager<Exam> examFileManager = new FileManager<Exam>(GlobalConfig.EXAM_FILE_PATH, Exam.class);
            List<Questions> questionsList = questionFileManager.readFromFile();
            List<Exam> exams = examFileManager.readFromFile();
            Questions questions = new Questions();

            System.out.print("Enter exam id: ");
            int examId = scanner.nextInt();

            Exam selectedExam = Exam.getExamById(exams, examId);
            
            if (selectedExam == null) {
                System.out.println("Exam does not exist.");
                return;
            }

            if (selectedExam.getAssignedExaminer() != id) {
                System.out.println("You are not authorized to add questions to this exam.");
                return;
            }

            questions.setExamId(examId);

            for (int i = 0; i < 5; i++) {
                questions = addQuestion(scanner, questions);
            }

            questionFileManager.appendToFile(questionsList, questions);

            System.out.println("Questions added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
        }
    }

    private static Questions addQuestion(Scanner scanner, Questions questions) {
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter question: ");
            String question = scanner.next();
    
            System.out.print("Enter answer (true/false): ");
            String input = scanner.next();

            System.out.println("Answer: " + input);
    
            if (input.toLowerCase().equals("true")) {
                System.out.println("Answer: true");
                questions.appendQuestion(question, true);
                validInput = true;
            } else if (input.toLowerCase().equals("false")) {
                questions.appendQuestion(question, false);
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }
        return questions;
    }
    
}
