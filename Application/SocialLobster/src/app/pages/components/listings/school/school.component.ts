import { Component, OnInit } from '@angular/core';
import { School } from 'src/app/shared/models/school.model';
import { SchoolService } from 'src/app/shared/services/school.service';

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

}
