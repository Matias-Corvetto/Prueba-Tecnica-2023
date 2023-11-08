import { Component } from '@angular/core';
import { EmpleadoService } from 'src/app/service/empleado.service';
import { DetalleEmpleadoService } from 'src/app/service/detalleEmpleado.service';
import { DataService } from 'src/app/data.service';
import { EmpleadoInterfaz } from 'src/app/interface/empleado.interface';
import { DetalleEmpleadoInterfaz } from 'src/app/interface/detalleEmpleado.interface';
import { Location } from '@angular/common'

@Component({
	selector: 'app-planilla',
	templateUrl: './planilla.component.html',
	styleUrls: ['./planilla.component.css']
})
export class PlanillaComponent {
	empleadoElegido: EmpleadoInterfaz = {} as EmpleadoInterfaz;
	empleadoElegidoDetalle: DetalleEmpleadoInterfaz = {} as DetalleEmpleadoInterfaz;
	idEmpleado: number;

	constructor(
		private empleadoService: EmpleadoService,
		private detalleEmpleadoService: DetalleEmpleadoService,
		private dataService: DataService,
		private location: Location
	) { }

	ngOnInit(): void {
		this.idEmpleado = this.dataService.getIdEmpleado();

		this.empleadoService.obtenerEmpleado(this.idEmpleado).subscribe((empleado: EmpleadoInterfaz) => {
			this.empleadoElegido = empleado;
		});

		this.detalleEmpleadoService.obtenerDetalleEmpleado(this.idEmpleado).subscribe((detalle: DetalleEmpleadoInterfaz) => {
			this.empleadoElegidoDetalle = detalle;
		});
	}

	getKeys(obj: any): string[] {
		return Object.keys(obj);
	}

	volverARutaAnterior() {
		this.location.back();
	}
}
