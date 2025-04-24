![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/Rabbitmq-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

# Desafio Engenheiro de software - BTG Pactual

## Objetivo
Utilizar o RabbitMQ e consumir a mensagem. Projeto de estudo com base em conteúdo do youTube. Não foi focado em melhorias de estrutura de código do Framework Spring ou utilizar notations para performar melhor.
Foco foi um escopo geral de consumir a mensagem e obter o endPoint na sequência.

## Escopo
Processar pedidos e gerar relatório.

Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Data MongoDB
* RabbitMQ
* Docker

  ![image](https://github.com/user-attachments/assets/a8bf6e36-e6e5-4883-b12a-e90612f764cf)


## Atividades
 Crie um micro serviço que consuma dados de uma fila RabbitMQ e grave os dados para conseguir listar as informações:
   - Valor total do pedido
   - Quantidade de Pedidos por Cliente
   - Lista de pedidos realizados por cliente

Exemplo da mensagem que deve ser consumida:

```
   {
       "codigoPedido": 1001,
       "codigoCliente":1,
       "itens": [
           {
               "produto": "lápis",
               "quantidade": 100,
               "preco": 1.10
           },
           {
               "produto": "caderno",
               "quantidade": 10,
               "preco": 1.00
           }
       ]
   }
```

GET /customers/1/orders - Obter a lista de orders por Consumer


5. Crie uma API REST, em que permita o consultar as seguintes informações:
   - Valor total do pedido
   - Quantidade de Pedidos por Cliente
   - Lista de pedidos realizados por cliente
   

## Fonte do desafio:
https://www.youtube.com/watch?v=e_WgAB0Th_I

https://github.com/buildrun-tech/buildrun-desafio-backend-btg-pactual
