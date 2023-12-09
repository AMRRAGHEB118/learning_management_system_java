package LMS.exam;

import LMS.user.Instructor;

import java.util.List;

public class Exam {
    private int examId;
    private String examName;
    private List<Question> questions;
    private  Instructor assignedExaminer;

    // Constructor
    public Exam(int examId, String examName, List<Question> questions) {
        this.examId = examId;
        this.examName = examName;
        this.questions = questions;
    }

    public int getExamId() {
        return examId;
    }

    public String getExamName() {
        return examName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Instructor getAssignedExaminer() {
        return assignedExaminer;
    }

    public void setAssignedExaminer(Instructor assignedExaminer) {
        this.assignedExaminer = assignedExaminer;
    }

    public double calculatePassPercentage() {
        return 0.0;
    }

    public double calculateAPlusPercentage() {
        return 0.0;
    }

    public void correctChoices() {}

    public void storeResults() {}

    public void displayExamDetails() {
        System.out.println("Exam ID: " + examId);
        System.out.println("Exam Name: " + examName);
        System.out.println("Assigned Examiner: " + (assignedExaminer != null ? assignedExaminer.getName() : "Not assigned"));
    }

    // Other methods...
}

