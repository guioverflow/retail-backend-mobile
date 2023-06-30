package com.atacadista.produto;

public record ProdutoRequestDTO(Long GTIN, String Nome, Integer Quantidade, Float Preco) {
}
