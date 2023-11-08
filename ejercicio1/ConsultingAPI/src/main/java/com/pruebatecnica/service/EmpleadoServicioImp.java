
package com.pruebatecnica.service;

import com.pruebatecnica.entity.Empleado;
import com.pruebatecnica.entity.Gerenciados;
import com.pruebatecnica.repository.EmpleadoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class EmpleadoServicioImp implements EmpleadoServicio {

	@Autowired
	EmpleadoDAO empleadoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> obtenerTodo() {
		return (List<Empleado>) empleadoDAO.findAll();
	}

	@Override
	@Transactional
	public void agregar(Empleado empleado) {
		empleadoDAO.save(empleado);
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado obtenerPorId(Integer id) {
		return empleadoDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminar(Integer id) {
		empleadoDAO.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Gerenciados> listaGerenciadosJoin(@PathVariable int id) {
		return empleadoDAO.listaGerenciadosJoin(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Gerenciados> listaEmpleadosJoin() {
		return empleadoDAO.listaEmpleadosJoin();
	}
}
