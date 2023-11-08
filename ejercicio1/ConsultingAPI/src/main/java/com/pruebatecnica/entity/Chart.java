package com.pruebatecnica.entity;

import lombok.Data;

@Data
public class Chart {
	private String name;
	private Long value;

	Chart(Integer name, Long value) {
		this.name = name.toString();
		this.value = value;
	}

	Chart(String name, Long value) {
		this.name = name;
		this.value = value;
	}
}
