package com.atacadista.usuario;

public record UsuarioResponseDTO(Integer IdUsuario, UsuarioRole role, String username, String password) {
    public UsuarioResponseDTO(Usuario usuario) {
        this(
                usuario.getIdUsuario(),
                usuario.getRole(),
                usuario.getUsername(),
                usuario.getPassword()
        );
    }
}
