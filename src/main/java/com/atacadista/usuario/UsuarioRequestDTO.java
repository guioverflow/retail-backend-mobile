package com.atacadista.usuario;

public record UsuarioRequestDTO(Integer NivelAcesso, Boolean Ativo, String Usuario, String Hash) {
}
