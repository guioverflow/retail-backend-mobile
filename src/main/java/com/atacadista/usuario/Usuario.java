package com.atacadista.usuario;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@EntityScan
@Table(name = "Usuarios", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "IdUsuario")
public class Usuario implements UserDetails {
    @Id
    @Column(name = "idusuario") @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer IdUsuario;

    public UsuarioRole role;
    public String username;
    public String password;

    public Usuario(UsuarioRequestDTO Data) {
        this.role = Data.role();
        this.username = Data.username();
        this.password = Data.password();
    }

    public Usuario(String username, String password, UsuarioRole usuarioRole) {
        this.username = username;
        this.password = password;
        this.role = usuarioRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UsuarioRole.ADMIN) return List.of(
                new SimpleGrantedAuthority("ROLE_ADMIN"),
                new SimpleGrantedAuthority("ROLE_USER"));
        else if (this.role == UsuarioRole.USER)
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));

        return List.of();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
