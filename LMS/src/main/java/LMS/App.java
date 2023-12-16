package LMS;

import java.util.Scanner;

import LMS.system.MainMenu;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainMenu.showDashboard(scanner);
    }
}

