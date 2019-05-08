package mavha.domain.services.implementations;

import java.util.List;
import mavha.domain.entities.Task;
import mavha.domain.repository.TaskRepository;
import mavha.domain.services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class TaskService
        implements ITaskService
{

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> filterTasks(Long id, String description, Boolean state)
    {
        Task task = new Task();
        task.setId(id);
        task.setDescription(description);
        task.setState(state);

        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("description", new ExampleMatcher.GenericPropertyMatcher().contains().ignoreCase());

        Example example = Example.of(task, matcher);

        return this.taskRepository.findAll(example);
    }
}