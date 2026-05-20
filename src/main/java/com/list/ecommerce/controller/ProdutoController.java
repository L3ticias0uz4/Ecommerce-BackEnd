package com.list.ecommerce.controller;

import com.list.ecommerce.dto.Requests.ProdutoRequest;
import com.list.ecommerce.dto.Response.ProdutoResponse;
import com.list.ecommerce.service.PhotoService;
import com.list.ecommerce.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Produto")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final PhotoService photoService;

    public ProdutoController(ProdutoService produtoService, PhotoService photoService) {
        this.produtoService = produtoService;
        this.photoService = photoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> criarProduto(
            @RequestParam String nomeProduto,
            @RequestParam String descricaoProduto,
            @RequestParam double preco,
            @RequestParam(required = false) MultipartFile imagem) throws IOException {

        ProdutoRequest produtoRequest = new ProdutoRequest();
        produtoRequest.setNomeProduto(nomeProduto);
        produtoRequest.setDescricaoProduto(descricaoProduto);
        produtoRequest.setPreco(preco);

        String caminhoImagem = null;
        if (imagem != null && !imagem.isEmpty()) {
            caminhoImagem = photoService.salvarFoto(imagem);
        }

        return ResponseEntity.ok(produtoService.criarProduto(produtoRequest, caminhoImagem));
    }

    @GetMapping("/Produtos")
    public ResponseEntity<List<ProdutoResponse>> listarProdutos() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/Produtos/{id}")
    public ResponseEntity<ProdutoResponse> listarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(produtoService.listarporId(id));
    }

    @PutMapping("/Produtos/{id}")
    public ResponseEntity<ProdutoResponse> atualizarProduto(
            @PathVariable Integer id,
            @RequestParam String nomeProduto,
            @RequestParam String descricaoProduto,
            @RequestParam double preco,
            @RequestParam(required = false) MultipartFile imagem) throws IOException {

        ProdutoRequest produtoRequest = new ProdutoRequest();
        produtoRequest.setNomeProduto(nomeProduto);
        produtoRequest.setDescricaoProduto(descricaoProduto);
        produtoRequest.setPreco(preco);

        String caminhoDaImagem = null;
        if (imagem != null && !imagem.isEmpty()) {
            caminhoDaImagem = photoService.salvarFoto(imagem);
        }

        return ResponseEntity.ok(produtoService.atualizarProduto(id, produtoRequest, caminhoDaImagem));
    }

    @DeleteMapping("/Produtos/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Integer id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}