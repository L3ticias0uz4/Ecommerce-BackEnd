package com.list.ecommerce.entity;
import com.list.ecommerce.enums.StatusDoPedido;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPedido;
    private Instant MomentoPedido;
    private StatusDoPedido Status;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private Usuario cliente;

    @OneToOne(mappedBy = "pedido",
    cascade = CascadeType.ALL)
    private Pagamento pagamento;


    public void getCliente(Usuario usuario) {
    }

}
