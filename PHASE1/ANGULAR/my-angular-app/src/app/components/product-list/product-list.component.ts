import { Component } from '@angular/core';
import { Product } from '../../models/product';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'product-list',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './product-list.component.html',
  // template:'<p>Hi</p>',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent {

  colOfTableTittle: string = "red";

  isFont40: boolean = true;
  isFont80: boolean = false;

  products!: Product[];
  //cart!:Cart;

  constructor(private fb: FormBuilder) {
    //console.log("Hi");
    this.products = [];
    this.products.push(new Product(1, "HP Laptop", 20000, "Gaming Laptop", true, "IMAGES/hp-laptop.jpg"));
    this.products.push(new Product(2, "Samsumg Laptop", 40000, "Gaming Laptop", false, "IMAGES\hp.jpg"));
    this.products.push(new Product(3, "Lenova Laptop", 20500, "Gaming Laptop", true, "IMAGES\hp.jpg"));
    this.products.push(new Product(3, "Sony Laptop", 22000, "Gaming Laptop", true, "IMAGES\hp.jpg"));
   
    //Add Product Form
    this.createAddForm(fb);
  }

  submitBid(product: Product) {
    alert(`Your bid of ₹${product.bidAmount} has been placed for ${product.name}.`);
    product.bidAmount = 0; // Reset the bid field after submission
  }

  removeProduct(prod: Product): void {
    alert("Product " + prod.name + " will be removed!");
    //this.products.find();
  }

  addToCart(prod: Product): void {
    alert("Product " + prod.name + " will be added to cart!");
    //this.cart.add(prod);
  }


  popOffProduct(): void {
    this.products.pop();
  }


  //// Add a Product
  productForm!: FormGroup;
  createAddForm(fb: FormBuilder): void {
    this.productForm = this.fb.group(

      {
        productName: ['', [Validators.required, Validators.minLength(3)]],
        productPrice: ['', [Validators.required, Validators.pattern(/^\d+(\.\d{1,2})?$/), Validators.max(100000)]]
      }

    );
  }

  getRandomInt(min: number, max: number) {
    const minCeiled = Math.ceil(min);
    const maxFloored = Math.floor(max);
    return Math.floor(Math.random() * (maxFloored - minCeiled) + minCeiled); // The maximum is exclusive and the minimum is inclusive
  }

  addProduct(): void {
    if (this.productForm.valid) {
      let name = this.productForm.get('productName')?.value;
      let price = this.productForm.get('productPrice')?.value;

      let id = this.getRandomInt(1000, 10000);

      let tempProduct = new Product(id, name, price, '', true, '', 100);
      this.products.push(tempProduct);
    } else {
      console.log("Add product failed!")
    }
  }
}
