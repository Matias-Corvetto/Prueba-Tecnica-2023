import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { GerenteComponent } from './views/gerente/gerente.component';
import { HttpClientModule } from '@angular/common/http';
import { InicioComponent } from './views/inicio/inicio.component';
import { FormsModule } from '@angular/forms';
import { PlanillaComponent } from './views/planilla/planilla.component';
import { DirectorComponent } from './views/director/director.component';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { GraficoComponent } from './views/grafico/grafico.component';


@NgModule({
	declarations: [
		AppComponent,
		GerenteComponent,
		InicioComponent,
		PlanillaComponent,
		DirectorComponent,
  		GraficoComponent
	],
	imports: [
		BrowserModule,
		AppRoutingModule,
		BrowserAnimationsModule,
		FormsModule,
		HttpClientModule,
		NgxChartsModule
	],
	providers: [],
	bootstrap: [AppComponent]
})
export class AppModule { }
