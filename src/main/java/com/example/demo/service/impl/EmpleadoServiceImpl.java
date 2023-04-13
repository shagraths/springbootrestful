package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Empleado;
import com.example.demo.repository.EmpleadoRepository;
import com.example.demo.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	private EmpleadoRepository empleadoRepository;

	@Autowired
	public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
		super();
		this.empleadoRepository = empleadoRepository;
	}

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	@Override
	public List<Empleado> traerEmpleados() {
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado traerEmpleadoPorId(long id) {
		/*
		 * Optional<Empleado> empleOptional = empleadoRepository.findById(id); if
		 * (empleOptional.isPresent()) { return empleOptional.get(); } else { throw new
		 * ResourceNotFoundException("Empleado", "id", id); }
		 */
		return empleadoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", id));
	}

	@Override
	public Empleado actualizarEmpleadoPorId(Empleado empleado, long id) {
		// necesitamos saber si existe el empleado en la base de datos
		Empleado existeEmpleado = empleadoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", id));

		existeEmpleado.setNombres(empleado.getNombres());
		existeEmpleado.setApellidos(empleado.getApellidos());
		existeEmpleado.setEmail(empleado.getEmail());
		// guardamos el empleado con los datos actualizados
		empleadoRepository.save(existeEmpleado);
		return existeEmpleado;
	}

	@Override
	public void eliminarEmpleado(long id) {
		// necesitamos saber si existe el empleado antes de eliminarlo
		Empleado existeEmpleado = empleadoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", id));
		empleadoRepository.deleteById(id);
	}
}
