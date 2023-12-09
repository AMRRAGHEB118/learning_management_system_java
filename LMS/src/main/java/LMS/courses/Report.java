package LMS.courses;

import java.util.HashMap;
import java.util.Map;

public class Report {
    private Map<Integer, Double> studentGrades;

    // Constructor
    public Report() {
        this.studentGrades = new HashMap<>();
    }

    public void addGrade(int studentId, double grade) {
        studentGrades.put(studentId, grade);
    }

    public Double getGrade(int studentId) {
        return studentGrades.get(studentId);
    }

    @Override
    public String toString() {
        return "Report{" +
                "studentGrades=" + studentGrades +
                '}';
    }
}
