# Introdução

Esse programa foi feito para atuar como o backend de um mercado atacadista. Aqui é possível interagir com o programa por via de requisições HTTP, com operações de CRUD na tabela de produtos e usuários do sistema. Dessa forma, a aplicação cliente pode registrar produtos em estoque no banco de dados e recuperá-los posteriormente, além de abrir a possibilidade de gerenciar novos usuários conforme a necessidade da aplicação. É necessário levar em consideração que a aplicação apenas implementa autenticação, autorização, e persistência de sessão stateless por via de Bearer token. Isso quer dizer que o tráfego dessas informações é feito de forma descriptografada, e para que haja essa camada de segurança, deve ser implementado o suporte para HTTPS.

# Objetivo

O objetivo deste trecho do trabalho (backend) foi explorar o framework Spring voltado para construção de uma API Rest, com acesso ao banco por meio do JPA, configuração de autenticação e autorização com o Spring Security e JWT. A ideia principal foi o aprendizado completo do framework implementando algumas práticas de segurança, previamente desconhecida pelos autores do projeto.

# Instalação e setup

## Com Docker (recomendado)

Nesse procedimento, o setup de ambiente é muito mais rápido, mas não há persistência de dados após o encerramento da aplicação.

### Requisitos

Para prosseguir com o levantamento de ambiente, deve-se ter, previamente, o seguinte software instalado:

1 - Docker*

\* Não importa o sistema operacional, mas um detalhe importante a se considerar é que no Windows, o `Docker Desktop` deve estar aberto durante o uso da aplicação para que os comandos funcionem.

### Instruções

1 - Na pasta raíz do projeto, abra o terminal Powershell e execute o seguinte comando para levantar o banco de dados:

`docker-compose -f .\database\docker-compose.yaml up -d`

2 - Em seguida o comando

`docker-compose -f .\app\docker-compose.yaml up -d`

Observação: No Windows é necessário estar com aplicativo do Docker aberto.

## Com instalação de softwares local

Nesse procedimento, há a persistência de dados, mas a preparação do ambiente é mais dispendiosa.

### Requisitos

Para prosseguir com a configuração e levantamento de ambiente, deve-se ter, previamente, os seguintes softwares instalados:

1 - Java 17

2 - PostgreSQL 15*

3 - pgAdmin 4

\* Na instalação do Postgres, deixar a aplicação na porta padrão 5432. Caso haja a necessidade de alterar a porta, deve-se obrigatoriamente ser especificado no arquivo `application.properties`, dentro da pasta `resources`.

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/6c6dfa2c-401b-4b53-9c23-95698d4c4882)


### Instruções

1 - Após instalado o PostgreSQL, crie um usuário `postgres` com a senha `123`.

1.1 - Alternativamente, o usuário e senha podem ser customizados, mas devem ser obrigatoriamente especificados no arquivo `application.properties`, dentro da pasta `resources`.

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/2a198cf4-f363-413e-91bd-a4e620a4ac0e)


2 - Criar um banco no pgAdmin chamado `db_estoque`.

a) Clique com o botão direito em Databases. Em seguida clique em `Create > Database...`

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/7041160a-f747-44ae-af28-d03213b95644)

b) Configure o nome do banco como `db_estoque`.

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/c27ba383-f7c1-4a28-982d-e94a5418bdf5)

2.1 - Alternativamente, o nome do banco pode ser customizado, mas deve ser obrigatoriamente especificado no arquivo `application.properties`, dentro da pasta `resources`.

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/274932b7-5e2d-4af7-8f9a-5c430d960cd9)

3 - Abrir a ferramenta de Query no pgAdmin 4, e executar as instruções disponíveis no arquivo `dump.sql`.

a) Abrindo a Query Tool no pgAdmin 4.

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/b0561f41-3a50-4248-95da-a210ad385f82)

b) Executando as instruções do `dump.sql`.

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/12f8771a-936c-473c-91b0-9b34fedddae2)

4 - Executar o método `main()`, no arquivo `src/main/java/com/atacadista/AtacadistaApp.java`.

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/66f9d469-1249-4073-a775-630ac4c6890b)

# Arquitetura

A aplicação foi feita utilizando apenas o Spring e dependências do próprio framework, todas listadas no arquivo `pom.xml`.

## Banco de dados

