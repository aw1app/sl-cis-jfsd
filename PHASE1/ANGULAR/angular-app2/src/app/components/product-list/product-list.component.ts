import { Component } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Product } from '../../models/product';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

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

  constructor(productService:ProductService, private router: Router){
    this.productService = productService;
  }

  ngOnInit():void {
    // this.products = this.productService.getAllProducts();

    this.productService.getAllProducts().subscribe(
      (response) => { this.products = response }
    );

  }

  show(id:number):void{    
      this.router.navigate(['details', id]); 
  }

  delete(id:number):void{
    console.log("INSIDE P LIST delete ", id);
    this.productService.deleteProduct(id+"");
  }

}
