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
}}
