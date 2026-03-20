package com.list.ecommerce.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponse {


    private long idProduto;
    private String NomeProduto;
    private String DescricaoProduto;
    private double preco;
    private String imgUrl;
}
