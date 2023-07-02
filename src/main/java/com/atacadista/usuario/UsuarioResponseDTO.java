package com.atacadista.usuario;

// Objeto representando as informações contidas numa Response de usuário
public record UsuarioResponseDTO(Integer IdUsuario, UsuarioRole role, String username) {
    public UsuarioResponseDTO(Usuario usuario) {
        this(
                usuario.getIdUsuario(),
                usuario.getRole(),
                usuario.getUsername()
        );
    }
}
