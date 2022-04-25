import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Comments } from '../models/comments.model';

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
}
