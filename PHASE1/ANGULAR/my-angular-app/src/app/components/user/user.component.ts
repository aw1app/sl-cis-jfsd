import { Component } from '@angular/core';

@Component({
  selector: 'user',
  standalone: true,
  imports: [],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {

  name:string = "Tabrez";
  age:number = 44;

}

//Challenge: Develop a Login component
