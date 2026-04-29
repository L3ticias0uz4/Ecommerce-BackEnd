package com.list.ecommerce.entity;

import com.list.ecommerce.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;

    @Enumerated(EnumType.STRING)
    private Role roles;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new
            ArrayList<>();

    public void setRoles(javax.management.relation.Role roles) {
    }
}
