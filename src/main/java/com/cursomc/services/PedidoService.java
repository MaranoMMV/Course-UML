package com.cursomc.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cursomc.domain.entity.Pedido;
import com.cursomc.repository.PedidoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {

	private final PedidoRepository pedidoRepository;
	
	public Pedido buscar(Integer id) {
		return this.pedidoRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrada!"));
	}
}
