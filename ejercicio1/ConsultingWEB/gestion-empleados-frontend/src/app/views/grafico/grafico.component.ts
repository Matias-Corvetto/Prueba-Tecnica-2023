import { Component } from '@angular/core';
import { Chart } from 'src/app/model/chart';
import { DataService } from 'src/app/data.service';

@Component({
	selector: 'app-grafico',
	templateUrl: './grafico.component.html',
	styleUrls: ['./grafico.component.css']
})
export class GraficoComponent {
	view: [number, number] = [800, 400];

	yAxisLabel: string;
	xAxisLabel: string;
	showXAxis = true;
	showYAxis = true;
	gradient = false;
	showLegend = false;
	showXAxisLabel = true;
	showYAxisLabel = true;

	constructor( public dataService: DataService) { }

	single: Chart[] = [];

	ngOnInit() {
		this.single = this.dataService.getData();
		this.xAxisLabel = this.dataService.getTituloX();
		this.yAxisLabel = this.dataService.getTituloY();
	}

}
