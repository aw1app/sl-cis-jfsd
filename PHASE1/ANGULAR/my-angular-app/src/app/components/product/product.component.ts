import { Component } from '@angular/core';
import { Product } from '../../models/product';

@Component({
  selector: 'product',
  standalone: true,
  imports: [],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent {

  product: Product = new Product(1, "HP Laptop",20000, "Gaming Laptop",true,"IMAGES\hp.jpg");
}
