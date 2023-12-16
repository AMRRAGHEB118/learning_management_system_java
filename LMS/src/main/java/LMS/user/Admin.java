package LMS.user;

import java.util.List;
import java.util.Scanner;

import LMS.GlobalConfig;
import LMS.system.FileManager;

public class Admin extends User {

    public Admin() {
        super();
    }

    public Admin(int id, String name, String email, String password) {
        super(id, name, email, password, GlobalConfig.USER_TYPE_ADMIN.getTypeName());
    }

    public static void addInstructor(Scanner scanner) {
        System.out.println("Add Instructor");

        FileManager<Instructor> fileManager = new FileManager<Instructor>(".//target//data//Instructor.json", Instructor.class);
        List<Instructor> instructors = fileManager.readFromFile();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Instructor newInstructor = new Instructor(instructors.size() + 1, name, email, password);

        fileManager.appendToFile(instructors, newInstructor);

        System.out.println("Instructor added successfully.");
    }

    public static void addStudent(Scanner scanner) {
        System.out.println("Add Student");

        FileManager<Student> fileManager = new FileManager<Student>(".//target//data//Student.json", Student.class);
        List<Student> students = fileManager.readFromFile();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Student newStudent = new Student(students.size() + 1, name, email, password, 0.0);

        fileManager.appendToFile(students, newStudent);

        System.out.println("Student added successfully.");
    }

    public static void deleteInstructor(Scanner scanner) {
        System.out.println("Delete Instructor");
        boolean isExist = false;

        FileManager<Instructor> fileManager = new FileManager<Instructor>(".//target//data//Instructor.json", Instructor.class);
        List<Instructor> instructors = fileManager.readFromFile();

        System.out.print("Enter id: ");
        int id = scanner.nextInt();

        for (Instructor instructor : instructors) {
            if (instructor.getId() == id) {
                fileManager.deleteFromFile(instructors, instructor);
                System.out.println("Instructor deleted successfully.");
                isExist = true;
                break;
            }
        }

        if (!isExist) {
            System.out.println("Instructor does not exist.");
        }
    }

    public static void editInstructor(Scanner scanner) {
        System.out.println("Edit Instructor");
        boolean isExist = false;
        int existPrivilegeId = 0;
        String existPrivilegeName = "";

        FileManager<Instructor> fileManager = new FileManager<Instructor>(".//target//data//Instructor.json", Instructor.class);
        FileManager<UserPrivilege> fileManager2 = new FileManager<UserPrivilege>(".//target//data//UserPrivilege.json", UserPrivilege.class);
        List<Instructor> instructors = fileManager.readFromFile();
        List<UserPrivilege> userPrivileges = fileManager2.readFromFile();

        System.out.print("Enter instructor id: ");
        int instructorId = scanner.nextInt();

        System.out.print("Enter pavilege id: ");
        int privilegeId = scanner.nextInt();

        for (UserPrivilege userPrivilege : userPrivileges) {
            if (userPrivilege.getId() == privilegeId){
                existPrivilegeId = userPrivilege.getId();
                existPrivilegeName = userPrivilege.getPrivilegeName();
                isExist = true;
                break;
            }
        }

        if (!isExist) {
            System.out.println("Privilege does not exist.");
            return;
        }
        for (Instructor instructor : instructors) {
            if (instructor.getId() == instructorId) {
                    UserPrivilege userPrivilege = new UserPrivilege(existPrivilegeId, existPrivilegeName);
                    instructor.addPrivilege(userPrivilege);
                    fileManager.updateFile(instructors, instructor);
                break;
            }
        }

        System.out.println("Instructor updated successfully.");
    }

