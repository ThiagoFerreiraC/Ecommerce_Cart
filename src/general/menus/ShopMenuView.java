package general.menus;

import java.util.List;
import java.util.Scanner;

public class ShopMenuView implements IMenuView {

    public void display() {
        System.out.println("At the shop");
    }

    @Override
    public void displayMenuOptions(List<String> menuItems) {
        int i =1;
        for (String menuItem: menuItems) {
            System.out.println(i++ + "- " + menuItem);
        }
    }

    public int getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
