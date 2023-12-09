package LMS.exam;

import java.util.List;

public class Question {
    private int questionId;
    private String questionText;
    private List<String> choices;
    private int correctChoiceIndex;

    public Question(int questionId, String questionText, List<String> choices, int correctChoiceIndex) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.choices = choices;
        this.correctChoiceIndex = correctChoiceIndex;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getChoices() {
        return choices;
    }

    public int getCorrectChoiceIndex() {
        return correctChoiceIndex;
    }

    public void setCorrectChoiceIndex(int correctChoiceIndex) {
        this.correctChoiceIndex = correctChoiceIndex;
    }

    public boolean isChoiceCorrect(int selectedChoiceIndex) {
        return selectedChoiceIndex == correctChoiceIndex;
    }

    public void displayQuestion() {
        System.out.println("Question " + questionId + ": " + questionText);
        System.out.println("Choices:");
        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i + 1) + ". " + choices.get(i));
        }
    }
}

