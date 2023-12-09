package LMS.courses;

public class Lecture {
    private int lectureId;
    private String lectureName;
    private String lectureContent;

    // Constructor
    public Lecture(int lectureId, String lectureName, String lectureContent) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.lectureContent = lectureContent;
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

