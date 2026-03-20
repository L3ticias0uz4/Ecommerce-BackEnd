package com.list.ecommerce.dto.Requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {


    private String NomeProduto;
    private String DescricaoProduto;
    private double preco;
    private String imgUrl;



}
