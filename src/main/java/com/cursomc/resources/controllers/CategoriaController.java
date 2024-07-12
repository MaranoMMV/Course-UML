package com.cursomc.resources.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursomc.domain.entity.Categoria;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	@GetMapping
	public List<Categoria> listar() {
		Categoria cat1  = new Categoria(1 , "Informatica");
		Categoria cat2 = new Categoria(2, "Escritorio");
		
		List<Categoria> listagem = new ArrayList<>();
		listagem.add(cat2);
		listagem.add(cat1);
		return listagem;
	}
	
}
