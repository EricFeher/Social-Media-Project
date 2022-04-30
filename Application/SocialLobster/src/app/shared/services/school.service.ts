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

public sendSchoolFromRemote(school: School):Observable<any>{
  return this.http.post<any>(`${this.baseUrl}/save`, school);
}
public deleteStudent(id: number): void { 
  this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' }).subscribe();
}  
}