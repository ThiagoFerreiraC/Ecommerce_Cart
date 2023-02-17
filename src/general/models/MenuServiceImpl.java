package general.models;

import general.factories.CommandFactory;
import general.commands.Command;
import general.entities.CommandEntity;
import general.entities.MenuEntity;
import general.enums.SystemStatus;
import general.enums.CommandType;
import general.enums.MenuType;
import general.menus.IMenuView;

import java.util.ArrayList;
import java.util.List;

public class MenuServiceImpl implements MenuService {
    MenuRepository repository;
    List<CommandEntity> commandEntityList = new ArrayList<>();

    public MenuServiceImpl(MenuRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createMenu(MenuEntity menuEntity, MenuType menuType) {
        repository.setMenu(menuEntity);
        repository.setMenuType(menuType);
        repository.createMenu();
    }

    @Override
    public void addCommand(CommandEntity commandEntity) {
        commandEntityList.add(commandEntity);
    }

    @Override
    public void setView(IMenuView view) {
        repository.addViewToMenuViewMap(view);
    }

    @Override
    public void setMenu(MenuType menuType) {
        repository.setMenu(menuType);
    }

    @Override
    public IMenuView getView(MenuType menuType) {
        return repository.getView(menuType);
    }

    @Override
    public void finishStatusConfiguration(SystemStatus status) {
        if (status != SystemStatus.NEUTRAL) {
            commandEntityList.addAll(repository.getBaseCommands());
        }
        repository.associateCommandEntityListWithStatus(status, commandEntityList);
        List<CommandEntity> auxCommandEntityList = new ArrayList<>();
        commandEntityList = auxCommandEntityList;
    }

    @Override
    public Command getCommand(int input) {
        SystemStatus status = SystemConfig.getInstance().getStatus();
        CommandEntity commandEntity = repository.getCommandEntityList(status).get(input - 1);
        CommandType commandType = commandEntity.getCommandType();
        return CommandFactory.getInstance().getNameToActionCommandMap().get(commandType);
    }

    public List<String> getDescriptionList() {
        SystemStatus status = SystemConfig.getInstance().getStatus();
        List<CommandEntity> commandEntityList1 = repository.getCommandEntityList(status);
        List<String> descriptionList = new ArrayList<>();
        for (CommandEntity commandEntity : commandEntityList1) {
            descriptionList.add(commandEntity.getDescription());
        }
        return descriptionList;
    }
}
