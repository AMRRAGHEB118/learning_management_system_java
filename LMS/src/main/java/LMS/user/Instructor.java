package LMS.user;

import java.util.Scanner;

import LMS.GlobalConfig;

public class Instructor extends User {
    public Instructor() {
        super();
    }

    public Instructor(int id, String name, String email, String password) {
        super(id, name, email, password, GlobalConfig.USER_TYPE_INSTRUCTOR.getTypeName());
    }

    public void generateReport() {
    }

    public void deleteAssignment(Scanner scanner) {
    }

    public void deleteLecture(Scanner scanner) {
    }

    public void editCourse(Scanner scanner) {
    }
}
