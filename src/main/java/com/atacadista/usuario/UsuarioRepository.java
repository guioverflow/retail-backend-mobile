package com.atacadista.usuario;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioBean, Integer> {
}
