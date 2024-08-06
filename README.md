![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/Rabbitmq-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

# Desafio Engenheiro de software - BTG Pactual

## Escopo
Processar pedidos e gerar relatório.

Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Data MongoDB
* RabbitMQ
* Docker

## Atividades
1. Elabore e entregue um plano de trabalho.
   - Crie suas atividades em tasks
   - Estime horas
2. Crie uma aplicação, na tecnologia de sua preferência (JAVA, DOTNET, NODEJS)
3. Modele e implemente uma base de dados (PostgreSQL, MySQL, MongoDB).
4. Crie um micro serviço que consuma dados de uma fila RabbitMQ e grave os dados para conseguir listar as informações:
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


5. Crie uma API REST, em que permita o consultar as seguintes informações:
   - Valor total do pedido
   - Quantidade de Pedidos por Cliente
   - Lista de pedidos realizados por cliente
   

6. Relatório Técnico explicando de forma sumarizada, considerando:
   - Plano de Trabalho (previsto vs realizado)
   - Caso haja algum desvio entre o planejamento original e a execução, explique o que houve.
   - Caso o plano de trabalho foi seguido sem desvio, comente os motivos para esse resultado.
   - Tecnologias utilizadas
   - Linguagens, Versões, IDE's, SO's
   - Diagrama de arquitetura
   - Modelagem da base de dados
   - Diagrama de implantação da solução
   - Diagrama de infra com os recursos de cloud utilizados (máquina, SO, produtos específicos, etc.)
   - Evidência de Testes funcionais da aplicação
   - Publique os códigos gerados, em seu perfil do https://github.com/
   - Cite no relatório: 
     - O seu perfil gitHub e a(s) URL(s) onde se encontram os códigos gerados
     - Referências utilizadas
     - Demais itens que você julgar relevante (Framework ou técnicas de testes, metodologias, etc.)
     - Se foi utilizado o Docker, para montagem do Ambiente, publique em seu perfil do http://hub.docker.com as imagens finais
     - Cite no relatório: O seu perfil dockerHub e a(s) URL(s) onde se encontram as imagens geradas