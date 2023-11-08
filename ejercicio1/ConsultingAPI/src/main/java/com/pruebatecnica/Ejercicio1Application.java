package com.pruebatecnica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pruebatecnica.tool.ExcelReader;


@SpringBootApplication
public class Ejercicio1Application {

	public static void main(String[] args) {
		ExcelReader lector = new ExcelReader();
		SpringApplication.run(Ejercicio1Application.class, args);
		lector.insertarDatos();
	}

}
