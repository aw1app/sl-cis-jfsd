import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Product } from '../../models/product';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-pipesdemo',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './pipesdemo.component.html',
  styleUrl: './pipesdemo.component.css'
})
export class PipesdemoComponent {

  title = 'Angular Pipes Demo';
  today = new Date();
  price = 12345.6789;
  percentage = 0.8567;
  longText = 'This is a very long text that needs slicing for display purposes.';
  jsonData = { name: 'John', age: 30, job: 'Engineer' };
  items = ['Item 1', 'Item 2', 'Item 3', 'Item 4'];

  // For custom pipe demo
  customMessage = 'hello world!';

  asyncProducts!: Observable<Product[]>;

  productService!:ProductService;

  constructor(productService:ProductService){
    this.productService = productService;
  }

  ngOnInit():void {
    this.asyncProducts=this.productService.getAllProducts();
  }

}
