package general;

import general.commands.CloseCommand;
import general.commands.Command;
import general.commands.LogOutCommand;
import general.commands.SwitchMenuCommand;
import general.enums.CommandName;
import general.enums.MenuName;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    static Map<CommandName, Command> nameToActionCommandMap = new HashMap<>();

    public static void setNameToActionCommandMap() {
        //-----------------BaseMenu switches
        SwitchMenuCommand switchToShoppingMenu = new SwitchMenuCommand(MenuName.SHOPPING);
        SwitchMenuCommand switchToLogRegisterMenu = new SwitchMenuCommand(MenuName.LOG_REGISTER);
        SwitchMenuCommand switchToStarterMenu = new SwitchMenuCommand(MenuName.STARTER);
        SwitchMenuCommand switchToCartMenu = new SwitchMenuCommand(MenuName.CART);
        SwitchMenuCommand switchToPaymentMenu = new SwitchMenuCommand(MenuName.PAYMENT);

        nameToActionCommandMap.put(CommandName.SWITCH_SHOPPING_MENU, switchToShoppingMenu);
        nameToActionCommandMap.put(CommandName.SWITCH_STARTER_MENU, switchToStarterMenu);
        nameToActionCommandMap.put(CommandName.SWITCH_CART_MENU, switchToCartMenu);
        nameToActionCommandMap.put(CommandName.SWITCH_PAYMENT_MENU, switchToPaymentMenu);
        nameToActionCommandMap.put(CommandName.SWITCH_LOG_REGISTER_MENU, switchToLogRegisterMenu);

        //-----------------General Commands
        CloseCommand closeCommand = new CloseCommand();
        LogOutCommand logOutCommand =  new LogOutCommand();

        nameToActionCommandMap.put(CommandName.CLOSE, closeCommand);
        nameToActionCommandMap.put(CommandName.LOG_OUT,logOutCommand);

    }

    public static Map<CommandName, Command> getNameToActionCommandMap() {
        return nameToActionCommandMap;
    }
}
