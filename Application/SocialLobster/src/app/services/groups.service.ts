import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GroupsService {

  private baseUrl = 'http://localhost:8081/api/groups';

  constructor(private http: HttpClient) { }

  public getAll(): Observable<any>{
    return this.http.get<Groups[]>(`${this.baseUrl}/select`)
}}
