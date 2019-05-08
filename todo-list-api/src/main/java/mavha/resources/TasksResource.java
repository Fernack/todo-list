package mavha.resources;

import mavha.domain.entities.Task;
import mavha.domain.repository.TaskRepository;
import mavha.domain.services.implementations.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by fnatalino on 16/4/2019.
 */
@CrossOrigin( origins = "*", methods = {RequestMethod.GET, RequestMethod.HEAD, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS},
        allowedHeaders = {"Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers"})
@RestController()
@RequestMapping("/tasks")
public class TasksResource {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> getTasks(@RequestParam(required=false) Long id, @RequestParam(required=false) String description, @RequestParam(required=false) Boolean state){
        return taskService.filterTasks(id, description, state);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Task addTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @PutMapping(value = "/{taskId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Task changeTask(@PathVariable Long taskId){

        Task task = taskRepository.findOne(taskId);
        task.setState(!task.getState());

        return taskRepository.save(task);
    }
}
