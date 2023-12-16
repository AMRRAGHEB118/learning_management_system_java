package LMS.course;

public class Lecture {
    private int courseId;
    private int lectureId;
    private String lectureName;
    private String lectureContent;

    public Lecture() {}

    public Lecture(int courseId, int lectureId, String lectureName, String lectureContent) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.lectureContent = lectureContent;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getLectureContent() {
        return lectureContent;
    }

    public void setLectureContent(String lectureContent) {
        this.lectureContent = lectureContent;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "lectureId=" + lectureId +
                ", lectureName='" + lectureName + '\'' +
                ", lectureContent='" + lectureContent + '\'' +
                '}';
    }
}

