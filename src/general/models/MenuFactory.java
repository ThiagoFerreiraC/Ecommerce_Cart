package general.models;

import general.commands.*;
import general.enums.CommandName;
import general.menus.IMenuView;
import general.enums.MenuName;
import general.menus.LogRegisterMenuMenuView;
import general.menus.ShopMenuMenuView;
import general.menus.StarterMenuView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuFactory {
    Map<MenuName, IMenuView> menuToViewMap = new HashMap<>();
    Map<MenuName, BaseMenu> typeToMenuMap = new HashMap<>();
    SystemStatus status;
    BaseMenu shopObj;
    BaseMenu starterBaseMenu;
    BaseMenu cartBaseMenu;

    public Map<MenuName, IMenuView> getMenuToViewMap() {
        return menuToViewMap;
    }

    public void setUpMenus() {
        setUpNeutralMenus();
        setUpAnonMenus();
        setUpLogMenus();
    }

    private void setUpNeutralMenus() {
        SystemStatus status = SystemStatus.NEUTRAL;
        //-------------------Starter BaseMenu
        starterBaseMenu = new BaseMenu(MenuName.STARTER);
        starterBaseMenu.setStatus(status);
        starterBaseMenu.configureCommand(CommandName.SWITCH_SHOPPING_MENU, "Shop");
        starterBaseMenu.configureCommand(CommandName.SWITCH_LOG_REGISTER_MENU, "Log or Register");
        starterBaseMenu.configureCommand(CommandName.CLOSE, "Close");
        starterBaseMenu.generateBaseList();

        //-------------------Shopping BaseMenu
        BaseMenu neutralShopBaseMenu;
        shopObj = new BaseMenu(MenuName.SHOPPING);
        shopObj.setStatus(status);
        //shoppingMenuList.add(getCmd(AddItemToCart));
        shopObj.configureCommand(CommandName.SWITCH_CART_MENU, "Go to Cart");
        shopObj.generateBaseList();

        //-------------------Cart BaseMenu
        cartBaseMenu = new BaseMenu(MenuName.CART);
        cartBaseMenu.setStatus(status);
        cartBaseMenu.configureCommand(CommandName.SWITCH_SHOPPING_MENU, "Continue Shopping");
        cartBaseMenu.generateBaseList();
        //neutralCartMenu.setCmdNameToDisplayTextMap(---, "Remove item");
    }
    private void setUpAnonMenus() {
        SystemStatus status = SystemStatus.ANONYMOUS;
        starterBaseMenu.setStatus(status);
        starterBaseMenu.generateMap();

        //-------------------Shopping BaseMenu
        shopObj.setStatus(status);
        shopObj.configureCommand(CommandName.SWITCH_LOG_REGISTER_MENU, "Log or Register");
        shopObj.configureCommand(CommandName.SWITCH_STARTER_MENU, "Return");
        shopObj.generateMap();

        //-------------------Cart BaseMenu
        cartBaseMenu.setStatus(status);
        cartBaseMenu.configureCommand(CommandName.SWITCH_LOG_REGISTER_MENU, "End Shopping");
        cartBaseMenu.generateMap();
    }

    private void setUpLogMenus() {
        SystemStatus status = SystemStatus.LOGGED;

        starterBaseMenu.setStatus(status);
        starterBaseMenu.generateMap();
        //-------------------Shopping BaseMenu
        shopObj.setStatus(status);
        shopObj.configureCommand(CommandName.LOG_OUT, "Log Out");
        shopObj.generateMap();

        //-------------------Cart BaseMenu
        cartBaseMenu.setStatus(status);
        cartBaseMenu.configureCommand(CommandName.SWITCH_PAYMENT_MENU, "End Shopping");
        cartBaseMenu.generateMap();

        //----------------------------
        typeToMenuMap.put(MenuName.STARTER, starterBaseMenu);
        typeToMenuMap.put(MenuName.SHOPPING, shopObj);
        typeToMenuMap.put(MenuName.CART, cartBaseMenu);
    }

    public void setUpViews() {
        menuToViewMap.put(MenuName.STARTER, new StarterMenuView());
        menuToViewMap.put(MenuName.SHOPPING, new ShopMenuMenuView());
        menuToViewMap.put(MenuName.LOG_REGISTER, new LogRegisterMenuMenuView());
        //CartView
        //PaymentView
    }

    public void executeAsLoggedUser() {
        setStatus(SystemStatus.LOGGED);
    }

    public void executeAsAnonymousUser() {
        setStatus(SystemStatus.ANONYMOUS);
    }

    public void setStatus(SystemStatus status) {
        this.status = status;
    }

    public List<Command> getCommandList(MenuName menuName) {
        return typeToMenuMap.get(menuName).getStatusToCmdListMap().get(status);
    }
}
