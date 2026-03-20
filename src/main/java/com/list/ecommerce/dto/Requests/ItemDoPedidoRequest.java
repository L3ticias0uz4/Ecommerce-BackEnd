package com.list.ecommerce.dto.Requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDoPedidoRequest {


    private UUID idProduto;
    private UUID idCategoria;
    private Double preco;
    private Integer quantidade;
}
