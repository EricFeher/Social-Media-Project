import { Component, OnInit } from '@angular/core';
import { SchoolService } from 'src/app/services/school.service';

@Component({
  selector: 'app-school-list',
  templateUrl: './school.component.html',
  styleUrls: ['./school.component.scss']
})
export class SchoolComponent implements OnInit {

  schools: any[];
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

}