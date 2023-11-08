import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { Chart } from 'src/app/model/chart';

@Injectable({
	providedIn: 'root'
})
export class ChartsService {
	private url: string = 'http://localhost:8080';

	constructor(private http: HttpClient) { }

	obtenerPersonasPorGerente(): Observable<Chart[]> {
		return this.http.get<Chart[]>(`${this.url}/personasPorGerente`)
	}

	obtenerPersonasPorContrato(): Observable<Chart[]> {
		return this.http.get<Chart[]>(`${this.url}/personasPorContrato`)
	}

	obtenerPersonasPorBanda(): Observable<Chart[]> {
		return this.http.get<Chart[]>(`${this.url}/personasPorBanda`)
	}

}
