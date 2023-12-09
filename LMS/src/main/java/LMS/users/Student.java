package LMS.users;

import java.util.ArrayList;
import java.util.List;

import LMS.GlobalConfig;

public class Student extends User {
    double gpa;

    public Student(int id, String name, String email, String password, List<String> privileges, double gpa) {
        super(id, name, email, password, GlobalConfig.USER_TYPE_STUDENT, new ArrayList<>());
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

@Override
public void displayUserInfo() {
    System.out.println("Student Information:");
    System.out.println("ID: " + getId());
    System.out.println("Name: " + getName());
    System.out.println("User Type: " + getUserType().getTypeName());
    System.out.println("Privileges:" + getPrivileges());
    System.out.println("GPA: " + getGpa());
}
}
