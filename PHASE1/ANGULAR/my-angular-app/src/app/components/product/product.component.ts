import { Component, Input } from '@angular/core';
import { Product } from '../../models/product';

@Component({
  selector: 'product',
  standalone: true,
  imports: [],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
// export class ProductComponent {

//   product: Product = new Product(1, "HP Laptop",20000, "Gaming Laptop",true,"IMAGES\hp.jpg");
// }

export class ProductComponent {
  @Input("name") name!:string;
  @Input("description") description!:string;
  @Input("price") price!:number;
  @Input("inStock") inStock!:boolean;

  
  product!: Product;

  // constructor(){

  // }

  // Life Cycle method
  ngOnInit():void{
    this.product = new Product(1, this.name, this.price, this.description, this.inStock);
  }

}
