package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootrestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootrestfulApplication.class, args);
		Estudiante est = new Estudiante();
		est.setNombre("Alejandro");
		est.setApellido("Cabezas");
		System.out.println(est.getNombre() + " " + est.getApellido());
	}
}