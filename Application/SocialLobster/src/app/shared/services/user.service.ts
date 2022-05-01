import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = 'http://localhost:8081/api/user';
  private followUrl = 'http://localhost:8081/api/follows';

  constructor(private http: HttpClient) { }

  public getAll(): Observable<any>{
    return this.http.get<User[]>(`${this.baseUrl}/select`)
  }

  public sendUserFromRemote(user: User):Observable<any>{
    return this.http.post<any>(`${this.baseUrl}/save`, user);
  }

  public getOneById(id: number): Observable<any>{
    return this.http.get<User>(`${this.baseUrl}/select/${id}`)
  }
  public deleteStudent(id: number): void {
    this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' }).subscribe();
  }

  public updateStudent(user: User):void{
      this.http.post<any>(`${this.baseUrl}/update/${user.id}`, user).subscribe();
  }

  public getFollows(id: number){
    return this.http.get<any[]>(`${this.followUrl}/getFollowsByUserId1/${id}`)
  }

  public getFollowers(id: number){
    return this.http.get<any[]>(`${this.followUrl}/getFollowsByUserId2/${id}`)
  }

}
