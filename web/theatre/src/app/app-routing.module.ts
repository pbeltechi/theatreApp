import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {ReserveComponent} from "./reserve/reserve.component";
import {AdminComponent} from "./admin/admin.component";


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'reserve',
    component: ReserveComponent
  }
  ,
  {
    path: 'admin',
    component: AdminComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
