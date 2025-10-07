package TMS.states;

import TMS.data.Task;
import TMS.enums.TaskStatus;

public class TaskCompletedState implements TaskState{
    @Override
    public void startProgress(Task task) {
        System.out.println("Cannot start a completed task. Reopen it first.");
    }
    @Override
    public void completeTask(Task task) {
        System.out.println("Task is already done.");
    }
    @Override
    public void reopenTask(Task task) {
        task.setState(new TaskToDoState());
    }
    @Override
    public TaskStatus getStatus() { return TaskStatus.DONE; }

}
