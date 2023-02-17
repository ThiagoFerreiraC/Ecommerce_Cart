package general.entities;

import general.enums.CommandType;

public class CommandEntity {

    CommandType commandType;

    String description;

    public CommandEntity(CommandType commandType, String description) {
        this.commandType = commandType;
        this.description = description;
    }


    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
