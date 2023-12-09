package LMS.courses;

import java.util.ArrayList;
import java.util.List;

import LMS.users.Instructor;

public class Course {
    private int courseId;
    private String courseName;
    private Instructor instructor;
    private List<Assignment> assignments;
    private List<Lecture> lectures;
    private Report report;

    public Course(int courseId, String courseName, Instructor instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.assignments = new ArrayList<>();
        this.lectures = new ArrayList<>();
        this.report = new Report();
    }

    // Getters
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public void updateAssignment(Assignment assignment) {}

    public void deleteAssignment(Assignment assignment) {
        assignments.remove(assignment);
    }

    public void addLecture(Lecture lecture) {
        lectures.add(lecture);
    }

    public void updateLecture(Lecture lecture) {}

    public void deleteLecture(Lecture lecture) {
        lectures.remove(lecture);
    }

    public void addStudentGrade(int studentId, double grade) {
        report.addGrade(studentId, grade);
    }

    public Double getStudentGrade(int studentId) {
        return report.getGrade(studentId);
    }

    public double generatePerformanceReport() {
        return 0.0;
    }
}

