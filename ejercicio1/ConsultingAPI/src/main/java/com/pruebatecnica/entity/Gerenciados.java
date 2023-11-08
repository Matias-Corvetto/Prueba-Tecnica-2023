package com.pruebatecnica.entity;

import lombok.Data;

@Data
public class Gerenciados {

	private int id;
	private String NombreCompleto;
	private String email;
	private String banda;
	private String subBanda;
	private Integer salario;
	private Double PMR;

	public Gerenciados(int id, String nombreCompleto, String email, String banda, String subBanda, Integer salario,
			Double pmr) {
		this.id = id;
		this.NombreCompleto = nombreCompleto;
		this.email = email;
		this.banda = banda;
		this.subBanda = subBanda;
		this.salario = salario;
		this.PMR = pmr;
	}
}
