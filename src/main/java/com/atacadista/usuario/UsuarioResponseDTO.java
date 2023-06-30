package com.atacadista.usuario;

public record UsuarioResponseDTO(Integer IdUsuario, Integer NivelAcesso, Boolean Ativo, String Usuario, String Hash) {
    public UsuarioResponseDTO(UsuarioBean usuarioBean) {
        this(
                usuarioBean.getIdUsuario(),
                usuarioBean.getNivelAcesso(),
                usuarioBean.getAtivo(),
                usuarioBean.getUsuario(),
                usuarioBean.getHash()
        );
    }
}