O banco de dados, criado em PostgreSQL, é composto por duas tabelas que não se relacionam diretamente entre si:

- Produtos (#IdProduto, GTIN, Nome, Quantidade, Preco)
  
`IdProduto`: Identificador no banco.

`GTIN`: Identificador Global do produto, código único reconhecido internacionalmente.

`Nome`: Nome/Descrição do produto.

`Quantidade`: Quantidade armazenada em estoque.

`Preco`: Preço cadastrado para o produto.

- Usuarios (#IdUsuario, Role, Username, Password)
  
`IdUsuario`: Identificador no banco.

`Role`: Nível de permissionamento, quanto menor o valor, mais alta a permissão.

`Username`: Nome do usuário cadastrado para essa credencial.

`Password`: Senha cadastrada para esse usuário, armazenada em hash feita pelo algoritmo BCrypt.

## Estrutura da aplicação

A aplicação está separada em uma estrutura bem definida de pastas e packages:

- `./app/`

`docker-compose.yaml`: Arquivo para levantamento rápido do ambiente com Docker.

`Dockerfile`: Arquivo contendo instruções para build da imagem Docker.

- `./database/`

`docker-compose.yaml`: Arquivo para levantamento rápido do ambiente com Docker.

`Dockerfile`: Arquivo contendo instruções para build da imagem Docker.

`dump.sql`: Arquivo contendo as instruções SQL para inicialização default do banco.

- `./src/main/java/com/atacadista`

`infra/security/`: Contém todas as classes responsáveis pela autenticação e configuração de autorização.

`produto/`: Contém todas as classes responsáveis pelo gerenciamento de produtos no banco.

`service/`: Contém um serviço de busca de usuário que alimenta as classes do `infra/security/`.

`usuario/`: Contém todas as classes responsáveis pelo gerenciamento de usuários no banco.

`AtacadistaApp.java`: Classe principal, responsável por fazer a inicialização da aplicação.

- `./src/main/resources/application.properties`: Configurações do Spring, contendo configurações de banco e definição do secret utilizado no JWT.

- `./target/`: Contém os arquivos resultantes da build da aplicação, estes são utilizados na construção com Docker.

- `./pom.xml`: Todas as dependências da aplicação.

# Uso da API

Todas as requisições devem ser feitas com um Bearer token de autorização no cabeçalho da requisição. A única exceção da regra é a URI de login, que gera essa token.

## Verbos

- `POST /auth/login`

Usuários e senha enviados no body, retorna uma token que será utilizada em todas as requisições do sistema. Qualquer usuário, autenticado ou não, tem acesso à esta rota.

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/6b9cd41a-bcd2-4b35-9b62-3c56bc3f36eb)

`GET /produtos`:

Retorna uma lista de todos os produtos. Necessário estar autenticado com nível de acesso "USER".

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/ae51fd00-2a43-47c7-b90b-0b7077872a72)

`GET /produtos/{id}`:

Retorna dados do produto com o id especificado. Necessário estar autenticado com nível de acesso "USER".

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/96d23fac-d017-4504-861a-ae63c4ca6319)


`POST /produtos`:

Faz a inserção de um novo produto no banco. É necessário estar autenticado com nível de acesso "USER" e enviar no body um JSON contendo informações do produto.

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/a40c2276-88d7-4c8c-baf0-2565108eff60)


`PUT /produtos/{id}`:

Faz a atualização completa de um produto no banco. É necessário estar autenticado com nível de acesso "USER" e enviar no body um JSON contendo informações do produto.

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/fd46199a-3183-4935-98db-7a28d6453252)

`DELETE /produtos/{id}`:

Faz a exclusão de um produto no banco. É necessário estar autenticado com nível de acesso "USER".

`GET /usuarios`:

Retorna uma lista de todos os usuários. Necessário estar autenticado com nível de acesso "ADMIN".

`GET /usuarios/{id}`:

Retorna dados do usuário com o id especificado. Necessário estar autenticado com nível de acesso "ADMIN".

`POST /usuarios`:

Faz a inserção de um novo usuário no banco. É necessário estar autenticado com nível de acesso "ADMIN" e enviar no body um JSON contendo informações do usuário.

`DELETE /usuarios/{id}`:

Faz a exclusão de um usuário no banco. É necessário estar autenticado com nível de acesso "ADMIN".

