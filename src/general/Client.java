package general;

import general.commands.SwitchMenuCommand;
import general.commands.SystemStatus;
import general.enums.MenuName;
public class Client {


    public void init() {
        CommandFactory.setNameToActionCommandMap();
        CreateMenuFactory.setUpMenuModel();
        CreateMenuFactory.getMenuModel().setStatus(SystemStatus.ANONYMOUS);
        SwitchMenuCommand switchMenuCommand = new SwitchMenuCommand(MenuName.STARTER);
        switchMenuCommand.execute();
    }
}
