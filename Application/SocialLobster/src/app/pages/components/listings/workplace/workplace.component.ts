import { Component, OnInit } from '@angular/core';
import { Workplace } from 'src/app/shared/models/workplace.model';
import { WorkplaceService } from 'src/app/shared/services/workplace.service';
import {Comments} from "../../../../shared/models/comments.model";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-workplace-list',
  templateUrl: './workplace.component.html',
  styleUrls: ['./workplace.component.scss']
})
export class WorkplaceComponent implements OnInit {


  workplaces = new Workplace();
  workplace: any[];
  constructor(private workplaceService: WorkplaceService) { }

  ngOnInit(): void {
    this.retrieveUserData();
  }

  retrieveUserData(): void{
    this.workplaceService.getAll()
    .subscribe(
      data => {
        console.log(data);
        this.workplace = data;
      }
    );
  }

  sendWorkplace(): void{
    this.workplaceService.sendWorkplaceFromRemote(this.workplaces).subscribe(
    )
    window.location.reload();
  }
  onDelete(number: number): void{
    this.workplaceService.deleteStudent(number);
    window.location.reload();
  }


  user2 = new Workplace();

  userupdateform=new FormGroup({
    id:new FormControl(),
    location_id:new FormControl(),
    workplace_type:new FormControl(),
    name:new FormControl(),
  });


  changeisUpdate() {
    this.user2=new Workplace();
    this.user2.id=this.userupdateform.get('id')?.value
    this.user2.location_id=this.userupdateform.get('location_id')?.value
    this.user2.workplace_type=this.userupdateform.get('workplace_type')?.value
    this.user2.name=this.userupdateform.get('name')?.value
    this.workplaceService.updateWorkplace(this.user2);
    console.log("lefute")
  }

  updateUser(user: Workplace) {
    this.user2=user;
  }

}
