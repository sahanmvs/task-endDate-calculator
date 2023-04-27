import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { TaskService } from './task.service';

@Component({
  selector: 'tm-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.scss']
})
export class TasksComponent implements OnInit {

  alert: boolean = false;
  errAlert: boolean = false;
  endDate: any
  errMessage: any

  task = new FormGroup({
    startDate: new FormControl('', [
      Validators.required,
    ]),
    numberOfDays: new FormControl('', [
      Validators.required,
      Validators.min(0)
    ])
  });

  constructor(private taskService: TaskService) { }

  ngOnInit(): void {
  }

  calculateEndDate() {
    console.log(this.task.value);
    this.taskService.calculateEndDate(this.task.value).subscribe({
      next: data => {
        console.log(data);
        this.endDate = data;
        this.alert = true;       
      },
      error: err => {
        console.log(err);
        this.errMessage = err;
        this.errAlert = true;
      } 
    })
  }

  closeAlert() {
    this.alert = false;
    this.task.reset();
  }

  closeErrAlert() {
    this.errAlert = false;
    this.task.reset();
  }

  get startDate() { return this.task.get('startDate'); }

  get numberOfDays() { return this.task.get('numberOfDays'); }

}
