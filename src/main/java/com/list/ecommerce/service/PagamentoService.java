package com.list.ecommerce.service;

import com.list.ecommerce.dto.Request.PagamentoRequest;
import com.list.ecommerce.dto.Response.PagamentoResponse;
import com.list.ecommerce.entity.Pagamento;
import com.list.ecommerce.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    //Post
    public PagamentoResponse criarPagamento(Integer id,PagamentoRequest pagamentoRequest){

        Optional<Pagamento>pagamentoExistente = pagamentoRepository.findById(id);
        if(pagamentoExistente.isPresent()){
            throw new RuntimeException("Pagamento ja registrado");

        }
        Pagamento pagamento = new Pagamento();
        pagamento.setMomentoPagamento(pagamentoRequest.getMomento());

        pagamentoRepository.save(pagamento);

        PagamentoResponse pagamentoResponse = new PagamentoResponse(
                pagamento.getIdPagamento(),
                pagamento.getMomentoPagamento()
        );
        return pagamentoResponse;
    }
    //Get by id
    public PagamentoResponse buscarPagamento(Integer id){
        Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow(()-> new RuntimeException("Pagamento não encontrado"));

        return new PagamentoResponse(
                pagamento.getIdPagamento(),
                pagamento.getMomentoPagamento()
        );

    }
    

}
