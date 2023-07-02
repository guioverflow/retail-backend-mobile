package com.atacadista.usuario;

public record UsuarioRequestDTO(UsuarioRole role, String username, String password) {
}
