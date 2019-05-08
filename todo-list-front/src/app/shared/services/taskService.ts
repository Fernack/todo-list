import { Injectable } from '@angular/core';
import { Task } from '../../shared/models/task';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({ providedIn: 'root' })
export class TaskService {

  private todoListApiUrl = 'http://192.168.10.30:9090/todo-list-api/tasks';

  constructor( private http: HttpClient ) { }

  getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.todoListApiUrl).pipe(
      catchError(this.handleError<Task[]>('getTasks', []))
    );
  }

  addTask(task : Task): Observable<Task> {
    task.state = 'false';

    return this.http.post<Task>(this.todoListApiUrl, task).pipe(
      catchError(this.handleError<Task>('addTask'))
    );
  }

  completeTask(task: Task): Observable<Task>{
    const url = `${this.todoListApiUrl}/${task.id}`;

    return this.http.put<Task>(url, null).pipe(
      catchError(this.handleError<Task>('completeTask'))
    );
  }

  filterTasks(filters: HttpParams ): Observable<Task[]> {
    return this.http.get<Task[]>(this.todoListApiUrl, { params: filters }).pipe(
      catchError(this.handleError<Task[]>('getTasks', []))
    );
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);

      return of(result as T);
    };
  }

}
