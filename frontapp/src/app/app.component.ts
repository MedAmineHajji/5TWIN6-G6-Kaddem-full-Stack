import { Component, OnInit } from '@angular/core';
import { DataService } from './data.service';



export interface Student {
  idEtudiant: number;
  prenomE: string;
  nomE: string;
  op : string;
  // other properties if present
}
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'frontapp';
  studentsData: Student[] = [];

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.dataService.getData().subscribe(
      (data: Student[]) => {
        this.studentsData = data;
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    )
  }

}
