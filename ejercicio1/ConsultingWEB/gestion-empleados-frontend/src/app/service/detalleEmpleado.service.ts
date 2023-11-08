import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DetalleEmpleado } from 'src/app/model/detalleEmpleado';
import { Observable, map } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class DetalleEmpleadoService {

	private url: string = 'http://localhost:8080/detalleEmpleados';

	constructor(private http: HttpClient) { }

	listarDetallesEmpleados(): Observable<DetalleEmpleado[]> {
		return this.http.get<DetalleEmpleado[]>(`${this.url}`);
	}

	obtenerIdGerentes(): Observable<number[]> {
		return this.http.get<number[]>(`${this.url}/idGerentes`)
	}

	obtenerDetalleEmpleado(id: number):Observable<DetalleEmpleado>{
		return this.http.get<DetalleEmpleado>(`${this.url}/${id}`);
	}
}
