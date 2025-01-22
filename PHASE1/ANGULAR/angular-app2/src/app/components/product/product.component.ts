import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Product } from '../../models/product';
import { ProductService } from '../../services/product.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [CommonModule],
  providers: [ProductService],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent {

  product!: Product;

  productService!: ProductService;
  route: ActivatedRoute

  constructor(productService: ProductService, route: ActivatedRoute) {
    this.productService = productService;
    this.route = route;
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {

      const id = params.get('id');

      if (id != null) {
        this.productService.getProduct(id).subscribe(
          prod => this.product = prod,
          error => console.error('Error fetching product:', error)
        )
      }

    }
    )
  }

}
