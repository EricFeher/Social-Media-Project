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
}}
