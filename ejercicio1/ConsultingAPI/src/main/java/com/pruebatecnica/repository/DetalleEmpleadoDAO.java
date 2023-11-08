package com.pruebatecnica.repository;

import com.pruebatecnica.entity.Chart;
import com.pruebatecnica.entity.DetalleEmpleado;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DetalleEmpleadoDAO extends CrudRepository<DetalleEmpleado, Integer> {
	@Query("SELECT de.managerEmployeeId FROM DetalleEmpleado de GROUP BY managerEmployeeId")
	List<Integer> listaIdGerentes();

	@Query(
    "SELECT new com.pruebatecnica.entity.Chart(de.managerEmployeeId, COUNT(de.managerEmployeeId)) " +
       "FROM DetalleEmpleado de " + 
       "GROUP BY de.managerEmployeeId")
	List<Chart> personasPorGerente();

	@Query(
    "SELECT new com.pruebatecnica.entity.Chart(de.employeeType, COUNT(de.employeeType)) " +
       "FROM DetalleEmpleado de " + 
       "GROUP BY de.employeeType")
	List<Chart> personasPorContrato();

	@Query(
    "SELECT new com.pruebatecnica.entity.Chart(de.compensationGrade, COUNT(de.compensationGrade)) " +
       "FROM DetalleEmpleado de " + 
       "GROUP BY de.compensationGrade")
	List<Chart> personasPorBanda();
}