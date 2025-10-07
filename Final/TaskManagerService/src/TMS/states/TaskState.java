package TMS.states;

import TMS.data.Task;
import TMS.enums.TaskStatus;

public interface TaskState {
    public TaskStatus getStatus();
    void startProgress(Task task);
    void reopenTask(Task task);
    void completeTask(Task task);
}
