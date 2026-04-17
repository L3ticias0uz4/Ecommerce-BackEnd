package com.list.ecommerce.service;

import com.list.ecommerce.dto.Requests.ProdutoRequest;
import com.list.ecommerce.dto.Response.ProdutoResponse;
import com.list.ecommerce.entity.Produto;
import com.list.ecommerce.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    //Post
    public ProdutoResponse criarProduto(ProdutoRequest produtoRequest){
        Optional<Produto>produtoExistente = produtoRepository.findByNomeProduto(produtoRequest.getNomeProduto());

        if(produtoExistente.isPresent()){
            throw new RuntimeException("Produto existente");
        }

        Produto produto = new Produto();
        produto.setNomeProduto(produto.getNomeProduto());
        produto.setDescricaoProduto(produtoRequest.getDescricaoProduto());
        produto.setPreco(produtoRequest.getPreco());
        produto.setImgUrl(produtoRequest.getImgUrl());

        ProdutoResponse produtoResponse = new ProdutoResponse(

                produto.getIdProduto(),
                produto.getNomeProduto(),
                produto.getDescricaoProduto(),
                produto.getPreco(),
                produto.getImgUrl()
        );

        return produtoResponse;
    }

    //Get All
    public List<ProdutoResponse> listarProdutos(){

        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream().map(
                produto -> new ProdutoResponse(
                        produto.getIdProduto(),
                        produto.getNomeProduto(),
                        produto.getDescricaoProduto(),
                        produto.getPreco(),
                        produto.getImgUrl()
                )).toList();
    }


    //Get by id

    public ProdutoResponse listarporId(Integer id){

        Produto produto = produtoRepository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrado"));

        return new ProdutoResponse(
                produto.getIdProduto(),
                produto.getNomeProduto(),
                produto.getDescricaoProduto(),
                produto.getPreco(),
                produto.getImgUrl()
        );
    }
    //Delete
    public void deletarProduto(Integer id){
        Produto produto = produtoRepository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrado"));
        produtoRepository.delete(produto);

    }

    //Put
    public ProdutoResponse atualizarProduto(Integer id, ProdutoRequest produtoRequest){
        Produto produto = produtoRepository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrado"));

        produto.setNomeProduto(produtoRequest.getNomeProduto());
        produto.setDescricaoProduto(produtoRequest.getDescricaoProduto());
        produto.setPreco(produtoRequest.getPreco());
        produto.setImgUrl(produtoRequest.getImgUrl());
        produtoRepository.save(produto);

        ProdutoResponse produtoResponse = new ProdutoResponse(
                produto.getIdProduto(),
                produto.getNomeProduto(),
                produto.getDescricaoProduto(),
                produto.getPreco(),
                produto.getImgUrl()

        );
        return produtoResponse;

    }
}
