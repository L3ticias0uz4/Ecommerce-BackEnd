package com.list.ecommerce.repository;

import com.list.ecommerce.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Optional<Produto> findByNomeProduto(String nomeProduto);
}
