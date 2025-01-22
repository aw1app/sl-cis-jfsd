import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Product } from '../../models/product';
import { CommonModule } from '@angular/common';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'add-product',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './add-product.component.html',
  styleUrl: './add-product.component.css'
})
export class AddProductComponent {

  productForm!: FormGroup;
  productService!:ProductService;

  constructor(private fb: FormBuilder, productService:ProductService) {
    this.productService=productService;
    //Add Product Form
    this.createAddForm(fb);
  }


  createAddForm(fb: FormBuilder): void {
    this.productForm = this.fb.group(

      {
        productName: ['', [Validators.required, Validators.minLength(3)]],
        productPrice: ['', [Validators.required, Validators.pattern(/^\d+(\.\d{1,2})?$/), Validators.max(100000)]],
        inStock: [true]
      }

    );
  }

  getRandomInt(min: number, max: number) {
    const minCeiled = Math.ceil(min);
    const maxFloored = Math.floor(max);
    return Math.floor(Math.random() * (maxFloored - minCeiled) + minCeiled); // The maximum is exclusive and the minimum is inclusive
  }

  // addProduct(): void {
  //   if (this.productForm.valid) {
  //     console.log("Inside AddProduct Component addProduct() ");

  //     let name = this.productForm.get('productName')?.value;
  //     let price = this.productForm.get('productPrice')?.value;
  //     let inStock = this.productForm.get('inStock')?.value;

  //     let id = this.getRandomInt(1000, 10000);

  //     let tempProduct = new Product(id, name, price, '', inStock, '', 100);

  //     console.log(tempProduct);

  //     this.productService.addProduct(tempProduct); // Using the product service
  //   } else {
  //     console.log("Add product failed!")
  //   }
  // }


  addProduct(): void {
    if (this.productForm.valid) {
      console.log("Inside AddProduct Component addProduct() ");

      let name = this.productForm.get('productName')?.value;
      let price = this.productForm.get('productPrice')?.value;
      let inStock = this.productForm.get('inStock')?.value;

      let id = this.getRandomInt(1000, 10000);

      let tempProduct = new Product(id, name, price, '', inStock, '', 100);

      console.log(tempProduct);

      // Using the product service
      this.productService.addProduct(tempProduct).subscribe(
        (newProd) => console.log("Added a new product successfully! ", newProd.id)
      ); 


    } else {
      console.log("Add product failed!")
    }
  }

  

}
