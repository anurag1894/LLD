package TMS.strategy;

import TMS.data.Task;

import java.util.Comparator;
import java.util.List;

public class TaskSortByPriority implements TaskSortStrategy{
    @Override
    public void sort(List<Task> tasks) {
        // Higher priority (lower enum ordinal) comes first
        tasks.sort(Comparator.comparing(Task::getPriority).reversed());
    }
}
