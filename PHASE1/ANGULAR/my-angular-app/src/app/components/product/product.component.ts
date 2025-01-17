import { Component, EventEmitter, Input, Output } from '@angular/core';
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
  @Input("desc") description!:string;
  @Input("price") price!:number;
  @Input("inStock") inStock!:boolean;

  
  product!: Product;

  @Output() addToCart = new EventEmitter<Product>();

  // constructor(){

  // }

  onAddToCart() {
    this.addToCart.emit(this.product);
  }

  // Life Cycle method
  ngOnInit():void{
    this.product = new Product(1, this.name, this.price, this.description, this.inStock);
  }

  // ngOnChange():void{
  //   this.product = new Product(1, this.name, this.price, this.description, this.inStock);
  // }

}
