package com.list.ecommerce.controller;

import com.list.ecommerce.dto.Requests.ProdutoRequest;
import com.list.ecommerce.dto.Response.ProdutoResponse;
import com.list.ecommerce.service.FotoService;
import com.list.ecommerce.service.ProdutoService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Produto")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final FotoService photoService;

    public ProdutoController(ProdutoService produtoService, FotoService photoService) {
        this.produtoService = produtoService;
        this.photoService = photoService;
    }
    @PostMapping(value = "/Produto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProdutoResponse> criarProduto(
            @RequestParam String NomeProduto,
            @RequestParam String DescricaoProduto,
            @RequestParam double preco,
            @RequestParam(required = false) MultipartFile foto) throws IOException {

        String imgUrl = null;
        if (foto != null && !foto.isEmpty()) {
            imgUrl = photoService.salvarFoto(foto);
        }

        ProdutoRequest produtoRequest = new ProdutoRequest(NomeProduto, DescricaoProduto, preco, imgUrl);
        return ResponseEntity.ok(produtoService.criarProduto(produtoRequest));
    }

    @GetMapping("/Produtos")
    public ResponseEntity<List<ProdutoResponse>> listarProdutos() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/Produtos/{id}")
    public ResponseEntity<ProdutoResponse> listarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(produtoService.listarporId(id));
    }

    @PutMapping(value = "/Produtos/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProdutoResponse> atualizarProduto(
            @PathVariable Integer id,
            @RequestParam String NomeProduto,
            @RequestParam String DescricaoProduto,
            @RequestParam double preco,
            @RequestParam(required = false) MultipartFile foto) throws IOException {

        String imgUrl = null;
        if (foto != null && !foto.isEmpty()) {
            imgUrl = photoService.salvarFoto(foto);
        }

        ProdutoRequest produtoRequest = new ProdutoRequest(NomeProduto, DescricaoProduto, preco, imgUrl);
        return ResponseEntity.ok(produtoService.atualizarProduto(id, produtoRequest));
    }

    @DeleteMapping("/Produtos/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Integer id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}