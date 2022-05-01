import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Comments } from '../models/comments.model';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class CommentsService {

  private baseUrl = 'http://localhost:8081/api/comments';

  constructor(private http: HttpClient) { }

  public getAll(): Observable<any>{
    return this.http.get<Comments[]>(`${this.baseUrl}/select`)
}

public sendCommentFromRemote(comment: Comments):Observable<any>{
  return this.http.post<any>(`${this.baseUrl}/save`, comment);
}



public deleteStudent(id: number): void {
  console.log(id);
  console.log(`${this.baseUrl}/delete/${id}`);
  this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' }).subscribe();
}

public updateComment(comment: Comments){
  this.http.post<any>(`${this.baseUrl}/update/${comment.id}`, comment).subscribe();
}

public selectComments(id: number){
  return this.http.get<any>(`${this.baseUrl}/getCommentsFromPost/${id}`)
}

public selectUserForComments(id: number){
  return this.http.get<User[]>(`${this.baseUrl}/getUserForComment/${id}`)
}

}
