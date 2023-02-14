package general.commands;


import general.CreateMenuFactory;
import general.menus.IMenuView;
import general.enums.MenuName;
import general.models.MenuFactory;
import java.util.List;

public class SwitchMenuCommand implements Command{
    IMenuView view;
    private MenuName menuType;
    public SwitchMenuCommand(MenuName menuType) {
        this.menuType = menuType;
    }

    @Override
    public void execute() {
        MenuFactory menuFactory = CreateMenuFactory.getMenuModel();
        view = menuFactory.getMenuToViewMap().get(menuType);
        view.display();
        view.displayMenuOptions();
        int commandToExecute =  view.getInput();
        List<Command> commandList = menuFactory.getCommandList(menuType);
        commandList.get(commandToExecute-1).execute();
    }
}
