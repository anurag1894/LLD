package TMS.observer;

import TMS.data.Task;

public interface TaskObserver {
    void update(Task task, String changeType);
}
