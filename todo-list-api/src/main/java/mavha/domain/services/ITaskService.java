package mavha.domain.services;

import mavha.domain.entities.Task;

import java.util.List;

/**
 * Created by fnatalino on 29/4/2019.
 */
public interface ITaskService {
    public List<Task> filterTasks(Long id, String description, Boolean state);
}
