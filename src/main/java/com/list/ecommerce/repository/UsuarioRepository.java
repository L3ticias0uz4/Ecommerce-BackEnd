package com.list.ecommerce.repository;

import com.list.ecommerce.entity.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(@NotBlank(message = "O campo não pode estar vazio") @Email(message = "Digite um email valido") String email);

    Integer id(long id);


}
