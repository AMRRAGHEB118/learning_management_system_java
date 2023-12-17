package LMS.exam;

import java.util.HashMap;

public class Questions {
    private int examId;
    private HashMap<String, Boolean> questionMap;

    public Questions() {}

    public Questions(int examId, HashMap<String, Boolean> questionMap) {
        this.examId = examId;
        this.questionMap = questionMap;
    }
    
    public int getExamId() {
        return examId;
    }

    public HashMap<String, Boolean> getQuestionMap() {
        return questionMap;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public void setQuestionMap(HashMap<String, Boolean> questionMap) {
        this.questionMap = questionMap;
    }

    public void appendQuestion(String question, boolean answer) {
        if (questionMap == null) {
            questionMap = new HashMap<>();
        }
        questionMap.put(question, answer);
    }

}

