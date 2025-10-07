package TMS.states;

import TMS.data.Task;
import TMS.enums.TaskStatus;

public class TaskInProgressState implements TaskState{
    @Override
    public void startProgress(Task task) {
        System.out.println("Task is already in progress.");
    }
    @Override
    public void completeTask(Task task) {
        task.setState(new TaskCompletedState());
    }
    @Override
    public void reopenTask(Task task) {
        task.setState(new TaskToDoState());
    }
    @Override
    public TaskStatus getStatus() { return TaskStatus.IN_PROGRESS; }

}
