package LMS.exam;

import java.util.HashMap;

public class Question {
    private int examId;
    private HashMap<String, Boolean> questionMap;

    public Question() {}

    public Question(int examId, HashMap<String, Boolean> questionMap) {
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
}

