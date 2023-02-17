package general.models;

import general.commands.Command;
import general.entities.CommandEntity;
import general.entities.MenuEntity;
import general.enums.SystemStatus;
import general.enums.MenuType;
import general.menus.IMenuView;

import java.util.List;

public interface MenuService {

    void createMenu(MenuEntity menuEntity, MenuType menuType);

    void addCommand(CommandEntity commandEntity);

    void finishStatusConfiguration(SystemStatus status);

    void setView(IMenuView view);

    void setMenu(MenuType menuType);

    List<String> getDescriptionList();

    IMenuView getView(MenuType menuType);

    Command getCommand(int input);
}
