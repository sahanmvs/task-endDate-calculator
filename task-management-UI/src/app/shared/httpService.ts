import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class HttpService {
  private taskURL = 'http://localhost:8080/api/'


  constructor(private http: HttpClient) { }

  calculateEndDate(data: any) {
    return this.http.post(this.taskURL, data);
  }

}
