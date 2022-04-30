import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { usernamebyfollowercount } from '../models/usernamebyfollowercount';

@Injectable({
  providedIn: 'root'
})
export class NontrivialService {

  private baseUrl = 'http://localhost:8081/api/nontrivial';

  constructor(private http: HttpClient) { }

  public getAll(): Observable<any>{
    return this.http.get<usernamebyfollowercount[]>(`${this.baseUrl}/select/usernamebyfollowercount`)
}


}
