package com.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursomc.domain.entity.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
