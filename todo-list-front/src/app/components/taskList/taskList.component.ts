import { Component, OnInit } from '@angular/core';
import { TaskService } from '../../shared/services/taskService';
import { Task } from '../../shared/models/task';

@Component({
  selector: 'task-list',
  templateUrl: './taskList.component.html',
  styleUrls: ['./taskList.component.css']
})

export class TaskListComponent implements OnInit {
  private mode = '';
  private tasks : Task[];

  constructor(private taskService: TaskService) {}

  ngOnInit(): void {
     this.getTasks();
  }

  getTasks(): void {
    this.taskService.getTasks().subscribe(tasks => this.tasks = tasks);
  }

  onSubmit(task) {
    return new Promise((resolve, reject) => {
      this.taskService.addTask(task).subscribe(task => {
        this.tasks.push(task);
        resolve();
      });
    });
  }

  onCompleteTask(task: Task): void {
    this.tasks = this.tasks.filter(t => {return ((this.mode==='') || (t !== task)) });

    this.taskService.completeTask(task).subscribe((newTask : Task) => {
      task.state = newTask.state;
    });
  }

  filter(filters){
    filters.id = filters.id !== null ? filters.id : '';

    this.mode = filters.state;

    this.taskService.filterTasks(filters).subscribe(tasks => {
      this.tasks = tasks;
    });
  }

}
