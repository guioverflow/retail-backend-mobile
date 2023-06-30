package com.atacadista.produto;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "Produtos", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "GTIN")
public class ProdutoBean {
    @Id
    public Long GTIN;
    public String Nome;
    public Integer Quantidade;
    public Float Preco;

    public ProdutoBean(ProdutoRequestDTO data) {
        this.Nome = data.Nome();
        this.Quantidade = data.Quantidade();
        this.Preco = data.Preco();
    }
}
