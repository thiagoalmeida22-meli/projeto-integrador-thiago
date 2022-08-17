<h1 align="center">✅ Projeto Integrador - MeLi Frescos ✅</h1>
<p align="center">Repositório criado para hospedar o código do terceiro e último Touchpoint do Bootcamp IT Java.</p>

<p align="center">
  <img align="" alt="meliantes" src="https://media2.giphy.com/media/kG6B7EcihfJN12CVSj/giphy.gif?cid=ecf05e471tmof99bt97icr9r4bf4hcjj7ds646mgck0y704g&rid=giphy.gif&ct=g" height="70%" width="70%" />
</p>

<p align="center">
 <a href="#Objetivo">Sobre o Projeto</a> •
 <a href="#Requisitos">Requisitos</a> • 
 <a href="#Tecnologias">Tecnologias</a> • 
 <a href="#Pré-requisitos">Pré-requisitos</a> • 
 <a href="#Rodando o Servidor">Rodando o Servidor</a> • 
 <a href="#Dependências">Dependências</a> • 
 <a href="#Coleção-de-Requisições">Coleção de Requisições</a> •
 <a href="#Autores">Autores</a> •
</p>

<a name="Objetivo"></a>
## 🖊 Sobre o Projeto


<p> 
O objetivo do projeto é desenvolver uma API Rest, escrita na linguagem Java. Esta API está inserida no contexto de venda de produtos frescos, refrigerados e congelados pelo Mercado Livre. 
Neste sentido, o programa viabiliza o cadastro, consulta e edição de lotes de produtos setorizados, bem como a gerência de carrinho de compras e de diferentes anúncios.
</p>

___

<a name="Requisitos"></a>

## 📄 Requisitos

<p> Obrigatórios (RO)</p>

<p>

- RO-01 Inserir o lote no armazém de atendimento;
- RO-02 Adicionar produto ao carrinho de compras;
- RO-03 Verificar a localização de um produto no armazém;
- RO-04 Consultar o estoque de um produto em todos os armazéns;
- RO-05 Consultar a data de validade por lote

  ----------- Requisito 6 -------------
- RO-06 Requisito Individual: Adição de um sistema de pontos - parecido com milhas - que podem ser trocados por bonus pelo usuário.
 * - Adição de endpoints CRUD permitindo a criação, atualização, listagem e apagamentos de bonûs / prêmios
 * - Nova tabela de prêmios com o nome: Fidelity
 * - Alteração: A tabela Customer agora tem uma relação 1:N com a tabela Order Entry por meio da foreign key seller_id em order entry
 * - Ou seja: um  único Customer pode criar varias inboundOrders (listar seus diferentes lotes de produtos a venda no marketplace)
 * - A tabela customer também contem um novo campo "PONTOS" responsável por armazenar a quantidade de pontos de fidelidade de um usúario
 * - Pequeno update na função "service.OrderService.createInboundOrder" para adicionar pontos a um usuário responsavel por criar uma inboundOrder
 * - Pequeno update na função "service.CartService.updateStatusCart" para adicionar pontos ao usuário dono de um carrinho, quando a compra desse carrinho for concluída
 
 - RO-07 Testes de unidade & testes de integração de todos os requisitos anteriores.

</p>
<p> Cobertura de testes Unitários (TU) implementados (%)</p>
<p>

- TU-01 BatchController (100% methods, 100% lines);
- TU-02 CartController (100% methods, 100% lines);
- TU-03 OrderController (100% methods, 100% lines);
- TU-04 ProductController (100% methods, 100% lines);
- TU-05 AgentService (100% methods, 100% lines);
- TU-06 BatchService (80% methods, 86% lines);
- TU-07 CartService (100% methods, 100% lines);
- TU-08 OrderService (100% methods, 92% lines);
- TU-09 ProductService (87% methods, 90% lines);
- TU-10 SectionService (100% methods, 75% lines);
- TU-11 WarehouseService (100% methods, 100% lines);

 ----------- Requisito 6 -------------
- TU-12 FidelityService (83% methods, 73% lines);
</p>

## User Story
A user Story do requisito 6 pode ser encontrada aqui:
https://docs.google.com/document/d/e/2PACX-1vQX5Kgii57FQCHlT1F7SpIZt7LZnOLMN7x9esA5Sb2C_aAJsZSD7rVrZNQ6SI8F-Q/pub

___
<a name="Tecnologias"></a>

## 🛠 Tecnologias
A API foi construída utilizando a linguagem Java, com o framework Spring Boot. Como banco de dados, utilizou-se o MySQL, por meio da biblioteca JPA.

___
<a name="Pré-requisitos"></a>

## ✅ Pré-requisitos
Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Java](https://www.java.com/pt-BR/) e um editor de código a sua escolha. Sugere-se o uso do Intelij Idea, disponível [aqui](https://www.jetbrains.com/pt-br/idea/).

___

<a name="Rodando o Servidor"></a>

## 🎲 Rodando o Servidor


- Clone este repositório na sua máquina:

      git clone https://github.com/thiagoalmeida22-meli/projeto-integrador-thiago

- Acesse a pasta do projeto no terminal:

      cd projeto_integrador

- Instale as dependências do projeto:

      mvn clean install

- Execute o servidor:

      mvn spring-boot:run

O servidor estará sendo escutado na porta indicada na IDE. Geralmente, trata-se da porta 8080.

___
<a name="Dependências"></a>
## 🏁 Dependências

Foram utilizadas no projeto as seguintes dependências:

- 🍃 Spring Boot Dev Tools;

- 🍃 Spring Boot Web;

- 🍃 Spring Boot Stater Validations;

- 🌶️ Lombok;
  
- 🍃 Spring Data JPA
  
- 🐬 MySQL Driver
___

<a name="Coleção-de-Requisições"></a>

## 🌙 Coleção de Requisições

A coleção de requisições utilizadas para testar os endpoints estão na pasta `/Docs`. O arquivo `Projeto-Integrador.postman_collection.json` pode ser importado em algum cliente HTTP, como o Postman ou o Insomnia.

---

## <img alt="coffee_cup" src="https://user-images.githubusercontent.com/80721339/173413428-56d4f208-6f5f-437d-ad91-cb878a90a01a.png" width="30px" /> Java Docs

Criou-se também uma documentação da aplicação, utilizando a ferramenta Java Docs, que pode ser consultada seguindo os passos a seguir:

1 - À partir da IDE de sua preferência, basta rodar o comando: `mvn javadoc:javadoc`. Esse comando fará o build da documentação e criará uma pasta chamada **target**.

2 - Agora basta localizar o arquivo `index-all.html` -> clicar com o botão direito em "Open" -> escolher o browser de sua preferência. Ao clicar, será aberta uma página contendo a documentação.

___

<a name="Autores"></a>

## 📝 Autores ##

Desenvolvido com 💛 por Amanda, Diovana, Gabriela, Rafael, Thiago Frozzi e Thiago Almeida. 

