package LMS.user;

public class UserPrivilege {
    private int id;
    private String privilegeName;

    public UserPrivilege() {
    }

    public UserPrivilege(int id, String privilegeName) {
        this.id = id;
        this.privilegeName = privilegeName;
    }

    public int getId() {
        return id;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }
}
