package com.atacadista.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void insert(@RequestBody UsuarioRequestDTO data) {
        Usuario usuarioData = new Usuario(data);
        repository.save(usuarioData);
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

    @PutMapping("/{id}")
    public UsuarioResponseDTO update(@PathVariable Integer id, @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Funcionario não encontrado com ID: " + id
                ));

        usuario.setRole(usuarioRequestDTO.role());
        usuario.setUsername(usuarioRequestDTO.username());
        usuario.setPassword(usuarioRequestDTO.password());

        Usuario updatedFuncionario = repository.save(usuario);

        return new UsuarioResponseDTO(updatedFuncionario);
    }
}
