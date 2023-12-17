package LMS.user;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import LMS.GlobalConfig;
import LMS.course.Course;
import LMS.course.Lecture;
import LMS.exam.Answers;
import LMS.exam.Exam;
import LMS.exam.Questions;
import LMS.system.FileManager;

public class Student extends User {
    double gpa;
    List<Integer> courses;

    public Student() {
        super();
    }

    public Student(int id, String name, String email, String password, double gpa, List<Integer> courses) {
        super(id, name, email, password, GlobalConfig.USER_TYPE_STUDENT.getId());
        this.gpa = gpa;
        this.courses = courses;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public List<Integer> getCourses() {
        return courses;
    }

    public void subscribeToCourse(Scanner scanner, int id) {
        System.out.println("Subscribing to a new course ");
    
        try {
            FileManager<Course> coursesFileManager = new FileManager<>(".//target//data//Course.json", Course.class);
            List<Course> courses = coursesFileManager.readFromFile();
    
            System.out.print("Enter course id: ");
            int courseId = scanner.nextInt();
    
            for (Course course : courses) {
                if (course.getCourseId() == courseId) {
                    List<Integer> students = course.getStudents();
                    if (students.contains(id)) {
                        System.out.println("You are already subscribed to this course.");
                    } else {
                        students.add(id);
                        course.setStudents(students);
                        coursesFileManager.updateFile(courses, course);
                        System.out.println("Subscription to the course successful.");
                    }
                    return;
                }
            }
    
            System.out.println("Course not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void unsubscribeFromCourse(Scanner scanner, int id) {
        System.out.println("Unsubscribing from a course ");
    
        try {
            FileManager<Course> coursesFileManager = new FileManager<>(GlobalConfig.COURSE_FILE_PATH, Course.class);
            List<Course> courses = coursesFileManager.readFromFile();
    
            System.out.print("Enter course id: ");
            int courseId = scanner.nextInt();
    
            for (Course course : courses) {
                if (course.getCourseId() == courseId) {
                    List<Integer> students = course.getStudents();
                    if (students.contains(id)) {
                        students.remove(Integer.valueOf(id));
                        course.setStudents(students);
                        coursesFileManager.updateFile(courses, course);
                        System.out.println("Unsubscription from the course successful.");
                    } else {
                        System.out.println("You are not subscribed to this course.");
                    }
                    return;
                }
            }
    
            System.out.println("Course not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewCourseDetails(Scanner scanner, int studentId) {
        System.out.println("Viewing Course Details");
    
        try {
            FileManager<Course> coursesFileManager = new FileManager<>(GlobalConfig.COURSE_FILE_PATH, Course.class);
            List<Course> courses = coursesFileManager.readFromFile();
            List<Course> enrolledCourses = getEnrolledCourses(studentId, courses);
    
            for (Course course : enrolledCourses) {
                System.out.println(course.getCourseName());
                System.out.println(course.getCourseDescription());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewLectureDetails(Scanner scanner, int studentId) {
        System.out.println("Viewing Lecture Details");
    
        try {
            FileManager<Lecture> lectureFileManager = new FileManager<>(GlobalConfig.LECTURE_FILE_PATH, Lecture.class);
            FileManager<Course> courseFileManager = new FileManager<>(GlobalConfig.COURSE_FILE_PATH, Course.class);
    
            List<Lecture> allLectures = lectureFileManager.readFromFile();
            List<Course> enrolledCourses = getEnrolledCourses(studentId, courseFileManager.readFromFile());
    
            for (Course course : enrolledCourses) {
                System.out.println("Course: " + course.getCourseName());

                List<Lecture> courseLectures = getLecturesForCourse(allLectures, course.getCourseId());

                for (Lecture lecture : courseLectures) {
                    System.out.println("Lecture Title: " + lecture.getLectureName());
                    System.out.println("Lecture Content: " + lecture.getLectureContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private List<Lecture> getLecturesForCourse(List<Lecture> allLectures, int courseId) {
        List<Lecture> courseLectures = new ArrayList<>();
    
        try {
            for (Lecture lecture : allLectures) {
                if (lecture.getCourseId() == courseId) {
                    courseLectures.add(lecture);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return courseLectures;
    }
    
    private List<Course> getEnrolledCourses(int studentId, List<Course> courses) {
        List<Course> enrolledCourses = new ArrayList<>();
    
        try {
            for (Course course : courses) {
                List<Integer> students = course.getStudents();
                if (students.contains(studentId)) {
                    enrolledCourses.add(course);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return enrolledCourses;
    }

    public void answerCourseExams(Scanner scanner, int id) {
        System.out.println("Answering Course Exams");

        try {
            FileManager<Exam> examFileManager = new FileManager<Exam>(GlobalConfig.EXAM_FILE_PATH, Exam.class);
            FileManager<Questions> questionsFileManager = new FileManager<Questions>(GlobalConfig.QUESTIONS_FILE_PATH, Questions.class);
            FileManager<Answers> answersFileManager = new FileManager<Answers>(GlobalConfig.ANSWERS_FILE_PATH, Answers.class);
            List<Exam> exams = examFileManager.readFromFile();
            List<Questions> questions = questionsFileManager.readFromFile();
            List<Answers> answers = answersFileManager.readFromFile();

            System.out.print("Enter exam id: ");
            int examId = scanner.nextInt();


            Exam selectedExam = getExamById(exams, examId);

            Questions selectedQuestion = getQuestionById(questions, selectedExam.getExamId());
            Answers answer = new Answers();

            if (selectedQuestion == null) {
                System.out.println("Question not found.");
            }

            answer.setExamId(selectedExam.getExamId());
            answer.setStudentId(id);

            for (String key : selectedQuestion.getQuestionMap().keySet()) {
                System.out.println("Question: " + key);
                System.out.println("Answer: ");
                String answerText = scanner.next();
            
                if (answerText.equals("true") || answerText.equals("false")) {
                    answer.appendAnswer(key, Boolean.parseBoolean(answerText));
                }
            }
            

            answersFileManager.appendToFile(answers, answer);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    private Questions getQuestionById(List<Questions> questions, int examId) {
        for (Questions question : questions) {
            if (question.getExamId() == examId) {
                return question;
            }
        };
        return null;
    }

    private Exam getExamById(List<Exam> exams, int id) {
        for (Exam exam : exams) {
            if (exam.getExamId() == id) {
                return exam;
            }
        };
        return null;
    }
}
