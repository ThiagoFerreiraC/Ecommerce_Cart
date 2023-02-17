package general.models;

import general.entities.CommandEntity;
import general.entities.MenuDB;
import general.entities.MenuEntity;
import general.enums.SystemStatus;
import general.enums.MenuType;
import general.menus.IMenuView;

import java.util.List;
import java.util.Map;

public class MenuRepository {

    MenuEntity menu;
    MenuType menuType;

    public void createMenu() {
        Map<MenuType, MenuEntity> nameToMenuMap = MenuDB.getInstance().getNameToMenuMap();
        nameToMenuMap.put(menuType, menu);
        MenuDB.getInstance().setNameToMenuMap(nameToMenuMap);
    }

    public void setMenu(MenuEntity menuEntity) {
        this.menu = menuEntity;
    }

    public void setMenuType(MenuType menuType) {
        this.menuType = menuType;
    }

    public void addViewToMenuViewMap(IMenuView view) {
        Map<MenuType, IMenuView> menuNameToViewMap = MenuDB.getInstance().getMenuNameToViewMap();
        menuNameToViewMap.put(menuType, view);
        MenuDB.getInstance().setMenuNameToViewMap(menuNameToViewMap);
    }

    public IMenuView getView(MenuType menuType) {
        return MenuDB.getInstance().getMenuNameToViewMap().get(menuType);
    }

    public void setMenu(MenuType menuType) {
        this.menu = MenuDB.getInstance().getNameToMenuMap().get(menuType);
    }

    public List<CommandEntity> getBaseCommands() {
        return menu.getStatusCommandEntityMap().get(SystemStatus.NEUTRAL);
    }

    public void associateCommandEntityListWithStatus(SystemStatus status, List<CommandEntity> commandEntityList) {
        Map<SystemStatus, List<CommandEntity>> statusCommandEntityMap = menu.getStatusCommandEntityMap();
        statusCommandEntityMap.put(status, commandEntityList);
        menu.setStatusCommandEntityMap(statusCommandEntityMap);
    }

    public List<CommandEntity> getCommandEntityList(SystemStatus status) {
        return menu.getStatusCommandEntityMap().get(status);
    }
}
