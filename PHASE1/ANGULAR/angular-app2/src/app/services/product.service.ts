import { Injectable } from '@angular/core';
import { Product } from '../models/product';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
/*
export class ProductService {

  //Shared Data
  products: Product[] = [];

  constructor() {
    this.products = [];
    this.products.push(new Product(1, "HP Laptop", 20000, "Gaming Laptop", true, "IMAGES/hp-laptop.jpg"));
    this.products.push(new Product(2, "Samsumg Laptop", 40000, "Gaming Laptop", false, "IMAGES\hp.jpg"));
    this.products.push(new Product(3, "Lenova Laptop", 20500, "Gaming Laptop", true, "IMAGES\hp.jpg"));
    this.products.push(new Product(3, "Sony Laptop", 22000, "Gaming Laptop", true, "IMAGES\hp.jpg"));
  }

  getAllProducts(): Product[] {
    return this.products;
  }

  addProduct(prod: Product): void {
    console.log("INSIDE SERVICE addProduct", prod);
    this.products.push(prod);
    console.log("INSIDE SERVICE addProduct", this.products);
  }

}
  */
export class ProductService {
  //Shared Data
  products: Product[] = [];

  apiBaseUrl: string = "http://localhost:3000/products"



  constructor(private httpClt: HttpClient) {
  }

  //CRUD methods
  getAllProducts(): Observable<Product[]> {
    return this.httpClt.get<Product[]>(this.apiBaseUrl);
  }

  getProduct(id: string) :Observable<Product>{
    return this.httpClt.get<Product>(this.apiBaseUrl+"/"+id); 
  }

  addProduct(prod: Product): Observable<Product> {
    return this.httpClt.post<Product>(this.apiBaseUrl, prod);   
  }

  //Task-for-learners : Implement delete product
  deleteProduct(id:string):Observable<void> {  
    console.log("INSIDE P SERVICE  delete ", id);
    return this.httpClt.delete<void>(this.apiBaseUrl+"/"+id);
    console.log("INSIDE P SERVICE  after delete ", id);   
  }

}
