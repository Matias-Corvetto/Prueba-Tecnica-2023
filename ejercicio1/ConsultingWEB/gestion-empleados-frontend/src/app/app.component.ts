import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent {
	title = 'Sistema de gestión de empleados';

	constructor(private route: ActivatedRoute, private router: Router) { }

	esRutaInicio(): boolean {
		return this.router.url === '/inicio';
	}

	esRutaGerente(): boolean {
		const regex = /\/gerente\//;
		return regex.test(this.router.url);
	}

	esRutaPlanilla(): boolean {
		const regex = /\/planilla\//;
		return regex.test(this.router.url);
	}

	esRutaDirector(): boolean {
		const regex = /\/director/;
		return regex.test(this.router.url);
	}
}
