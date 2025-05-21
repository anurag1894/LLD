package LoggingService;

import LoggingService.mgmt.LogSystem;

public class Main {
    public static void main(String[] args) {
        LogSystem logSystem = new LogSystem(); // can create singleton Design pattern
        logSystem.log("This is Log Service", "DEBUG", "db");
        logSystem.log("This is Log Service", "INFO", "console");
        logSystem.log("This is Log Service", "WARN", "console");
        logSystem.log("This is Log Service", "ERROR", "console");
    }
}
