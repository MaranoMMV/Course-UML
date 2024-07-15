package com.cursomc.resources.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursomc.domain.entity.Pedido;
import com.cursomc.services.PedidoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {
	
	private final PedidoService pedidoService;

	@GetMapping("{id}")
	public ResponseEntity<Pedido> listar( @PathVariable Integer id) {
		
		Pedido categoria = pedidoService.buscar(id);
		return ResponseEntity.ok(categoria);
	}
	
}
