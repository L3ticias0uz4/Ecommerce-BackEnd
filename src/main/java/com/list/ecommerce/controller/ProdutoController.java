package com.list.ecommerce.controller;

import com.list.ecommerce.dto.Requests.ProdutoRequest;
import com.list.ecommerce.dto.Response.ProdutoResponse;
import com.list.ecommerce.service.ProdutoService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;


    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/criar/produto")
    public ProdutoResponse criarProduto(@RequestBody ProdutoRequest produtoRequest){

        return produtoService.criarProduto(produtoRequest);
    }

    @GetMapping("/listar/produtos")
    public List<ProdutoResponse> listarPedidos(){

        return produtoService.listarProdutos();
    }
    @GetMapping("/produtos/{id}")
    public ProdutoResponse listarPorId(@PathVariable Integer id){

        return produtoService.listarporId(id);

    }
    @PutMapping("/atualizar/{id}")
    public ProdutoResponse atualizarProduto(@PathVariable Integer id, @RequestBody ProdutoRequest produtoRequest){

        return produtoService.atualizarProduto(id,produtoRequest);
    }
    @DeleteMapping("/deletar/{id}")
    public void deletarProduto(@PathVariable Integer id){
        produtoService.deletarProduto(id);
    }

}
