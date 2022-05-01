import { Component, OnInit } from '@angular/core';
import { School } from 'src/app/shared/models/school.model';
import { SchoolService } from 'src/app/shared/services/school.service';
import {Comments} from "../../../../shared/models/comments.model";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-school-list',
  templateUrl: './school.component.html',
  styleUrls: ['./school.component.scss']
})
export class SchoolComponent implements OnInit {

  schools: any[];
  school = new School();
  msg='';
  constructor(private schoolService: SchoolService) { }

  ngOnInit(): void {
    this.retrieveSchools();
  }

  retrieveSchools(): void{
    this.schoolService.getAll()
    .subscribe(
      data => {
        console.log(data);
        this.schools = data;
      }
    );
  }

  sendSchool(): void{
    this.schoolService.sendSchoolFromRemote(this.school).subscribe(
    )
    window.location.reload();
  }
  onDelete(number: number): void{
    this.schoolService.deleteStudent(number);
    window.location.reload();
  }


  user2 = new School();

  userupdateform=new FormGroup({
    id:new FormControl(),
    school_type:new FormControl(),
    name:new FormControl(),
    location_id:new FormControl()
  });


  changeisUpdate() {
    this.user2=new School();
    this.user2.id=this.userupdateform.get('id')?.value
    this.user2.school_type=this.userupdateform.get('school_type')?.value
    this.user2.name=this.userupdateform.get('name')?.value
    this.user2.location_id=this.userupdateform.get('location_id')?.value
    this.schoolService.updateSchool(this.user2);
    console.log("lefute")
  }

  updateUser(user: School) {
    this.user2=user;
  }
}
