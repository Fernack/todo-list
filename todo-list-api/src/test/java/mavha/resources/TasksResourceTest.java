package mavha.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import mavha.domain.entities.Task;
import mavha.domain.repository.TaskRepository;
import mavha.domain.services.implementations.TaskService;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fnatalino on 29/4/2019.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(TasksResource.class)
public class TasksResourceTest {

    @TestConfiguration
    static class TaskServiceTestContextConfiguration {

        @Bean
        public TaskService TaskService() {
            return new TaskService();
        }
    }

    @MockBean
    TaskRepository taskRepository;

    @Autowired
    private MockMvc mvc;

    @Autowired private ObjectMapper mapper;

    @Before
    public void setUp() {
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("description", new ExampleMatcher.GenericPropertyMatcher().contains().ignoreCase());

        Example<Task> allTasks = Example.of(new Task( null, null, null), matcher);

        Mockito.when(taskRepository.findAll(Matchers.eq(allTasks))).thenReturn(Arrays.asList(new Task( 0l, "description task 0", false),
                new Task( 1l, "description task 1", false),
                new Task( 2l, "description task 2", false),
                new Task( 3l, "description task 3", false)));

        Example<Task> task1 = Example.of(new Task( 1l, null, null), matcher);

        Mockito.when(taskRepository.findAll(Matchers.eq(task1))).thenReturn(Arrays.asList(new Task( 1l, "description task 1", false)));

        Mockito.when(taskRepository.save(new Task( null, "description task 5", false))).thenReturn(new Task( 5l, "description task 5", false));

        Mockito.when(taskRepository.findOne(5l)).thenReturn(new Task( 5l, "description task 5", false));
        Mockito.when(taskRepository.save(new Task( 5l, "description task 5", true))).thenReturn(new Task( 5l, "description task 5", true));
    }

    @Test
    public void givenTasks_whenGetTasks_thenReturnJsonArray() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/tasks")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$", IsCollectionWithSize.hasSize(4)));
    }

    @Test
    public void givenTasks_whenFilterTasks_thenReturnAFilteredTask() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/tasks?id=1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$", IsCollectionWithSize.hasSize(1)))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].description", CoreMatchers.is("description task 1")));
    }


    @Test
    public void givenTasks_whenPostTask_thenReturnCreatedtask() throws Exception {
        String json = mapper.writeValueAsString(new Task( null, "description task 5", false));

        mvc.perform(MockMvcRequestBuilders.post("/tasks")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description", CoreMatchers.is("description task 5")));
    }


    @Test
    public void givenTask_whenPutTask_thenReturnChangedtask() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/tasks/5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.state", CoreMatchers.is(true)));
    }

}
