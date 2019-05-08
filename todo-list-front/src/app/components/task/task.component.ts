import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Task } from '../../shared/models/task';

@Component({
  selector: 'task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})

export class TaskComponent {
  @Input() task:Task;
  @Output() completeTask = new EventEmitter<Task>();

  onCompleteTask(task: Task): void {
    this.completeTask.emit(task);
  }

}
