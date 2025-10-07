package TMS.data;

import java.time.LocalDate;

public class ActivityLog {
    private String description;
    private LocalDate date;
    public ActivityLog(String description) {
        this.description = description;
        this.date = LocalDate.now();

    }
    public String getDescription() {
        return description;
    }
}
