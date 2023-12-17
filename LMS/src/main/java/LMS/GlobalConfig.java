package LMS;

import LMS.user.UserType;

public class GlobalConfig {
    public static final UserType USER_TYPE_ADMIN = new UserType(1000,"ADMIN");
    public static final UserType USER_TYPE_INSTRUCTOR = new UserType(1001,"INSTRUCTOR");
    public static final UserType USER_TYPE_STUDENT = new UserType(1002,"STUDENT");

    public static final String QUESTION_FILE_PATH = ".//target//data//Question.json";
    public static final String EXAM_FILE_PATH = ".//target//data//Exam.json";
    public static final String COURSE_FILE_PATH = ".//target//data//Course.json";
    public static final String USER_TYPE_FILE_PATH = ".//target//data//UserType.json";

}
