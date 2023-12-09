package LMS.courses;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int courseId;
    private String courseName;
    private List<Session> sessions;
    private List<Task> tasks;
    private List<Lecture> lectures;

    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.sessions = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.lectures = new ArrayList<>();
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void updateSession(Session session) {}

    public void deleteSession(Session session) {
        sessions.remove(session);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void updateTask(Task task) {}

    public void deleteTask(Task task) {
        tasks.remove(task);
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

