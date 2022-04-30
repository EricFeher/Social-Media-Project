import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Groups } from '../models/groups.model';

@Injectable({
  providedIn: 'root'
})
export class GroupsService {

  private baseUrl = 'http://localhost:8081/api/groups';

  constructor(private http: HttpClient) { }

  public getAll(): Observable<any>{
    return this.http.get<Groups[]>(`${this.baseUrl}/select`)
}
public deleteStudent(id: number): void { 
  this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' }).subscribe();
}  
}
