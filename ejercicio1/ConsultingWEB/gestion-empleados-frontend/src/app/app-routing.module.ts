import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GerenteComponent } from './views/gerente/gerente.component';
import { InicioComponent } from './views/inicio/inicio.component';
import { PlanillaComponent } from './views/planilla/planilla.component';
import { DirectorComponent } from './views/director/director.component';


const routes: Routes = [
	{ path: 'inicio', component: InicioComponent },
	{ path: 'gerente', component: GerenteComponent },
	{ path: 'gerente/:id', component: GerenteComponent },
	{ path: 'planilla', component: PlanillaComponent },
	{ path: 'planilla/:id', component: GerenteComponent },
	{ path: 'director', component: DirectorComponent },
	{ path: '**', redirectTo: '/inicio', pathMatch: 'full' }
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule {
}
