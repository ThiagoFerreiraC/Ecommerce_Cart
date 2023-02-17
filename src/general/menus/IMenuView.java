package general.menus;

import java.util.List;

public interface IMenuView {

    void display();
    void displayMenuOptions(List<String> menuItems);
    int getInput();
}
