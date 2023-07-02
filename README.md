# API Rest do Atacadista

# Instalação e setup

## Com Docker (recomendado)

Dessa forma, o setup de ambiente é muito mais rápido, mas não há persistência de dados após o encerramento da aplicação.

### Requisitos

Para prosseguir com o levantamento de ambiente, deve-se ter, previamente, o seguinte software instalado:

1 - Docker*

\* Não importa o sistema operacional, mas um detalhe importante a se considerar é que no Windows, o `Docker Desktop` deve estar aberto durante o uso da aplicação para que os comandos funcionem.

### Instruções

1 - Na pasta raíz do projeto, abra o terminal Powershell e execute o seguinte comando para levantar o banco de dados:

`docker-compose -f .\src\main\database\docker-compose.yaml up -d`

2 - Em seguida o comando

`colocar docker-compose do spring boot`

Observação: No Windows é necessário estar com aplicativo do Docker aberto.



## Com instalação de softwares local

Dessa forma, há a persistência de dados, mas a preparação do ambiente é mais despendiosa.

### Requisitos

Para prosseguir com a configuração e levantamento de ambiente, deve-se ter, previamente, os seguintes softwares instalados:

1 - Java 17

2 - PostgreSQL 15*

3 - pgAdmin 4

\* Na instalação do Postgres, deixar a aplicação na porta padrão 5432. Caso haja a necessidade de alterar a porta, deve-se obrigatoriamente ser especificado no arquivo `application.properties`.

### Instruções

1 - Após instalado o PostgreSQL, crie um usuário `postgre` com a senha `123`.

1.1 - Alternativamente, o usuário e senha podem ser customizados, mas devem ser obrigatoriamente especificados no arquivo `application.properties`.

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/2a198cf4-f363-413e-91bd-a4e620a4ac0e)


2 - Criar um banco no pgAdmin chamado `db_estoque`.

a) Clique com o botão direito em Databases. Em seguida clique em `Create > Database...`

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/7041160a-f747-44ae-af28-d03213b95644)

b) Configure o nome do banco como `db_estoque`.

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/c27ba383-f7c1-4a28-982d-e94a5418bdf5)


2.1 - Alternativamente, o nome do banco pode ser customizado, mas deve ser obrigatoriamente especificado no arquivo `application.properties`;

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/274932b7-5e2d-4af7-8f9a-5c430d960cd9)


3 - Abrir a ferramenta de Query no pgAdmin 4, e executar as instruções disponíveis no arquivo `dump.sql`.

a) Abrindo a Query Tool no pgAdmin 4.

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/b0561f41-3a50-4248-95da-a210ad385f82)

b) Executando as instruções do `dump.sql`.

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/12f8771a-936c-473c-91b0-9b34fedddae2)

4 - Executar o método `main()`, no arquivo `src/main/java/com/atacadista/AtacadistaApp.java`.

![image](https://github.com/guioverflow/retail-backend-mobile/assets/84868817/66f9d469-1249-4073-a775-630ac4c6890b)

# Arquitetura

## Banco de dados

Falar sobre tabelas e os dados inclusos

## Backend

Falar sobre dependencias

Falar sobre estrutura de pastas

Falar sobre componentes

# Uso







