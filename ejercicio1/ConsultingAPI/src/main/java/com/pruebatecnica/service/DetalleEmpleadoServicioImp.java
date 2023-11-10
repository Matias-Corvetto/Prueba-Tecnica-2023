
package com.pruebatecnica.service;

import com.pruebatecnica.entity.Chart;
import com.pruebatecnica.entity.DetalleEmpleado;
import com.pruebatecnica.repository.DetalleEmpleadoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DetalleEmpleadoServicioImp implements DetalleEmpleadoServicio {

	@Autowired
	DetalleEmpleadoDAO detalleEmpleadoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<DetalleEmpleado> obtenerTodo() {
		return (List<DetalleEmpleado>) detalleEmpleadoDAO.findAll();
	}

	@Override
	@Transactional
	public void agregar(DetalleEmpleado empleado) {
		detalleEmpleadoDAO.save(empleado);
	}

	@Override
	@Transactional(readOnly = true)
	public DetalleEmpleado obtenerPorId(Integer id) {
		return detalleEmpleadoDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminar(Integer id) {
		detalleEmpleadoDAO.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Integer> listaIdGerentes() {
		return detalleEmpleadoDAO.listaIdGerentes();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Chart> personasPorGerente() {
		return detalleEmpleadoDAO.personasPorGerente();
	}
	@Override
	@Transactional(readOnly = true)
	public List<Chart> personasPorContrato() {
		return detalleEmpleadoDAO.personasPorContrato();
	}
	@Override
	@Transactional(readOnly = true)
	public List<Chart> personasPorBanda() {
		return detalleEmpleadoDAO.personasPorBanda();
	}
}
