import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Location } from 'src/app/shared/models/location.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  private baseUrl = 'http://localhost:8081/api/location';

  constructor(private http: HttpClient) { }

  public getAll(): Observable<any>{
    return this.http.get<Location[]>(`${this.baseUrl}/select`)
}

  public sendLocationFromRemote(location: Location):Observable<any>{
  return this.http.post<any>(`${this.baseUrl}/save`, location);
}
public deleteStudent(id: number): void {
  this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' }).subscribe();
}

  updateLocation(location: Location) {
    this.http.post<any>(`${this.baseUrl}/update/${location.id}`, location).subscribe();
  }
}
