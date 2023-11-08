
package com.pruebatecnica.service;

import com.pruebatecnica.entity.Chart;
import com.pruebatecnica.entity.DetalleEmpleado;
import java.util.List;

public interface DetalleEmpleadoServicio {

	public List<DetalleEmpleado> obtenerTodo();

	public void agregar(DetalleEmpleado detalleEmpleado);

	public DetalleEmpleado obtenerPorId(Integer id);

	public void eliminar(Integer id);

	public List<Integer> listaIdGerentes();

	public List<Chart> personasPorGerente();

	public List<Chart> personasPorContrato();

	public List<Chart> personasPorBanda();
}
