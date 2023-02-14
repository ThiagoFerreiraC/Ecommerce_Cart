package general.menus;

import java.util.Scanner;

public class ShopMenuMenuView implements IMenuView {

    public void display() {
        System.out.println("Welcome!");
    }

    @Override
    public void displayMenuOptions() {

    }

    public void displayMenuOptionsAnon() {
        System.out.println("1 - Add to Cart");
        System.out.println("2 - Go to Cart");
        System.out.println("3 - Log or Register");
        System.out.println("4 - Return");

    }

    public void displayMenuOptionsLog() {
        System.out.println("1 - Add to Cart");
        System.out.println("2 - Go to Cart");
        System.out.println("3 - Log Out");
    }

    public int getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
