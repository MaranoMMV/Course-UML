package com.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursomc.domain.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
