package com.list.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPagamento;
    private Instant MomentoPagamento;

    @OneToOne
    @MapsId
    private Pedido pedido;
}
