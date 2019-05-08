import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TaskListComponent } from './components/taskList/taskList.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  private addForm: FormGroup;
  private filterForm: FormGroup;

  @ViewChild(TaskListComponent) taskList: TaskListComponent;

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.addForm = this.fb.group({
      description: this.fb.control("", Validators.required),
      image: null,
      state: false
    });

    this.filterForm = this.fb.group({
      id: "",
      description: "",
      state: ""
    });
  }

  onSubmit() {
    if (this.addForm.invalid) { return; }

    this.taskList.onSubmit(this.addForm.getRawValue()).then(
      res => {
        alert('Task created');
        this.addForm.reset();
      }
    );
  }

  preview(image: Blob) {
    let reader = new FileReader();

    reader.addEventListener("load", () => {
      this.addForm.get('image').setValue((reader.result as string).split(',')[1]);
    }, false);

    if (image) {
      reader.readAsDataURL(image[0]);
    }
  }

  filter(){
    this.taskList.filter(this.filterForm.getRawValue());
  }

}
