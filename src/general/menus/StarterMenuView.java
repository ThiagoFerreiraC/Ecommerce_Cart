package general.menus;

import java.util.Scanner;

public class StarterMenuView implements IMenuView {

    public void display() {
        System.out.println("Welcome to our Shop!");
    }

    public void displayMenuOptions() {
        System.out.println("1 - Shop");
        System.out.println("2 - Log or Register");
        System.out.println("3 - Close");
    }

    public int getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
