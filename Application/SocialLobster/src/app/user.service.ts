import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { User } from "./shared/models/user.model";

@Injectable({
    providedIn: 'root'
})
export class UserService{
    private apiServerUrl = '';

    constructor(private http: HttpClient){
        this.apiServerUrl = 'http:localhost:8080/api'
     }

    public getUser(): Observable<any>{
        return this.http.get<any>(`${this.apiServerUrl}/user/all`)
    }
}
