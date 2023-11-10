
package com.pruebatecnica.web;

import com.pruebatecnica.entity.Chart;
import com.pruebatecnica.entity.DetalleEmpleado;
import com.pruebatecnica.entity.Empleado;
import com.pruebatecnica.entity.Gerenciados;
import com.pruebatecnica.service.DetalleEmpleadoServicio;
import com.pruebatecnica.service.EmpleadoServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorRest {

	@Autowired
	private EmpleadoServicio empleadoServicio;

	@Autowired
	private DetalleEmpleadoServicio detalleEmpleadoServicio;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/empleados")
	public ResponseEntity<List<Empleado>> listarEmpleados() {
		List<Empleado> empleados = empleadoServicio.obtenerTodo();
		return new ResponseEntity<List<Empleado>>(empleados, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/empleados/{id}")
	public ResponseEntity<Empleado> obtenerEmpleadoPorID(@PathVariable String id) {
		int idNum = Integer.parseInt(id);
		Empleado empleado = empleadoServicio.obtenerPorId(idNum);
		return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/detalleEmpleados/{id}")
	public ResponseEntity<DetalleEmpleado> obtenerDetalleEmpleadoPorID(@PathVariable String id) {
		int idNum = Integer.parseInt(id);
		DetalleEmpleado detalleEmpleado = detalleEmpleadoServicio.obtenerPorId(idNum);
		return new ResponseEntity<DetalleEmpleado>(detalleEmpleado, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/detalleEmpleados")
	public ResponseEntity<List<DetalleEmpleado>> listarDetalleEmpleados() {
		List<DetalleEmpleado> detalleEmpleados = detalleEmpleadoServicio.obtenerTodo();
		return new ResponseEntity<List<DetalleEmpleado>>(detalleEmpleados, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/detalleEmpleados/idGerentes")
	public ResponseEntity<List<Integer>> listaIdGerentes() {
		List<Integer> listaIdGerentes = detalleEmpleadoServicio.listaIdGerentes();
		return new ResponseEntity<List<Integer>>(listaIdGerentes, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/empleados/gerenciados/{id}")
	public ResponseEntity<List<Gerenciados>> listaGerenciadosJoin(@PathVariable String id) {
		int idNum = Integer.parseInt(id);
		List<Gerenciados> listaGerenciados = empleadoServicio.listaGerenciadosJoin(idNum);
		return new ResponseEntity<List<Gerenciados>>(listaGerenciados, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/empleados/join")
	public ResponseEntity<List<Gerenciados>> listaEmpleadosJoin() {
		List<Gerenciados> listaGerenciados = empleadoServicio.listaEmpleadosJoin();
		return new ResponseEntity<List<Gerenciados>>(listaGerenciados, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/personasPorGerente")
	public ResponseEntity<List<Chart>> personasPorGerente() {
		List<Chart> lista = detalleEmpleadoServicio.personasPorGerente();
		return new ResponseEntity<List<Chart>>(lista, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/personasPorContrato")
	public ResponseEntity<List<Chart>> personasPorContrato() {
		List<Chart> lista = detalleEmpleadoServicio.personasPorContrato();
		return new ResponseEntity<List<Chart>>(lista, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/personasPorBanda")
	public ResponseEntity<List<Chart>> personasPorBanda() {
		List<Chart> lista = detalleEmpleadoServicio.personasPorBanda();
		return new ResponseEntity<List<Chart>>(lista, HttpStatus.OK);
	}
}
