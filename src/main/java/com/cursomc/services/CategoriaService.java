package com.cursomc.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cursomc.domain.entity.Categoria;
import com.cursomc.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {

	private final CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		return this.categoriaRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada!"));
	}
}
