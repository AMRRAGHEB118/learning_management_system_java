package LMS.users;

import java.util.List;
import java.util.ArrayList;

public abstract class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private UserType userType;
    private List<UserPrivilege> privileges;

    public User(int id, String name, String email, String password, UserType userType, List<UserPrivilege> privileges) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.privileges = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UserType getUserType() {
        return userType;
    }

    public List<UserPrivilege> getPrivileges() {
        return new ArrayList<>(privileges);
    }

    public void addPrivilege(UserPrivilege privilege) {
        privileges.add(privilege);
    }

    public void removePrivilege(UserPrivilege privilege) {
        privileges.remove(privilege);
    }


    public void updatePassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("New password cannot be empty.");
        }
        this.password = password;
    }

    public abstract void displayUserInfo();

}
