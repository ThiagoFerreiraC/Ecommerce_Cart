package general.entities;

import general.enums.SystemStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuEntity {

    Map<SystemStatus, List<CommandEntity>> statusCommandEntityMap = new HashMap<>();

    public Map<SystemStatus, List<CommandEntity>> getStatusCommandEntityMap() {
        return statusCommandEntityMap;
    }

    public void setStatusCommandEntityMap(Map<SystemStatus, List<CommandEntity>> statusCommandEntityMap) {
        this.statusCommandEntityMap = statusCommandEntityMap;
    }
}
