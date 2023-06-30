package com.atacadista.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void insert(@RequestBody ProdutoRequestDTO data) {
        ProdutoBean produtoData = new ProdutoBean(data);
        repository.save(produtoData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ProdutoResponseDTO> selectAll() {
        List<ProdutoResponseDTO> produtosList = repository.findAll().stream()
                .map(ProdutoResponseDTO::new)
                .collect(Collectors.toList());
        return produtosList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ProdutoResponseDTO selectById(@PathVariable Integer id) {
        ProdutoBean produtoBean = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Produto não encontrado com ID: " + id
                ));
        return new ProdutoResponseDTO(produtoBean);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ProdutoResponseDTO update(@PathVariable Integer id, @RequestBody ProdutoRequestDTO ProdutoRequestDTO) {
        ProdutoBean produtoBean = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Produto não encontrado com ID: " + id
                ));

        produtoBean.setNome(ProdutoRequestDTO.Nome());
        produtoBean.setQuantidade(ProdutoRequestDTO.Quantidade());
        produtoBean.setPreco(ProdutoRequestDTO.Preco());

        ProdutoBean updatedProduto = repository.save(produtoBean);

        return new ProdutoResponseDTO(updatedProduto);
    }
}
