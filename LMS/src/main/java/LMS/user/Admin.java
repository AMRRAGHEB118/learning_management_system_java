package LMS.user;

import java.util.ArrayList;
import java.util.List;

import LMS.system.FileManager;

public class Admin extends User {
    private List<UserPrivilege> privileges;

    public Admin() {
        this.privileges = new ArrayList<>();
    }

    public Admin(int id, String name, String email, String password, List<UserPrivilege> privileges) {
        super(id, name, email, password, "admin");
        this.privileges = new ArrayList<>(privileges);
    }

    public List<UserPrivilege> getPrivileges() {
        return privileges;
    }

    public void addPrivilege(UserPrivilege privilege) {
        privileges.add(privilege);
    }

    public void removePrivilege(UserPrivilege privilege) {
        privileges.remove(privilege);
    }

    public void addUser() {
        System.out.println("Add User");
    }

    public void editUser() {
        System.out.println("Edit User");
    }

    public void deleteUser() {
        System.out.println("Delete User");
    }

    public void viewUsers() {
        System.out.println("View Users");

        FileManager<User> fileManager = new FileManager<User>(".//target//data//User.json", User.class);
        List<User> users = fileManager.readFromFile();

        for (User user : users) {
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
            System.out.println();
        }
    }

    public void addUserType() {
    }

    public void editUserType() {
    }

    public void deleteUserType() {
    }

    public void removePrivilege() {
    }

    public void editPrivilege() {
    }
}

