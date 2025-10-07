package TMS.observer;

import TMS.data.Task;

public class ActivityLogger implements  TaskObserver{

    @Override
    public void update(Task task, String changeType) {
        System.out.println("LOGGER: Task '" + task.getTitle() + "' was updated. Change: " + changeType);
    }
}
