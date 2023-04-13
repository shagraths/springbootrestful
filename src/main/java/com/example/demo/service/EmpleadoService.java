package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Empleado;

public interface EmpleadoService {
	Empleado guardarEmpleado(Empleado empleado);

	List<Empleado> traerEmpleados();

	Empleado traerEmpleadoPorId(long id);

	Empleado actualizarEmpleadoPorId(Empleado empleado, long id);

	void eliminarEmpleado(long id);
}
