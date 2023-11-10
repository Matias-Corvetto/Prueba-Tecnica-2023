//package com.pruebatecnica.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import com.pruebatecnica.entity.Ciudadanos;

import java.util.List;

public interface CiudadanosRepository extends CrudRepository<Ciudadanos, Integer> {

	@Query("SELECT c FROM Ciudadanos c WHERE NOT EXISTS " +
			"(SELECT 1 FROM Ciudadanos c2 WHERE c.nombre = c2.nombre AND c.id != c2.id) " +
			"ORDER BY c.nombre ASC")
	List<Ciudadanos> obtenerNombresUnicosOrdenados();

}

// 	SELECT c.Nombre, c.id FROM prueba.ciudadanos c WHERE NOT EXISTS (
//		 	SELECT 1
// 		FROM prueba.ciudadanos c2
// 		WHERE c.Nombre = c2.Nombre AND c.Id != c2.Id
// 	)
// 	ORDER BY c.Nombre ASC;
