package com.list.ecommerce.dtos.Response;

import com.list.ecommerce.entity.ItemDoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ItemDoPedidoResponse {

    private Integer quantidade;
    private Double preco;
    private ItemDoPedido itemDoPedido;
}
