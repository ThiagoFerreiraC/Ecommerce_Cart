package general.menus;

import java.util.List;
import java.util.Scanner;

public class LogRegisterMenuView implements IMenuView {

    public void display() {
        System.out.println("At registry!");
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
