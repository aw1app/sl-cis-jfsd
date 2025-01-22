import { Component } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Product } from '../../models/product';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'product-list',
  standalone: true,
  imports: [CommonModule],
  providers:[ProductService],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent {

  products!: Product[];

  productService!:ProductService;

  constructor(productService:ProductService){
    this.productService = productService;
  }

  ngOnInit():void {
    // this.products = this.productService.getAllProducts();

    this.productService.getAllProducts().subscribe(

      (response) => { this.products = response }
    );

  }

  

}
