import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { AddProductComponent } from './components/add-product/add-product.component';
import { NoSuchComponent } from './components/no-such/no-such.component';
import { ProductComponent } from './components/product/product.component';

export const routes: Routes = [

    { path: '', component: AppComponent },
    { path: 'details/:id', component: ProductComponent},
    { path: 'list', component: ProductListComponent },
    { path: 'add', component: AddProductComponent },

    { path: '**', component: NoSuchComponent },
];
