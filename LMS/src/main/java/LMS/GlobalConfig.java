package LMS;

import LMS.user.UserType;

public class GlobalConfig {
    public static final UserType USER_TYPE_ADMIN = new UserType("ADMIN");
    public static final UserType USER_TYPE_INSTRUCTOR = new UserType("INSTRUCTOR");
    public static final UserType USER_TYPE_STUDENT = new UserType("STUDENT");
}
