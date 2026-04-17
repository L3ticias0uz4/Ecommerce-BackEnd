package com.list.ecommerce.controller;


import com.list.ecommerce.dto.Requests.PagamentoRequest;
import com.list.ecommerce.dto.Response.PagamentoResponse;
import com.list.ecommerce.service.PagamentoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {


    private final PagamentoService pagamentoService;


    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    //Post
    @PostMapping("/criar/pagamento")
    public PagamentoResponse criarPagamento(@PathVariable Integer id, @RequestBody PagamentoRequest pagamentoRequest) {
        return pagamentoService.criarPagamento(id,pagamentoRequest);

    }
    @GetMapping("/buscar/{id}")
    public PagamentoResponse buscarPagamento(@PathVariable Integer id) {
        return pagamentoService.buscarPagamento(id);
    }

}
