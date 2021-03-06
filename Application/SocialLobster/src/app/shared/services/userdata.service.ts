import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserData } from '../models/userdata.model';

@Injectable({
  providedIn: 'root'
})
export class UserdataService {
  private baseUrl = 'http://localhost:8081/api/userdata';

  constructor(private http: HttpClient) { }

  public getAll(): Observable<any>{
    return this.http.get<UserData[]>(`${this.baseUrl}/select`)
}

public sendUserdataFromRemote(userdata: UserData):Observable<any>{
  return this.http.post<any>(`${this.baseUrl}/save`, userdata);
}
public deleteStudent(id: number): void {
  this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' }).subscribe();
}

public getOneByUserId(id: number): Observable<any>{
  return this.http.get<UserData[]>(`${this.baseUrl}/getUserDataForUser/${id}`)
}

    updateUserData(user: UserData) {
      this.http.post<any>(`${this.baseUrl}/update/${user.id}`, user).subscribe();
    }
}
