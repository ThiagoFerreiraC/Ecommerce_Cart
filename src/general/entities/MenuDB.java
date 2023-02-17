package general.entities;

import general.enums.MenuType;
import general.menus.IMenuView;

import java.util.HashMap;
import java.util.Map;

public class MenuDB {
    Map<MenuType, MenuEntity> nameToMenuMap = new HashMap<>();
    Map<MenuType, IMenuView>  menuNameToViewMap = new HashMap<>();
    static MenuDB instance;

    private MenuDB() {

    }

    public static MenuDB getInstance() {
        if (instance == null) {
            instance = new MenuDB();
        }
        return instance;
    }

    public Map<MenuType, MenuEntity> getNameToMenuMap() {
        return nameToMenuMap;
    }

    public void setNameToMenuMap(Map<MenuType, MenuEntity> nameToMenuMap) {
        this.nameToMenuMap = nameToMenuMap;
    }

    public Map<MenuType, IMenuView> getMenuNameToViewMap() {
        return menuNameToViewMap;
    }

    public void setMenuNameToViewMap(Map<MenuType, IMenuView> menuNameToViewMap) {
        this.menuNameToViewMap = menuNameToViewMap;
    }
}
