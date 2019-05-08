package mavha.domain.repository;

import mavha.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by fnatalino on 16/4/2019.
 */

public interface TaskRepository extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {

}


