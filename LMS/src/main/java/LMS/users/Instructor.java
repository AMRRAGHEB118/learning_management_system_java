package LMS.users;

import java.util.List;

import LMS.GlobalConfig;

public class Instructor extends User {
    public Instructor(int id, String name, String email, String password) {
        super(id, name, email, password, GlobalConfig.USER_TYPE_INSTRUCTOR);
    }

@Override
public void displayUserInfo() {
    System.out.println("Instructor Information:");
    System.out.println("ID: " + getId());
    System.out.println("Name: " + getName());
    System.out.println("User Type: " + getUserType().getTypeName());

    List<UserPrivilege> instructorPrivileges = getPrivileges();
    if (!instructorPrivileges.isEmpty()) {
        System.out.println("Privileges:");
        for (UserPrivilege privilege : instructorPrivileges) {
            System.out.println("- " + privilege.getPrivilegeName());
        }
    } else {
        System.out.println("No privileges assigned.");
    }

    // Additional details specific to instructors
    // System.out.println("Teaching Subjects: Java Programming, Software Engineering");
    // System.out.println("Experience: 10 years");
}

}
