package com.list.ecommerce.dto.Requests;

import com.list.ecommerce.enums.StatusDoPedido;
import com.list.ecommerce.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequest {

    private Usuario cliente;
    private Instant MomentoPedido;
    private StatusDoPedido status;

}
