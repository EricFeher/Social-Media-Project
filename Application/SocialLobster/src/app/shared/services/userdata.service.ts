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

}
