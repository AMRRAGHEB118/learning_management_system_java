package LMS.user;

import LMS.GlobalConfig;

public class UserType {
    private String typeName;

    public UserType(String typeName) {
        this.typeName = typeName;
    }

    public UserType(String typeName, String currentUserType) {
        if ("ADMIN".equals(currentUserType) && typeName.equals(typeName.toUpperCase()) &&
                !typeName.equals(GlobalConfig.USER_TYPE_ADMIN.getTypeName()) &&
                !typeName.equals(GlobalConfig.USER_TYPE_INSTRUCTOR.getTypeName()) &&
                !typeName.equals(GlobalConfig.USER_TYPE_STUDENT.getTypeName())) {
            this.typeName = typeName;
        } else {
            throw new IllegalArgumentException("Only ADMIN can create new user types, and the type name must be in capital letters.");
        }
    }
    

    public String getTypeName() {
        return typeName;
    }
}

