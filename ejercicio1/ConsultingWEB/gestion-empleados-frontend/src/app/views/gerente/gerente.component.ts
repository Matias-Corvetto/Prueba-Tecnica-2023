import { Component } from '@angular/core';
import { EmpleadoService } from 'src/app/service/empleado.service';
import { DetalleEmpleadoService } from 'src/app/service/detalleEmpleado.service';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from 'src/app/data.service';
import { Gerenciado } from 'src/app/model/gerenciado';


@Component({
	selector: 'app-gerente',
	templateUrl: './gerente.component.html',
	styleUrls: ['./gerente.component.css']
})
export class GerenteComponent {

	idGerente: number;
	gerenciados: Gerenciado[];

	constructor(private empleadoService: EmpleadoService, private detalleEmpleadoService: DetalleEmpleadoService,
		private router: Router, private route: ActivatedRoute, private dataService: DataService) { }

	ngOnInit(): void {
		this.idGerente = this.dataService.getIdGerente();

		this.empleadoService.obtenerGerenciados(this.idGerente).subscribe(
			(data: Gerenciado[]) => {
				this.gerenciados = data;
			}
		);
	}

	onRowClick(id: number) {
		this.dataService.setIdEmpleado(id);
		this.router.navigate([`planilla/${id}}`]);
	}
}
