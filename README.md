# Agendamento de Transferências Financeiras 

 
# Desenvolvimento BackEnd

## Tecnologias Utilizadas
* Spring Boot 2.7.2
* Java 11
* h2database

## Ferramentas Desenvolvovimento
* IDE IntelliJ Community
* Postman 

## Ferramentas Publicação Aplicação
* Apache Maven 3.8.6


# Desenvolvimento FrontEnd

## Tecnologia Utlizadas
* vue 3
* vue-router 4
* axios 0.21.1
* bootstrap 4

## Ferramentas Desenvolvovimento
* Visual Studio Code

## Referência de Estudo (conforme comentado na entrevista não tenho experiência em front)
`https://www.bezkoder.com/vue-3-crud/`


## Publicação BackEnd
No prompt do windows, diretorio raiz do projeto backend-transferencia-financeira

```
mvn spring-boot:run
```
`http://localhost:8080`


## Publicação FrontEnd
No prompt do windows, diretorio raiz do projeto frontend-transferencia-financeira

```
npm run serve 
```

`http://localhost:8081/`


# Teste Funcional BackEnd

A API possuo dois serviços:

    - Lista Agendamentos
    http:// localhost:8080/api/transferencia/lista-agendamentos
    
    - Agendamento 
    http:// localhost:8080/api/transferencia/agendamento

Ambos serviços poderam ser testados via Postman através da collection teste-tokio.postman_collection.json disponibilizada na raiz do repo do projeto.

## Status Code 
    - Lista Agendamentos
    200 - OK - Caso exista agendamentos, lista todos os agendamento, não possuindo agendamentos retorna vazio;

    - Agendamentos 
    200 - Agendamento de transferencia efetuado com sucesso
    422 - Erro no calculo e aplicacao da taxa
    500 - Erro no agendamento

# Teste Funcional FrontEnd

Através do Google Chrome executar a url do front `http://localhost:8081/`
