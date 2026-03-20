package com.list.ecommerce.controller;

import com.list.ecommerce.dto.Request.PedidoRequest;
import com.list.ecommerce.dto.Response.PedidoResponse;
import com.list.ecommerce.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("/Pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/{id}")
    public PedidoResponse criarPedido(@RequestBody PedidoRequest pedidoRequest, @PathVariable Integer id) {
        return pedidoService.criarPedido(pedidoRequest,id);
    }
    @GetMapping("/pedidos")
    public PedidoResponse buscarPedidos(Integer id) {
        return pedidoService.buscarPedidos(id);
    }
    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Integer id) {

        pedidoService.deletarPedido(id);
    }

}
