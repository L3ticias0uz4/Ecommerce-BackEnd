package com.list.ecommerce.service;
import com.list.ecommerce.dto.Request.PedidoRequest;
import com.list.ecommerce.dto.Response.PedidoResponse;
import com.list.ecommerce.entity.Pedido;
import com.list.ecommerce.entity.Usuario;
import com.list.ecommerce.repository.PedidoRepository;
import com.list.ecommerce.repository.UsuarioRepository;
import org.springframework.stereotype.Service;


@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;

    public PedidoService(PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
    }


    //Post
    public PedidoResponse criarPedido(PedidoRequest request, Integer user_id){
        Usuario usuario = usuarioRepository.findById(user_id).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));
        Pedido pedido = new Pedido();

        pedido.setStatus(request.getStatus());
        pedido.setMomentoPedido(request.getMomentoPedido());
        pedido.getCliente(usuario);

        return new PedidoResponse(pedido.getIdPedido(), pedido.getMomentoPedido(),pedido.getStatus());
    }



    //Get By Id
    public PedidoResponse buscarPedidos(Integer id){

        Pedido pedido = pedidoRepository.findById(id).orElseThrow(()-> new RuntimeException("Pedido não encontrado"));

        return new PedidoResponse(

                pedido.getIdPedido(),
                pedido.getMomentoPedido(),
                pedido.getStatus()
        );

        
    }
    public void deletarPedido(Integer id){
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrado"));
        pedidoRepository.delete(pedido);
    }

}
