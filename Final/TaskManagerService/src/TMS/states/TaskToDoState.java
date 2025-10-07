package TMS.states;

import TMS.data.Task;
import TMS.enums.TaskStatus;

public class TaskToDoState implements TaskState{
    @Override
    public void startProgress(Task task) {
        task.setState(new TaskInProgressState());
    }
    @Override
    public void completeTask(Task task) {
        System.out.println("Cannot complete a task that is not in progress.");
    }
    @Override
    public void reopenTask(Task task) {
        System.out.println("Task is already in TO-DO state.");
    }

    @Override
    public TaskStatus getStatus() { return TaskStatus.TODO; }

}
