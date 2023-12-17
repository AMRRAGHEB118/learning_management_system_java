package LMS.exam;

import java.util.List;

public class Exam {
    private int courseId;
    private int examId;
    private String examName;
    private  int assignedExaminer;

    public Exam() {}

    // Constructor
    public Exam(int courseId, int examId, String examName, int assignedExaminer) {
        this.courseId = courseId;
        this.examId = examId;
        this.examName = examName;
        this.assignedExaminer = assignedExaminer;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getAssignedExaminer() {
        return assignedExaminer;
    }

    public double calculatePassPercentage() {
        return 0.0;
    }

    public double calculateAPlusPercentage() {
        return 0.0;
    }

    public void correctChoices() {}

    public void storeResults() {}

    public static Exam getExamById(List<Exam> exams, int selectedExamId) {
        for (Exam exam : exams) {
            if (exam.getExamId() == selectedExamId) {
                return exam;
            }
        }
        return null;
    }
}