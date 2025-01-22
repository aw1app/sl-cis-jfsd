import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { AddProductComponent } from './components/add-product/add-product.component';
import { NoSuchComponent } from './components/no-such/no-such.component';

export const routes: Routes = [

    { path: '', component: AppComponent },
    { path: 'list', component: ProductListComponent },
    { path: 'add', component: AddProductComponent },

    { path: '**', component: NoSuchComponent },
];
