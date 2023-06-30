
CREATE TABLE Produtos (
	IdProduto SERIAL PRIMARY KEY,
    GTIN bigint,
    Nome varchar(200),
    Quantidade integer,
    Preco float
);

CREATE TABLE Usuarios (
    IdUsuario SERIAL PRIMARY KEY,
    NivelAcesso integer,
    Ativo boolean,
    Usuario varchar(50),
    Hash varchar(256)
);

-- Inserts para tabela Produtos
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7891234567890, 'Arroz Parboilizado 5kg', 50, 29.90);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7894561237890, 'Feijão Carioca 1kg', 100, 7.99);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7897894567890, 'Açúcar Cristal 2kg', 80, 6.50);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7899876543210, 'Óleo de Soja 900ml', 120, 4.99);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7896543217890, 'Farinha de Trigo 5kg', 60, 12.99);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7893216549870, 'Leite em Pó Integral 1kg', 70, 23.90);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7897418529630, 'Café em Grãos 1kg', 90, 29.99);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7899638527410, 'Macarrão Espaguete 500g', 150, 3.99);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7894567893210, 'Sabão em Pó 2kg', 100, 14.50);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7893217894560, 'Detergente Líquido 500ml', 180, 2.99);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7898527419630, 'Papel Higiênico 30 rolos', 50, 19.90);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7899632587410, 'Água Mineral 1,5L (Caixa com 12 unidades)', 40, 16.99);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7897418529630, 'Refrigerante Lata 350ml (Caixa com 24 unidades)', 80, 39.99);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7899638527410, 'Biscoito de Maisena 400g', 120, 5.50);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7894567893210, 'Bolacha Recheada 130g (Caixa com 20 unidades)', 100, 14.99);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7893217894560, 'Molho de Tomate 340g', 200, 2.49);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7898529637410, 'Sal Refinado 1kg', 150, 1.99);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7899637418520, 'Sabonete em Barra 90g (Caixa com 72 unidades)', 80, 34.90);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7897419638520, 'Desodorante Aerosol 150ml (Caixa com 12 unidades)', 60, 79.90);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7898527419630, 'Pasta de Dente 90g', 100, 3.99);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7897418529630, 'Papel Toalha 2 rolos', 80, 9.90);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7899638527410, 'Luvas Descartáveis (Caixa com 100 unidades)', 120, 39.99);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7897418529630, 'Amaciante de Roupas 2L', 100, 12.99);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7899638527410, 'Detergente em Pó 1kg', 60, 6.99);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7897419638520, 'Álcool em Gel 500ml', 150, 14.90);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7898527419630, 'Farofa Pronta 500g', 90, 7.50);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7897419638520, 'Vinho Tinto Seco 750ml', 50, 39.99);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7898529637410, 'Azeite de Oliva Extra Virgem 500ml', 70, 29.90);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7897418529630, 'Maionese 500g', 110, 8.99);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7899637418520, 'Catchup 400g', 120, 4.50);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7898527419630, 'Mostarda 200g', 100, 3.50);
INSERT INTO Produtos (GTIN, Nome, Quantidade, Preco) VALUES (7897419638520, 'Leite Condensado 395g', 80, 4.99);