package com.cursomc.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable
public class ItemPedidoPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.getId().hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
		 return true;
		if (obj == null)
		 return false;
		if (getClass() != obj.getClass())
		 return false;
		ItemPedidoPK other = (ItemPedidoPK) obj;
		if (pedido == null) {
			if (other.pedido != null)
			 return false;
		} else if (!pedido.equals(other.pedido))
		 return false;
		if (produto == null) {
			if (other.produto != null)
			 return false;
		} else if (!produto.equals(other.produto))
		 return false;
		return true;
	}
}