package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Empleado;
import com.example.demo.service.EmpleadoService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/empleado")
public class empleadoController {
	private EmpleadoService empleadoService;

	public empleadoController(EmpleadoService empleadoService) {
		super();
		this.empleadoService = empleadoService;
	}

	// construir crear empleado rest api
	@PostMapping()
	public ResponseEntity<Empleado> guardarEmpleado(@RequestBody Empleado empleado) {
		return new ResponseEntity<Empleado>(empleadoService.guardarEmpleado(empleado), HttpStatus.CREATED);
	}

	// constriur traer todos los empleados rest api
	@GetMapping
	public List<Empleado> traerEmpleados() {
		return empleadoService.traerEmpleados();
	}

	// construir obtener empleado por id rest api
	// http://localhost:8080/api/empleado/1
	@GetMapping("{id}")
	public ResponseEntity<Empleado> traerEmpleadoPorId(@PathVariable("id") long empleadoId) {
		return new ResponseEntity<Empleado>(empleadoService.traerEmpleadoPorId(empleadoId), HttpStatus.OK);
	}

	// construir actualizar empleado por id rest api
	// http://localhost:8080/api/empleado/1
	@PutMapping("/{id}")
	public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable("id") long empleadoId,
			@RequestBody Empleado empleado) {
		return new ResponseEntity<Empleado>(empleadoService.actualizarEmpleadoPorId(empleado, empleadoId),
				HttpStatus.OK);
	}

	// construir eliminar empleado rest api
	// http://localhost:8080/api/empleado/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> eliminarEmpleado(@PathVariable("id") long empleadoId) {
		empleadoService.eliminarEmpleado(empleadoId);
		return new ResponseEntity<String>("Empleado eliminado correctamente!", HttpStatus.OK);
	}
}
