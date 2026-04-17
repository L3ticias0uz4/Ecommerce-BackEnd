package com.list.ecommerce.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoResponse {

    private long idPagamneto;
    private Instant MomentoPagamento;
}
