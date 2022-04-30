import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Photos } from '../models/photos.model';

@Injectable({
  providedIn: 'root'
})
export class PhotosService {

  private baseUrl = 'http://localhost:8081/api/photos';

  constructor(private http: HttpClient) { }

  public getAll(): Observable<any>{
    return this.http.get<Photos[]>(`${this.baseUrl}/select`)
}

public sendPhotoFromRemote(photo: Photos):Observable<any>{
  return this.http.post<any>(`${this.baseUrl}/save`, photo);
}

public deleteStudent(id: number): void { 
  this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' }).subscribe();
}  
}
