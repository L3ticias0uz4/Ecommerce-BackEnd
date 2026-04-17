package com.list.ecommerce.dto.Response;

import com.list.ecommerce.enums.StatusDoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponse {

    private long idPedido;
    private Instant MomentoPedido;
    private StatusDoPedido Status;
}
