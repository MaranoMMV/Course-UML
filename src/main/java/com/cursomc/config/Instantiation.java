package com.cursomc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cursomc.domain.entity.Categoria;
import com.cursomc.repository.CategoriaRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		this.categoriaRepository.deleteAll();
		
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	
	}
}
