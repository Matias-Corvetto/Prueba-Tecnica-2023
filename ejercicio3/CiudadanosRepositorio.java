//package com.pruebatecnica.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import com.pruebatecnica.entity.Ciudadanos;

import java.util.List;

public interface CiudadanosRepository extends CrudRepository<Ciudadanos, Integer> {

    @Query("SELECT * FROM Ciudadanos c WHERE (c.nombre LIKE 'Ped%' OR c.nombre LIKE 'San%') AND LENGTH(c.apellido) < 15")
    List<Ciudadanos> obtenerCiudadanosPorNombreYLargoApellido();

}


// SELECT * FROM Ciudadanos WHERE (Nombre LIKE 'Ped%' OR Nombre LIKE 'San%') AND LENGTH(Apellido) < 15;
