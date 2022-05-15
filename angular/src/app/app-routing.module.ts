import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewComponent } from './new/new.component';
import { HomeComponent } from './home/home.component';
import { ListComponent } from './list/list.component';

const routes: Routes = [
	{ path: '', redirectTo: 'home', pathMatch: 'full' },
	{ path: 'home', component: HomeComponent, data: { title: 'Home Bank Transfer Schedule' } },
	{ path: 'new', component: NewComponent, data: { title: 'Schedule new wire transfer' } },
	{ path: 'list', component: ListComponent, data: { title: 'List all scheduled transactions' } },
];

@NgModule({
	imports: [RouterModule.forRoot(routes, {
    initialNavigation: 'enabledBlocking',
	useHash: true
})],
	exports: [RouterModule]
})
export class AppRoutingModule { }
