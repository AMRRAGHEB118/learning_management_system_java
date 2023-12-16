package LMS.course;

import java.util.ArrayList;
import java.util.List;


public class Course {
    private int courseId;
    private String courseName;
    private int instructorId;
    private List<Integer> lectures;
    private Report report;

    public Course() {}

    public Course(int courseId, String courseName, int instructorId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructorId = instructorId;
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

    public int getInstructorId() {
        return instructorId;
    }

    public void updateAssignment(Assignment assignment) {}


    public void updateLecture(Lecture lecture) {}


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

