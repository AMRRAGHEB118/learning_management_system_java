package LMS.exam;

import java.util.HashMap;

public class Answers {
    private int examId;
    private int studentId;
    private HashMap<String, Boolean> answerMap;

    public Answers() {}

    public Answers(int examId, int studentId, HashMap<String, Boolean> answerMap) {
        this.examId = examId;
        this.studentId = studentId;
        this.answerMap = answerMap;
    }

    public int getExamId() {
        return examId;
    }

    public int getStudentId() {
        return studentId;
    }

    public HashMap<String, Boolean> getAnswerMap() {
        return answerMap;
    }

    public void setAnswerMap(HashMap<String, Boolean> answerMap) {
        this.answerMap = answerMap;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void appendAnswer(String question, boolean answer) {
        if (answerMap == null) {
            answerMap = new HashMap<>();
        }
        answerMap.put(question, answer);
    }
}
