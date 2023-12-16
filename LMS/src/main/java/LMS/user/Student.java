package LMS.user;

import java.util.List;

import LMS.GlobalConfig;

public class Student extends User {
    double gpa;
    List<Integer> courses;

    public Student() {
        super();
    }

    public Student(int id, String name, String email, String password, double gpa, List<Integer> courses) {
        super(id, name, email, password, GlobalConfig.USER_TYPE_STUDENT.getTypeName());
        this.gpa = gpa;
        this.courses = courses;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public List<Integer> getCourses() {
        return courses;
    }

}
