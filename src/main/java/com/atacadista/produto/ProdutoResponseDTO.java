package com.atacadista.produto;


public record ProdutoResponseDTO(Integer IdProduto, Long GTIN, String Nome, Integer Quantidade, Float Preco) {
    public ProdutoResponseDTO(ProdutoBean produtoBean) {
        this(
                produtoBean.getIdProduto(),
                produtoBean.getGTIN(),
                produtoBean.getNome(),
                produtoBean.getQuantidade(),
                produtoBean.getPreco()
        );
    }
}
