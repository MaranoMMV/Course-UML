package com.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursomc.domain.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
