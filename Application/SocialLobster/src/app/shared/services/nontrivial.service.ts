import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Location } from 'src/app/shared/models/location.model';
import { UserData } from '../models/userdata.model';
import { usernamebyfollowercount } from '../models/usernamebyfollowercount';

@Injectable({
  providedIn: 'root'
})
export class NontrivialService {

  private baseUrl = 'http://localhost:8081/api/nontrivial';
  private locationUrl='http://localhost:8081/api/location';
  private userUrl='http://localhost:8081/api/userdata';

  constructor(private http: HttpClient) { }

  public getAll(): Observable<any>{
    return this.http.get<usernamebyfollowercount[]>(`${this.baseUrl}/select/usernamebyfollowercount`)
}

  public getSchoolLocation() {
    return this.http.get<Location[]>(`${this.locationUrl}/getLocationForSchool`)
  }
  
  public getUserWhere3Followers() {
    return this.http.get<UserData[]>(`${this.userUrl}/selectUsersWhereFollower`)
  }


}
