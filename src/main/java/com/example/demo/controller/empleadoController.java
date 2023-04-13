package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Empleado;
import com.example.demo.service.EmpleadoService;

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
}
