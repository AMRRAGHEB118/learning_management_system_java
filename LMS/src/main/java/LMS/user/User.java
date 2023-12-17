package LMS.user;

import java.util.List;
import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private int userTypeId;
    private List<UserPrivilege> privileges;

    public User() {
    }

    public User(int id, String name, String email, String password, int userTypeId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userTypeId = userTypeId;
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

    public int getUserTypeId() {
        return userTypeId;
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

    public String getPassword() {
        return password;
    }

}
