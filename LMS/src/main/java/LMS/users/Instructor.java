package LMS.users;

import java.util.ArrayList;
import java.util.List;

import LMS.GlobalConfig;

public class Instructor extends User {
    public Instructor(int id, String name, String email, String password, List<String> privileges) {
        super(id, name, email, password, GlobalConfig.USER_TYPE_INSTRUCTOR, new ArrayList<>());
    }

@Override
public void displayUserInfo() {
    System.out.println("Instructor Information:");
    System.out.println("ID: " + getId());
    System.out.println("Name: " + getName());
    System.out.println("User Type: " + getUserType().getTypeName());
    System.out.println("Privileges: " + getPrivileges());

}

}
