import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { School } from '../models/school.model';

@Injectable({
  providedIn: 'root'
})
export class SchoolService {

  private baseUrl = 'http://localhost:8081/api/school';

  constructor(private http: HttpClient) { }

  public getAll(): Observable<any>{
    return this.http.get<School[]>(`${this.baseUrl}/select`)
}
}