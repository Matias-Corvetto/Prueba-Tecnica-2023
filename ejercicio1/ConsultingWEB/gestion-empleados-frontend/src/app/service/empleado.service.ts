import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Empleado } from 'src/app/model/empleado';
import { Observable } from 'rxjs';
import { Gerenciado } from 'src/app/model/gerenciado';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

	private url: string = 'http://localhost:8080/empleados';

  constructor(private http: HttpClient) {}

	listarEmpleados():Observable<Empleado[]>{
		return this.http.get<Empleado[]>(`${this.url}`);
	}

	obtenerEmpleado(id: number):Observable<Empleado>{
		return this.http.get<Empleado>(`${this.url}/${id}`);
	}

	obtenerGerenciados(id: number):Observable<Gerenciado[]>{
		return this.http.get<Gerenciado[]>(`${this.url}/gerenciados/${id}`);
	}

	obtenerEmpleadosJoin():Observable<Gerenciado[]>{
		return this.http.get<Gerenciado[]>(`${this.url}/join`);
	}
}
