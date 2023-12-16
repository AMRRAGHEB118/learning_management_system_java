package LMS.user;

import LMS.GlobalConfig;

public class Instructor extends User {
    public Instructor() {
        super();
    }

    public Instructor(int id, String name, String email, String password) {
        super(id, name, email, password, GlobalConfig.USER_TYPE_INSTRUCTOR.getTypeName());
    }
}
