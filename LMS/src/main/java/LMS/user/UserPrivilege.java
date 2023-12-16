package LMS.user;

public class UserPrivilege {
    private String privilegeName;

    public UserPrivilege() {
    }

    public UserPrivilege(String privilegeName) {
        this.privilegeName = privilegeName;
    }


    public String getPrivilegeName() {
        return this.privilegeName;
    }
}
