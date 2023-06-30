package com.atacadista.produto;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "Produtos", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "IdProduto")
public class ProdutoBean {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduto")
    public Integer IdProduto;
    public Long GTIN;
    public String Nome;
    public Integer Quantidade;
    public Float Preco;

    public ProdutoBean(ProdutoRequestDTO data) {
        this.GTIN = data.GTIN();
        this.Nome = data.Nome();
        this.Quantidade = data.Quantidade();
        this.Preco = data.Preco();
    }
}
