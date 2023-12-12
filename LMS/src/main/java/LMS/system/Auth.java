package LMS.system;

import java.util.List;
import java.util.Scanner;

import LMS.user.User;

public class Auth {
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }
    public void login() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Login");
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            User user = validateUser(username, password);

            if (user != null) {
                currentUser = user;
                System.out.println("Login successful. Welcome, " + currentUser.getName() + "!");
            } else {
                System.out.println("Invalid username or password. Login failed.");
            }
        }
    }

    private User validateUser(String email, String password) {
        FileManager<User> fileManager = new FileManager<User>("users.json", User.class);
        List<User> users = fileManager.readFromFile();

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            } else {
                return null;
            }
        }
        return null;
        }

    public void logout() {
        currentUser = null;
        System.out.println("Logout successful. Goodbye!");
    }
}

