package general.factories;

import general.entities.MenuEntity;
import general.enums.SystemStatus;
import general.enums.CommandType;
import general.enums.MenuType;
import general.menus.ShopMenuView;
import general.menus.StarterMenuView;
import general.entities.CommandEntity;
import general.models.MenuRepository;
import general.models.MenuService;
import general.models.MenuServiceImpl;

public class MenuFactory {
    SystemStatus status;
    MenuService service;
    MenuEntity menu;

    public void init() {
        service = new MenuServiceImpl(new MenuRepository());
        setUpStarterMenu();
        setUpShopMenu();
        setUpCartMenu();
    }

    private void setUpStarterMenu() {
        menu = new MenuEntity();
        service.createMenu(menu, MenuType.STARTER);
        service.setView(new StarterMenuView());

        status = SystemStatus.NEUTRAL;
        service.addCommand(new CommandEntity(CommandType.SWITCH_SHOPPING_MENU, "Shop"));
        service.addCommand(new CommandEntity(CommandType.SWITCH_LOG_REGISTER_MENU, "Log or Register"));
        service.addCommand(new CommandEntity(CommandType.CLOSE, "Close"));
        service.finishStatusConfiguration(status);
        service.finishStatusConfiguration(SystemStatus.ANONYMOUS);
        service.finishStatusConfiguration(SystemStatus.LOGGED);
    }

    private void setUpShopMenu() {
        menu = new MenuEntity();
        service.createMenu(menu, MenuType.SHOPPING);
        service.setView(new ShopMenuView());

        status = SystemStatus.NEUTRAL;
        service.addCommand(new CommandEntity(CommandType.SWITCH_CART_MENU, "Go to Cart"));
        service.finishStatusConfiguration(status);

        status = SystemStatus.ANONYMOUS;
        service.addCommand(new CommandEntity(CommandType.SWITCH_LOG_REGISTER_MENU, "Log or Register"));
        service.addCommand(new CommandEntity(CommandType.SWITCH_STARTER_MENU, "Return"));
        service.finishStatusConfiguration(status);

        status = SystemStatus.LOGGED;
        service.addCommand(new CommandEntity(CommandType.LOG_OUT, "Log Out"));
        service.finishStatusConfiguration(status);
    }

    private void setUpCartMenu() {
        menu = new MenuEntity();
        service.createMenu(menu, MenuType.CART);
        service.setView(new ShopMenuView());

        status = SystemStatus.NEUTRAL;
        service.addCommand(new CommandEntity(CommandType.SWITCH_SHOPPING_MENU, "Continue Shopping"));
        service.finishStatusConfiguration(status);

        status = SystemStatus.ANONYMOUS;
        service.addCommand(new CommandEntity(CommandType.SWITCH_LOG_REGISTER_MENU, "End Shopping"));
        service.finishStatusConfiguration(status);

        status = SystemStatus.LOGGED;
        service.addCommand(new CommandEntity(CommandType.SWITCH_PAYMENT_MENU, "End Shopping"));
        service.finishStatusConfiguration(status);
    }
}
