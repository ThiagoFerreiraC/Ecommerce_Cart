package general.menus;

import java.util.Scanner;

public class LogRegisterMenuMenuView implements IMenuView {

    public void display() {
        System.out.println("Welcome!");
    }

    public void displayMenuOptions() {
        System.out.println("1 - Log");
        System.out.println("2 - Register");
        System.out.println("3 - Return");
    }

    public int getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
