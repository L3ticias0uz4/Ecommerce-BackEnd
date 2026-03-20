package com.list.ecommerce.dto.Requests;

import com.list.ecommerce.entity.Pedido;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {

    @NotBlank(message = "O campo não pode estar vazio")
    private String nome;
    @NotBlank(message = "O campo não pode estar vazio")
    @Email(message = "Digite um email valido")
    private String email;
    @NotBlank(message = "O campo não pode estar vazio")
    private String senha;
    private Role roles;
    private String telefone;
    private List<Pedido> pedidos = new ArrayList<>();
}
