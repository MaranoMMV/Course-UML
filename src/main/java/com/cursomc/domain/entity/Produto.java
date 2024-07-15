package com.cursomc.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;
	
	@JsonIgnore
	@OneToMany(mappedBy="id.produto")
	private Set<ItemPedido> itens = new HashSet<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name="PRODUTO_CATEGORIA", 
			joinColumns = @JoinColumn(name = "produto_id"),
			inverseJoinColumns = @JoinColumn(name = "categoria_id")
			)
	private List<Categoria> categorias = new ArrayList<>();

	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	@JsonIgnore
	public List<Pedido> getPedidos(){
		List<Pedido> lista =  new ArrayList<>();
		for(ItemPedido x: itens) {
			lista.add(x.getPedido());
		}
		return lista;
		
	}
}