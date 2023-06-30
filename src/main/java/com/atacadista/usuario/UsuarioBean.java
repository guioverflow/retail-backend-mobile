package com.atacadista.usuario;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.ComponentScan;

@Getter
@Setter
@Entity
@Table(name = "Usuarios", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "IdUsuario")
public class UsuarioBean {
    @Id
    @Column(name = "idusuario") @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer IdUsuario;

    @Column(name = "nivelacesso")
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
