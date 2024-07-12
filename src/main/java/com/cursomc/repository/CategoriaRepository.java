package com.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursomc.domain.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
