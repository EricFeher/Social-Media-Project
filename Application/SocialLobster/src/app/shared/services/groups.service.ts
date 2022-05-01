import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Groups } from '../models/groups.model';
import { User } from '../models/user.model';

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

public getGroupMembers(id: number){
  return this.http.get<any[]>(`${this.baseUrl}/selectGroupMembers/${id}`)
}

public getGroupAdmin(id: number){
  return this.http.get<User[]>(`${this.baseUrl}/getGroupAdminUser/${id}`)
}
}
