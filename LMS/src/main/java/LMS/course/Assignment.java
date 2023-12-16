package LMS.course;


public class Assignment {
    private int lectureId;
    private int assignmentId;
    private String assignmentName;
    private String assignmentContent;
    private String dueDate;
    private String taskType;

    public Assignment() {}

    public Assignment(int lectureId, int assignmentId, String assignmentName, String assignmentContent, String dueDate, String taskType) {
        this.lectureId = lectureId;
        this.assignmentId = assignmentId;
        this.assignmentName = assignmentName;
        this.assignmentContent = assignmentContent;
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

    public String getAssignmentContent() {
        return assignmentContent;
    }

    public void setAssignmentContent(String assignmentContent) {
        this.assignmentContent = assignmentContent;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
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
                ", assignmentContent='" + assignmentContent + '\'' +
                ", dueDate=" + dueDate +
                ", taskType='" + taskType + '\'' +
                '}';
    }
}

