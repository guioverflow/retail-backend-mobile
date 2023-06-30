package com.atacadista.usuario;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "Usuarios", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "IdUsuario")
public class UsuarioBean {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer IdUsuario;
    public Integer NivelAcesso;
    public Boolean Ativo;
    public String Usuario;
    public String Hash;

    public UsuarioBean(UsuarioRequestDTO Data) {
        this.NivelAcesso = Data.NivelAcesso();
        this.Ativo = Data.Ativo();
        this.Usuario = Data.Usuario();
        this.Hash = Data.Hash();
    }
}
