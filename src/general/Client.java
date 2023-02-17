package general;

import general.commands.SwitchMenuCommand;
import general.enums.SystemStatus;
import general.enums.MenuType;
import general.factories.CommandFactory;
import general.factories.MenuFactory;
import general.models.SystemConfig;

public class Client {


    public void init() {
        CommandFactory.setNameToActionCommandMap();
        MenuFactory menuFactory = new MenuFactory();
        menuFactory.init();
        SystemConfig.getInstance().setStatus(SystemStatus.ANONYMOUS);
        SwitchMenuCommand switchMenuCommand = new SwitchMenuCommand(MenuType.STARTER);
        switchMenuCommand.execute();
    }
}
