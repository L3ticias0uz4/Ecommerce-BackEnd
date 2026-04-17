package com.list.ecommerce.controller;

import com.list.ecommerce.dto.Requests.PedidoRequest;
import com.list.ecommerce.dto.Response.PedidoResponse;
import com.list.ecommerce.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/criar/{id}")
    public PedidoResponse criarPedido(@RequestBody PedidoRequest pedidoRequest, @PathVariable Integer id) {
        return pedidoService.criarPedido(pedidoRequest,id);
    }
    @GetMapping("/buscar/pedidos")
    public PedidoResponse buscarPedidos(Integer id) {
        return pedidoService.buscarPedidos(id);
    }
    @DeleteMapping("/deletar/{id}")
    public void deletarPedido(@PathVariable Integer id) {

        pedidoService.deletarPedido(id);
    }

}
