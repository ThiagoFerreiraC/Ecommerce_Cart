package general.models;

import general.enums.SystemStatus;

public class SystemConfig {
    SystemStatus status;
    static SystemConfig instance;
    public SystemStatus getStatus() {
        return status;
    }
    public void setStatus(SystemStatus status) {
        this.status = status;
    }
    private SystemConfig() {}
    public static SystemConfig getInstance() {
        if (instance == null) {
            instance = new SystemConfig();
        }
        return  instance;
    }
}
