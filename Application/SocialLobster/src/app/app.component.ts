import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { User } from './shared/models/user.model';
import { UserService } from './user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'SocialLobster';
  public user: User[];

  constructor(private userService: UserService){}

  public getUsers(): void{
    this.userService.getUser().subscribe(
      (response: User[]) => {
        this.user = response;
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }

    )

  }
}
