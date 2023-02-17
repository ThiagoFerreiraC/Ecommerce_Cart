package general.factories;

import general.commands.CloseCommand;
import general.commands.Command;
import general.commands.LogOutCommand;
import general.commands.SwitchMenuCommand;
import general.enums.CommandType;
import general.enums.MenuType;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    static Map<CommandType, Command> nameToActionCommandMap = new HashMap<>();

    static CommandFactory instance;

    private CommandFactory() {}

    public static CommandFactory getInstance() {
        if(instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    public static void setNameToActionCommandMap() {
        //-----------------MenuEntity switches
        SwitchMenuCommand switchToShoppingMenu = new SwitchMenuCommand(MenuType.SHOPPING);
        SwitchMenuCommand switchToLogRegisterMenu = new SwitchMenuCommand(MenuType.LOG_REGISTER);
        SwitchMenuCommand switchToStarterMenu = new SwitchMenuCommand(MenuType.STARTER);
        SwitchMenuCommand switchToCartMenu = new SwitchMenuCommand(MenuType.CART);
        SwitchMenuCommand switchToPaymentMenu = new SwitchMenuCommand(MenuType.PAYMENT);

        nameToActionCommandMap.put(CommandType.SWITCH_SHOPPING_MENU, switchToShoppingMenu);
        nameToActionCommandMap.put(CommandType.SWITCH_STARTER_MENU, switchToStarterMenu);
        nameToActionCommandMap.put(CommandType.SWITCH_CART_MENU, switchToCartMenu);
        nameToActionCommandMap.put(CommandType.SWITCH_PAYMENT_MENU, switchToPaymentMenu);
        nameToActionCommandMap.put(CommandType.SWITCH_LOG_REGISTER_MENU, switchToLogRegisterMenu);

        //-----------------General Commands
        CloseCommand closeCommand = new CloseCommand();
        LogOutCommand logOutCommand =  new LogOutCommand();

        nameToActionCommandMap.put(CommandType.CLOSE, closeCommand);
        nameToActionCommandMap.put(CommandType.LOG_OUT,logOutCommand);

    }

    public Map<CommandType, Command> getNameToActionCommandMap() {
        return nameToActionCommandMap;
    }
}
