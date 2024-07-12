package com.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursomc.domain.entity.Categoria;
import com.cursomc.repository.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication{

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	

}
