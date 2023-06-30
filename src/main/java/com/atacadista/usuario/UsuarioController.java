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
        UsuarioBean usuarioData = new UsuarioBean(data);
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
        UsuarioBean usuarioBean = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Funcionario não encontrado com ID: " + id
                ));
        return new UsuarioResponseDTO(usuarioBean);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public UsuarioResponseDTO update(@PathVariable Integer id, @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioBean usuarioBean = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Funcionario não encontrado com ID: " + id
                ));


        usuarioBean.setNivelAcesso(usuarioRequestDTO.NivelAcesso());
        usuarioBean.setAtivo(usuarioRequestDTO.Ativo());
        usuarioBean.setUsuario(usuarioRequestDTO.Usuario());
        usuarioBean.setHash(usuarioRequestDTO.Hash());

        UsuarioBean updatedFuncionario = repository.save(usuarioBean);

        return new UsuarioResponseDTO(updatedFuncionario);
    }
}
