package com.list.ecommerce.controller;

import com.list.ecommerce.dtos.Request.ProdutoRequest;
import com.list.ecommerce.dtos.Response.ProdutoResponse;
import com.list.ecommerce.service.ProdutoService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequestMapping("/Produto")
public class ProdutoController {

    private final ProdutoService produtoService;


    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/Produto")
    public ProdutoResponse criarProduto(@RequestBody ProdutoRequest produtoRequest){

        return produtoService.criarProduto(produtoRequest);
    }

    @GetMapping("/Produtos")
    public List<ProdutoResponse> listarPedidos(){

        return produtoService.listarProdutos();
    }
    @GetMapping("/Produtos")
    public ProdutoResponse listarPorId(@PathVariable Integer id){

        return produtoService.listarporId(id);

    }
    @PutMapping("/Produtos/{id}")
    public ProdutoResponse atualizarProduto(@PathVariable Integer id, @RequestBody ProdutoRequest produtoRequest){

        return produtoService.atualizarProduto(id,produtoRequest);
    }
    @DeleteMapping("/Produtos/{id}")
    public void deletarProduto(@PathVariable Integer id){
        produtoService.deletarProduto(id);
    }

}
