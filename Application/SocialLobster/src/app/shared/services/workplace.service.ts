import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Workplace } from '../models/workplace.model';

@Injectable({
  providedIn: 'root'
})
export class WorkplaceService {

  private baseUrl = 'http://localhost:8081/api/workplace';

  constructor(private http: HttpClient) { }

  public getAll(): Observable<any>{
    return this.http.get<Workplace[]>(`${this.baseUrl}/select`)
}

public sendWorkplaceFromRemote(workplace: Workplace):Observable<any>{
  return this.http.post<any>(`${this.baseUrl}/save`, workplace);
}
public deleteStudent(id: number): void {
  this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' }).subscribe();
}

  updateWorkplace(workplace: Workplace) {
    this.http.post<any>(`${this.baseUrl}/update/${workplace.id}`, workplace).subscribe();
  }
}
