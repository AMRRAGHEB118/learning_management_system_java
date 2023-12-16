package LMS.course;


import java.util.List;

public class Course {
    private int courseId;
    private String courseName;
    private String courseDescription;
    private int instructorId;

    public Course() {}

    public Course(int courseId, String courseName, int instructorId, String courseDescription) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructorId = instructorId;
        this.courseDescription = courseDescription;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void updateAssignment(Assignment assignment) {}


    public void updateLecture(Lecture lecture) {}

    public double generatePerformanceReport() {
        return 0.0;
    }

    public int getId() {
        return courseId;
    }

    public void setName(String courseName) {
        this.courseName = courseName;
    }

    public void setDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public static Course getCourseById(List<Course> courses, int courseId, int instructorId) {
        for (Course course : courses) {
            if (course.getCourseId() == courseId && course.getInstructorId() == instructorId) {
                return course;
            }
        }
        return null;
    }
}

