import { Component, ChangeDetectorRef } from '@angular/core';
import { EmpleadoService } from 'src/app/service/empleado.service';
import { Router } from '@angular/router';
import { DataService } from 'src/app/data.service';
import { Gerenciado } from 'src/app/model/gerenciado';
import { ChartsService } from 'src/app/service/charts.service';

@Component({
	selector: 'app-directorr',
	templateUrl: './director.component.html',
	styleUrls: ['./director.component.css']
})
export class DirectorComponent {
	empleados: Gerenciado[];
	mostrarTabla: boolean = true;
	mostrarGrafico: boolean = false;
	titulo: string;
	datosListos: boolean = false; // Variable para controlar la disponibilidad de datos

	constructor(private empleadoService: EmpleadoService, private router: Router, private dataService: DataService, public chartService: ChartsService, private changeDetectorRef: ChangeDetectorRef) { }

	ngOnInit(): void {
		this.empleadoService.obtenerEmpleadosJoin().subscribe(
			(data: Gerenciado[]) => {
				this.empleados = data;
			}
		);
	}

	onRowClick(id: number) {
		this.dataService.setIdEmpleado(id);
		this.router.navigate([`planilla/${id}}`]);
	}

	mostrarTablaE() {
		this.mostrarTabla = true;
		this.mostrarGrafico = false;
	}

	mostrarGerentesGf() {
		this.chartService.obtenerPersonasPorGerente().subscribe(
			(data: any) => {
				this.dataService.setData(data);
				this.dataService.setTituloX('Id Gerente');
				this.dataService.setTituloY('Cantidad');

				this.datosListos = true;
			}
		);

		this.titulo = 'Cantidad de Empleados por Gerente';
		this.mostrarTabla = false;
		this.mostrarGrafico = true;
		this.datosListos = false;
	}

	mostrarContratosGf() {
		this.chartService.obtenerPersonasPorContrato().subscribe(
			(data: any) => {
				this.dataService.setData(data);
				this.dataService.setTituloX('Contrato');
				this.dataService.setTituloY('Cantidad');

				this.datosListos = true;
			}
		);

		this.titulo = 'Cantidad de Empleados por Contrato';
		this.mostrarTabla = false;
		this.mostrarGrafico = true;
		this.datosListos = false;
	}

	mostrarBandaGf() {
		this.chartService.obtenerPersonasPorBanda().subscribe(
			(data: any) => {
				this.dataService.setData(data);
				this.dataService.setTituloX('Banda');
				this.dataService.setTituloY('Cantidad');

				this.datosListos = true;
			}
		);

		this.titulo = 'Cantidad de Empleados por Banda';
		this.mostrarTabla = false;
		this.mostrarGrafico = true;
		this.datosListos = false;
	}
}
