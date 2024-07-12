package com.cursomc.resources.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	@GetMapping
	public String listar() {
		return "Rest está funcionando";
	}
	
}
