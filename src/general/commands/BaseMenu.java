package general.commands;

import general.CommandFactory;
import general.enums.CommandName;
import general.enums.MenuName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseMenu {
    SystemStatus status;
    MenuName menuName;
    CommandName commandName;
    String commandDisplayText;
    Map<CommandName, String> cmdNameToDisplayTextMap = new HashMap<>();
    Map<SystemStatus, List<Command>> statusToCmdListMap = new HashMap<>();
    List<Command> commandList = new ArrayList<>();
    List<Command> baseCommandList = new ArrayList<>();

    public BaseMenu(MenuName menuName) {
        this.menuName = menuName;
    }

    public void setCommandName(CommandName cmdName) {
        this.commandName = cmdName;
    }

    public void setCommandDisplayText(String commandDisplayText) {
        this.commandDisplayText = commandDisplayText;
    }

    public void addCommandToList() {
        Command command = CommandFactory.getNameToActionCommandMap().get(commandName);
        commandList.add(command);
    }

    public void configureCommand(CommandName commandName, String commandDisplayText) {
        setCommandName(commandName);
        setCommandDisplayText(commandDisplayText);
        addCommandToList();
        setCmdNameToDisplayTextMap();
    }

    public void setCmdNameToDisplayTextMap() {
        cmdNameToDisplayTextMap.put(commandName, commandDisplayText);
    }

    public void setStatus(SystemStatus status) {
        this.status = status;
    }

    public void generateMap() {
        List<Command> temp = new ArrayList<>(baseCommandList);
        temp.addAll(commandList);
        statusToCmdListMap.put(status, temp);
    }

    public void generateBaseList() {
        baseCommandList = commandList;
    }

    public Map<CommandName, String> getCmdNameToDisplayTextMap() {
        return cmdNameToDisplayTextMap;
    }

    public Map<SystemStatus, List<Command>> getStatusToCmdListMap() {
        return statusToCmdListMap;
    }
}