    public static void editStudent(Scanner scanner) {
        System.out.println("Edit Student");
        boolean isExist = false;
        int existPrivilegeId = 0;
        String existPrivilegeName = "";

        FileManager<Student> fileManager = new FileManager<Student>(".//target//data//Student.json", Student.class);
        FileManager<UserPrivilege> fileManager2 = new FileManager<UserPrivilege>(".//target//data//UserPrivilege.json", UserPrivilege.class);
        List<Student> students = fileManager.readFromFile();
        List<UserPrivilege> userPrivileges = fileManager2.readFromFile();

        System.out.print("Enter student id: ");
        int studentId = scanner.nextInt();

        System.out.print("Enter pavilege id: ");
        int privilegeId = scanner.nextInt();

        for (UserPrivilege userPrivilege : userPrivileges) {
            if (userPrivilege.getId() == privilegeId){
                existPrivilegeId = userPrivilege.getId();
                existPrivilegeName = userPrivilege.getPrivilegeName();
                isExist = true;
                break;
            }
        }

        if (!isExist) {
            System.out.println("Privilege does not exist.");
            return;
        }
        for (Student student : students) {
            if (student.getId() == studentId) {
                    UserPrivilege userPrivilege = new UserPrivilege(existPrivilegeId, existPrivilegeName);
                    student.addPrivilege(userPrivilege);
                    fileManager.updateFile(students, student);
                break;
            }
        }

        System.out.println("Student updated successfully.");
    }

    public static void deleteStudent(Scanner scanner) {
        System.out.println("Delete Student");
        boolean isExist = false;

        FileManager<Student> fileManager = new FileManager<Student>(".//target//data//Student.json", Student.class);
        List<Student> students = fileManager.readFromFile();

        System.out.print("Enter id: ");
        int id = scanner.nextInt();

        for (Student student : students) {
            if (student.getId() == id) {
                fileManager.deleteFromFile(students, student);
                System.out.println("Student deleted successfully.");
                isExist = true;
                break;
            }
        }

        if (!isExist) {
            System.out.println("Student does not exist.");
        }
    }

    public static void addUserPrivilege(Scanner scanner) {
        System.out.println("Add User Privilege");

        FileManager<UserPrivilege> fileManager = new FileManager<UserPrivilege>(".//target//data//UserPrivilege.json", UserPrivilege.class);
        List<UserPrivilege> userPrivileges = fileManager.readFromFile();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        UserPrivilege newUserPrivilege = new UserPrivilege(userPrivileges.size() + 1, name);

        fileManager.appendToFile(userPrivileges, newUserPrivilege);

        System.out.println("User Privilege added successfully.");
    }

    public static void editUserPrivilege(Scanner scanner) {
        System.out.println("Edit User Privilege");
        boolean isExist = false;

        FileManager<UserPrivilege> fileManager = new FileManager<UserPrivilege>(".//target//data//UserPrivilege.json", UserPrivilege.class);
        List<UserPrivilege> userPrivileges = fileManager.readFromFile();

        System.out.print("Enter user privilege id: ");
        int id = scanner.nextInt();

        for (UserPrivilege userPrivilege : userPrivileges) {
            if (userPrivilege.getId() == id){
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                userPrivilege.setPrivilegeName(newName);
                fileManager.updateFile(userPrivileges, userPrivilege);
                break;
            }
        }

        if (!isExist) {
            System.out.println("User Privilege does not exist.");
        }else {
            System.out.println("User Privilege updated successfully.");
        }
    }

    public static void deleteUserPrivilege(Scanner scanner) {
        System.out.println("Delete User Privilege");
        boolean isExist = false;

        FileManager<UserPrivilege> fileManager = new FileManager<UserPrivilege>(".//target//data//UserPrivilege.json", UserPrivilege.class);
        List<UserPrivilege> userPrivileges = fileManager.readFromFile();

        System.out.print("Enter user privilege id: ");
        int id = scanner.nextInt();

        for (UserPrivilege userPrivilege : userPrivileges) {
            if (userPrivilege.getId() == id){
                fileManager.deleteFromFile(userPrivileges, userPrivilege);
                System.out.println("User Privilege deleted successfully.");
                isExist = true;
                break;
            }
        }

        if (!isExist) {
            System.out.println("User Privilege does not exist.");
        }
    }

    public void addUserType() {
    }

    public void editUserType() {
    }

    public void deleteUserType() {
    }
}

