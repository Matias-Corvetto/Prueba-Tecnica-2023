
package com.pruebatecnica.service;

import com.pruebatecnica.entity.Empleado;
import com.pruebatecnica.entity.Gerenciados;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;


public interface EmpleadoServicio {
    
    public List<Empleado> obtenerTodo();
    
    public void agregar(Empleado empleado);
    
    public Empleado obtenerPorId(Integer id);
    
    public void eliminar(Integer id);

	 public List<Gerenciados> listaGerenciadosJoin(@PathVariable int id);
    
	 public List<Gerenciados> listaEmpleadosJoin();
}
