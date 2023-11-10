package com.pruebatecnica.repository;

import com.pruebatecnica.entity.Empleado;
import com.pruebatecnica.entity.Gerenciados;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmpleadoDAO extends CrudRepository<Empleado, Integer> {
	// @Query("SELECT new com.pruebatecnica.entity.Gerenciados(de.employeeIdDetalle, de.fullName, " + 
	// "de.emailPrimaryWork, de.compensationGrade, de.compensationGradeProfile, e.MonthlyReferenceSalary, e.CompaRatio) " + 
	// "FROM Empleado e JOIN e.detalleEmpleado de WHERE de.managerEmployeeId = :id")
	// List<Gerenciados> listaGerenciadosJoin(@Param("id") Integer id);

   @Query(
    "SELECT new com.pruebatecnica.entity.Gerenciados(de.employeeId, de.fullName, de.emailPrimaryWork, " +
    		   "de.compensationGrade, de.compensationGradeProfile, e.monthlyReferenceSalary, e.compaRatio) " +
    "FROM Empleado e JOIN e.detalleEmpleado de " +
    "WHERE de.managerEmployeeId = :id"
	)
	List<Gerenciados> listaGerenciadosJoin(@Param("id") Integer id);

	@Query(
    "SELECT new com.pruebatecnica.entity.Gerenciados(e.employeeID, de.fullName, de.emailPrimaryWork, " +
    		   "de.compensationGrade, de.compensationGradeProfile, e.monthlyReferenceSalary, e.compaRatio) " +
    "FROM Empleado e JOIN e.detalleEmpleado de "
	)
	List<Gerenciados> listaEmpleadosJoin();
}