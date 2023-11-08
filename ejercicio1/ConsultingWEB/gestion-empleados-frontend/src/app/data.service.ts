import { Injectable } from '@angular/core';
import { Chart } from './model/chart';

@Injectable({
	providedIn: 'root'
})
export class DataService {

	private idGerente: number;
	private idEmpleado: number;
	private tituloY: string;
	private tituloX: string;
	private data: Chart[];

	setData(data: Chart[]) {
		this.data = data;
	}

	getData(): Chart[] {
		return this.data;
	}
	
	setTituloY(titulo: string) {
		this.tituloY = titulo;
	}

	getTituloY(): string {
		return this.tituloY;
	}

	setTituloX(titulo: string) {
		this.tituloX = titulo;
	}

	getTituloX(): string {
		return this.tituloX;
	}

	setIdGerente(id: number) {
		this.idGerente = id;
	}

	getIdGerente(): number {
		return this.idGerente;
	}

	setIdEmpleado(id: number) {
		this.idEmpleado = id;
	}

	getIdEmpleado(): number {
		return this.idEmpleado;
	}
}
