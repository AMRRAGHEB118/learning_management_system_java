package LMS.users;

import java.util.List;

import LMS.GlobalConfig;

public class Student extends User {
    double gpa;

    public Student(int id, String name, String email, String password, double gpa) {
        super(id, name, email, password, GlobalConfig.USER_TYPE_STUDENT);
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

    List<UserPrivilege> studentPrivileges = getPrivileges();
    if (!studentPrivileges.isEmpty()) {
        System.out.println("Privileges:");
        for (UserPrivilege privilege : studentPrivileges) {
            System.out.println("- " + privilege.getPrivilegeName());
        }
    } else {
        System.out.println("No privileges assigned.");
    }

    // Additional details specific to students
    // System.out.println("Courses Enrolled: Math, Science, English");
    System.out.println("GPA: " + getGpa());
}
}
