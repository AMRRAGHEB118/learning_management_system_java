package LMS.user;

public class UserType {
    private int id;
    private String typeName;

    public UserType() {
    }

    public UserType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}