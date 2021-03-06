import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Message } from '../models/message.model';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  private baseUrl = 'http://localhost:8081/api/message';

  constructor(private http: HttpClient) { }

  public getAll(): Observable<any>{
    return this.http.get<Message[]>(`${this.baseUrl}/select`)
}

public sendMessageFromRemote(message: Message):Observable<any>{
  return this.http.post<any>(`${this.baseUrl}/save`, message);
}
public deleteStudent(id: number): void {
  this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' }).subscribe();
}

  updateMessage(message: Message) {
    this.http.post<any>(`${this.baseUrl}/update/${message.id}`, message).subscribe();
  }
}
