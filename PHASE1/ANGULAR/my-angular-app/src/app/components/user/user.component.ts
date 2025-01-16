import { Component } from '@angular/core';
import { User } from '../../models/user';

@Component({
  selector: 'user',
  standalone: true,
  imports: [],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {

  // name:string = "Tabrez";
  // age:number = 44;

  user:User = new User("Shalini", 50, "Mumbai");

}

//Challenge: Develop a Login component
