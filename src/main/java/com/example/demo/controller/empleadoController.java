package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

}
