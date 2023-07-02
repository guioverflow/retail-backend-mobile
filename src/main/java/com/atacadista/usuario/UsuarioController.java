package com.atacadista.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {

        if (repository.findByUsername(data.username()) != null)
            return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Usuario novoUsuario = new Usuario(data.username(), encryptedPassword, data.role());

        this.repository.save(novoUsuario);

        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<UsuarioResponseDTO> selectAll() {
        List<UsuarioResponseDTO> usuariosList = repository.findAll().stream()
                .map(UsuarioResponseDTO::new)
                .collect(Collectors.toList());
        return usuariosList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public UsuarioResponseDTO selectById(@PathVariable Integer id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Funcionario não encontrado com ID: " + id
                ));
        return new UsuarioResponseDTO(usuario);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
