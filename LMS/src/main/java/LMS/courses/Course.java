package LMS.courses;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int courseId;
    private String courseName;
    private List<Assignment> Assignments;
    private List<Lecture> lectures;

    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.Assignments = new ArrayList<>();
        this.lectures = new ArrayList<>();
    }

    public void addAssignment(Assignment Assignment) {
        Assignments.add(Assignment);
    }

    public void updateAssignment(Assignment Assignment) {}

    public void deleteAssignment(Assignment Assignment) {
        Assignments.remove(Assignment);
    }

    public void addLecture(Lecture lecture) {
        lectures.add(lecture);
    }

    public void updateLecture(Lecture lecture) {}

    public void deleteLecture(Lecture lecture) {
        lectures.remove(lecture);
    }

    public double generatePerformanceReport() {
        return 0.0;
    }
}

