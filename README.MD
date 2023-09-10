# Desafio Spring

## Sobre o projeto

Projeto criado para criar webservice utilizando Spring Boot e Docker.

## Execução do projeto
### Pré-requisitos

 - Docker instalado.

 - Uma IDE compatível com projetos Spring, como o IntelliJ IDEA ou o Eclipse.

### Configurando o Banco de Dados
No diretório /docker, você encontrará o arquivo mysql-docker-compose.yml, que cria o contêiner MySQL e uma interface para visualização dos dados do banco de dados.

Execute o seguinte comando no seu terminal para criar o contêiner MySQL:
```bash
docker-compose -f docker/mysql-docker-compose.yml up -d
```
Verifique se o contêiner foi criado com sucesso.

Acesse a interface de visualização do banco de dados no seu navegador, que normalmente estará disponível em http://localhost:8001. Use as credenciais nome de usuário: root, senha: root para fazer login.


### Criando as Tabelas do Banco de Dados
Você pode criar as tabelas do banco de dados executando o script SQL localizado em diretório/sq, ou criando um novo script. Aqui estão as etapas para executar o script fornecido:

Na interface, clique em "Executar SQL" ou algo semelhante e cole o seguinte script SQL para criar as tabelas:
```bash
use desafio_db;

create table tab_marca (
    marca_id varchar(255) not null,
    marca_ativo boolean,
    marca_cod_denatran varchar(255),
    marca_nome varchar(255),
    primary key (marca_id)
);

create table tab_modelo (
    modelo_id varchar(255) not null,
    modelo_ano integer,
    modelo_ativo boolean,
    modelo_nome varchar(255),
    ref_marca varchar(255),
    primary key (modelo_id),
    constraint fk_tab_modelo_marca foreign key(ref_marca) references tab_marca(marca_id)
);
```

Execute o script para criar as tabelas no banco de dados desafio_db.

###Executando o Projeto Spring Boot 
Seu projeto Spring Boot está pronto para ser executado. Você pode encontrar os endpoints no README ou importar o arquivo do Postman localizado em /postman.
## Tecnologias Utilizadas

### Back end

- Spring Boot
- MySql
- Docker

### Spring Boot

A aplicação foi desenvolvida com o Spring Boot utilizando Java e foram utilizadas as seguintes técnicas:

- `Controllers`: mapear os endpoints
- `Services`: realizar as ações esperadas pelo controller
- `Repositories`: oferecer e realizar os comportamentos de persistência de banco de dados
- `DTO`: padrão para indicar quais informações devem ser enviada/recebidas via requisição
- `JPA` com `Hibernate`: solução para se comunicar com o banco de dados
- `Mysql`:  sistema de gerenciamento de banco de dados, que utiliza a linguagem SQL como interface.

Bibliotecas do Spring Framework que foram utilizadas:

- `devtools`: ferramenta para agilizar o processo de desenvolvimento sem reiniciar a aplicação para atualizar
- `starter-web`: suporte para aplicação web em geral
- `starter-data-jpa`: suporte para abstrair a implementação de repositórios e reutilizar comportamentos de CRUD com base
  na configuração da JPA
- `starter-validation`: validação de dados da requisição por meio de anotação
- `lombok`: simplificação e redução de código de classes de modelo

## Endpoints para api

### Marca

```bash
#Cadastrar marca

Método: POST

endpoint: api/marca/cadastrar
#Request
{
    "nome":string,
    "codDenatran":string,
    "ativo":boolean,
}

#Response
Status 201 - CREATED
```

```bash
#Recuperar todas as marcas

Método: GET

endpoint: api/marca/all_marcas

#Response
[]
Status 200 - OK
```

```bash
#Recuperar marca por Id

Método: GET

endpoint: api/marca/get_marca/{id}

#Response
{
  "id":string,
  "nome":string,
  "codDenatran":string,
  "ativo":boolean,
  "modelos":[]
  
}
Status 200 - OK
```

```bash
#Atualiza marca por Id

Método: PUT

endpoint: api/marca/update_marca/{id}

#Request
{
    "nome":string,
    "codDenatran":string,
    "ativo":boolean,
}

#Response
Status 200 - OK
```

```bash
#Apaga marca por Id

Método: DELETE

endpoint: api/marca/delete_marca/{id}

#Response
Status 204 - NO CONTENT
```

### Modelo

```bash
#Cadastra modelo por Id da marca

Método: POST

endpoint: api/modelo/cadastrar/{idMarca}

#Request
{
    "nome": string,
    "ano": integer,
    "ativo":boolean
}

#Response
Status 201 - CREATED
```

```bash
#Obter todos os modelos

Método: GET

endpoint: api/modelo/get_all_modelos

#Response
[]
Status 200 - OK
```

```bash
#Obter todos os modelos por marca

Método: GET

endpoint: api/modelo//get_all_modelos_marca/{idMarca}

#Response
[]
Status 200 - OK
```

```bash
#Obter modelo por Id

Método: GET

endpoint: api/modelo/get_modelo/{id}

#Response
{
  "id": string,
  "nome": string,
  "ano": integer,
  "ativo": boolean
}
Status 200 - OK
```

```bash
#Atualizar modelo por Id

Método: PUT

endpoint: api/modelo/update_modelo/{id}

#Request
{
    "nome": string,
    "ano": integer,
    "ativo":boolean
}

#Response
Status 200 - OK
```

```bash
#Apagar modelo por Id

Método: DELETE

endpoint: api/modelo/delete_modelo/{id}

#Response
Status 204 - NO CONTENT
```