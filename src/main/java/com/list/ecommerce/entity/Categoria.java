package com.list.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCategoria;
    private String NomeCategoria;
    @ManyToMany(mappedBy =
            "categorias")
    private Set<Produto> produtos = new
            HashSet<>();
}
