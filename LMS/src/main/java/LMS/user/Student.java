package LMS.user;

import LMS.GlobalConfig;

public class Student extends User {
    double gpa;

    public Student() {
        super();
    }

    public Student(int id, String name, String email, String password, double gpa) {
        super(id, name, email, password, GlobalConfig.USER_TYPE_STUDENT.getTypeName());
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

}
