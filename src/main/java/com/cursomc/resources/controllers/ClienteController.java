package com.cursomc.resources.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursomc.domain.entity.Cliente;
import com.cursomc.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	public ClienteService clienteService;

	@GetMapping("{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Integer id){
		Cliente cliente = this.clienteService.buscar(id);
		return ResponseEntity.ok().body(cliente);
	}
	
}
