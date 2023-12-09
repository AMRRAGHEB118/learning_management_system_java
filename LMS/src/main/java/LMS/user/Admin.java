package LMS.user;

import java.util.ArrayList;
import java.util.List;

import LMS.GlobalConfig;

public class Admin extends User {
    private List<String> privileges;

    public Admin(int id, String name, String email, String password, List<String> privileges) {
        super(id, name, email, password, GlobalConfig.USER_TYPE_ADMIN, new ArrayList<>());
        this.privileges = new ArrayList<>();
    }

    public void addPrivilege(String privilege) {
        privileges.add(privilege);
    }

    public void removePrivilege(String privilege) {
        privileges.remove(privilege);
    }

    @Override
    public void displayUserInfo() {
        System.out.println("Admin Information:");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("User Type: " + getUserType().getTypeName());

        if (!privileges.isEmpty()) {
            System.out.println("Privileges:");
            for (String privilege : privileges) {
                System.out.println("- " + privilege);
            }
        } else {
            System.out.println("No privileges assigned.");
        }
    }
}

