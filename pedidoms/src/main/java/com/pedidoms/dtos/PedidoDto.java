package com.pedidoms.dtos;

import java.util.List;

import com.pedidoms.entities.Item;
import com.pedidoms.entities.Pedido;
import com.pedidoms.enums.StatusPedido;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PedidoDto(@NotBlank StatusPedido status, List<Item> itens,@NotNull Long idCliente) {

	public PedidoDto(Pedido pedido) {
		this(pedido.getStatus(),pedido.getItens(), pedido.getIdCliente());
	}
}
