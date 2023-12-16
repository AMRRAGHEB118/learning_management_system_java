package LMS.user;

import java.util.List;

public class Student extends User {
    double gpa;

    public Student(int id, String name, String email, String password, List<String> privileges, double gpa) {
        super();
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

}
