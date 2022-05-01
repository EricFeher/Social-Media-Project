import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from '../models/post.model';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private baseUrl = 'http://localhost:8081/api/post';

  constructor(private http: HttpClient) { }

  public getAll(): Observable<any>{
    return this.http.get<Post[]>(`${this.baseUrl}/select`)
}

public sendPostFromRemote(post: Post):Observable<any>{
  return this.http.post<any>(`${this.baseUrl}/save`, post);
}
public deleteStudent(id: number): void {
  this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' }).subscribe();
}

  updatePost(post: Post) {
    this.http.post<any>(`${this.baseUrl}/update/${post.id}`, post).subscribe();
  }
}
