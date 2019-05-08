import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { SafeHtmlPipe }    from './shared/pipes/safeHtml.pipe';
import { AppComponent } from './app.component';
import { TaskListComponent } from './components/taskList/taskList.component';
import { TaskComponent } from './components/task/task.component';

@NgModule({
  declarations: [
    AppComponent,
    TaskListComponent,
    TaskComponent,
    SafeHtmlPipe
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
