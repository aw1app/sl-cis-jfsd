import { Component } from '@angular/core';
import { Product } from '../../models/product';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'product-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './product-list.component.html',
  // template:'<p>Hi</p>',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent {

  products!:Product[];

  constructor(){
    console.log("Hi");
    this.products= [];
    this.products.push(new Product(1, "HP Laptop",20000, "Gaming Laptop",true,"IMAGES/hp-laptop.jpg"));
    this.products.push(new Product(2, "Samsumg Laptop",40000, "Gaming Laptop",false,"IMAGES\hp.jpg"));
    this.products.push(new Product(3, "Lenova Laptop",20500, "Gaming Laptop",true,"IMAGES\hp.jpg"));
    this.products.push(new Product(3, "Sony Laptop",22000, "Gaming Laptop",true,"IMAGES\hp.jpg"));
  }

  removeProduct(prod:Product):void{
    alert("Product " + prod.name + " will be removed!");
    //this.products.find();
  }


  popOffProduct():void{
    this.products.pop();
  }
  
}
