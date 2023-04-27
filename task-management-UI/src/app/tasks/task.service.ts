import { Injectable } from '@angular/core';
import { HttpService } from '../shared/httpService';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private httpService: HttpService) { }

  calculateEndDate(data: any) {
    return this.httpService.calculateEndDate(data);
  }
}
