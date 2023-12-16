package LMS.course;

import java.util.Date;

public class Assignment {
    private int lectureId;
    private int assignmentId;
    private String assignmentName;
    private String assignmentDescription;
    private Date dueDate;
    private String taskType;

    public Assignment() {}

    public Assignment(int lectureId, int assignmentId, String assignmentName, String assignmentDescription, Date dueDate, String taskType) {
        this.lectureId = lectureId;
        this.assignmentId = assignmentId;
        this.assignmentName = assignmentName;
        this.assignmentDescription = assignmentDescription;
        this.dueDate = dueDate;
        this.taskType = taskType;
    }

    public int getLectureId() {
        return lectureId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getAssignmentDescription() {
        return assignmentDescription;
    }

    public void setAssignmentDescription(String assignmentDescription) {
        this.assignmentDescription = assignmentDescription;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId=" + assignmentId +
                ", assignmentName='" + assignmentName + '\'' +
                ", assignmentDescription='" + assignmentDescription + '\'' +
                ", dueDate=" + dueDate +
                ", taskType='" + taskType + '\'' +
                '}';
    }
}

