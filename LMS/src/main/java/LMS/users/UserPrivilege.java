package LMS.users;

public class UserPrivilege {
    private int id;
    private String privilegeName;
    private String description;

    public UserPrivilege(int id, String privilegeName) {
        this.id = id;
        this.privilegeName = privilegeName;
    }

    public UserPrivilege(int id, String privilegeName, String description) {
        this.id = id;
        this.privilegeName = privilegeName;
        this.description = description;
    }

    public String getPrivilegeName(int id) {
        if (id == this.id) {
            return privilegeName;
        }
        return null;
    }
    
    public String getDescription(int id) {
        if (id == this.id) {
            return description;
        }
        return null;
    }
}
