import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DetalleEmpleadoService } from 'src/app/service/detalleEmpleado.service';
import { DataService } from 'src/app/data.service';

@Component({
	selector: 'app-inicio',
	templateUrl: './inicio.component.html',
	styleUrls: ['./inicio.component.css']
})
export class InicioComponent {

	botonGerente = true;
	botonDirector = false;
	idGerente: string = '';
	usuario: string = '';
	contrasena: string = '';
	idGerentes: number[] = [];

	constructor(private router: Router, private detalleEmpleadoService: DetalleEmpleadoService, private dataService: DataService) { }

	ngOnInit(): void {
		this.detalleEmpleadoService.obtenerIdGerentes().subscribe((idGerentes: number[]) => {
			this.idGerentes = idGerentes;
		});
	}

	autenticar(usuario: string, contrasena: string) {
		if ((usuario === 'director' && contrasena === 'director')||(usuario === '694651' && contrasena === '694651')) {
			this.router.navigate(['/director']);
		} else {
			alert('Credenciales incorrectas');
			this.usuario = '';
			this.contrasena = '';
		}
	}

	alternarBotones(rol: string) {
		if (rol === 'director') {
			this.botonDirector = true;
			this.botonGerente = false;
		} else if (rol === 'gerente') {
			this.botonGerente = true;
			this.botonDirector = false;
		}
	}

	realizarChequeo(id: string) {
		let num = parseInt(id);
		if (this.idGerentes.includes(num) === false) {
			alert('El id ingresado no corresponde a un gerente');
			this.idGerente = '';
		} else {
			this.router.navigate([`/gerente/${num}`]);
			this.dataService.setIdGerente(num);
		}
	}

}
