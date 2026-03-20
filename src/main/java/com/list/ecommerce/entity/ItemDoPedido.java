package com.list.ecommerce.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDoPedido {

    @EmbeddedId
    private ItemDoPedidoPK id = new ItemDoPedidoPK();
    private Integer quantidade;
    private Double preco;

    public ItemDoPedido( Pedido pedido, Produto produto, Double preco, Integer quantidade) {
        this.preco = preco;
        this.quantidade = quantidade;
        id.setPedido(pedido);
        id.setProduto(produto);
    }

    public Pedido getPedido() {
        return id.getPedido();
    }
    public void setPedido(Pedido pedido) {
        id.setPedido(pedido);
    }
    public Produto getProduto() {
        return id.getProduto();
    }
    public void setProduto(Produto produto) {
        id.setProduto(produto);
    }


}
