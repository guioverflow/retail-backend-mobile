package com.atacadista.produto;


public record ProdutoResponseDTO(Long GTIN, String Nome, Integer Quantidade, Float Preco) {
    public ProdutoResponseDTO(ProdutoBean produtoBean) {
        this(
                produtoBean.getGTIN(),
                produtoBean.getNome(),
                produtoBean.getQuantidade(),
                produtoBean.getPreco()
        );
    }
}
