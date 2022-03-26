import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = 'http://localhost:8081/api/user';

  constructor(private http: HttpClient) { }

  public getAll(): Observable<any>{
    return this.http.get<User[]>(`${this.baseUrl}/select`)
}
}
