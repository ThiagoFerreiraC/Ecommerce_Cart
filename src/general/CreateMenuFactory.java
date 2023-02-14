package general;

import general.models.MenuFactory;

public class CreateMenuFactory {

    private static MenuFactory menuFactory = new MenuFactory();

    public static void setUpMenuModel() {
        menuFactory.setUpMenus();
        menuFactory.executeAsAnonymousUser();
        menuFactory.setUpViews();
    }

    public static MenuFactory getMenuModel() {
        return menuFactory;
    }
}
