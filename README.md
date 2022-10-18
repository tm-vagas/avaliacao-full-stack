# transfer

## Sobre
   
   Este é um projeto-teste chamado **transfer**. Nele propomos o desenvolvimento de uma aplicação de transferência financeira, construída como uma REST API, com Spring Boot e consumida por uma aplicação front-end Vue JS.
   As regras de negócio da aplicação podem ser vistas no [https://github.com/tm-vagas/avaliacao-full-stack](https://github.com/tm-vagas/avaliacao-full-stack) 
   
## Tecnologias

   **Front-end:**
   
   - **Linguagem:** HTML 5, CSS 3 e JavaScript   
   - **Framework:** Bootstrap 5.2.2 e Bootstrap Icons 1.9.1
   - **Framework JS e outros:** Vue JS 3.2.13, Axios 1.1.2, Node.js 12.22.9, npm 8.19.2, Vue CLI 5.0.8, Vetur 0.36.0
   - **Browser:** Google Chrome 90.0.4430.93 (64 bits) e Mozilla Firefox 88.0 (64 bits)
   
   **Back-end, Database, Infra e Outros:**
   
   - **Linguagem:** Java 8 (OpenJDK 8)
   - **Frameworks Java:** Spring Boot 2.7.4, Spring Web (MVC e Apache Tomcat), Spring Data JPA (Hibernate), Maven
   - **Database:** H2 Database
   - **IDE:** Spring Tool Suite 4.16.0 (back-end) e Visual Studio Code 1.59.0 (front-end)
   - **OS:** Canonical Linux Ubuntu 21.04
   - **REST test:** Postman 9.31.0
   - **Data model:** BrModelo 3.31
   
## Arquiteturas e Database Project

   Para o projeto foi escolhida a Arquitetura de camadas, já muito difundida em projetos Spring Boot.
   Nesta, as classes são separadas em camadas como Controller, Service, Acesso aos Dados (Repository) e Domínio (Entity).
   
   Todas as entities (entidades) são mapeadas utilizando as anottations do Spring Data JPA (Hibernate) para o modelo relacional.
   
   O SGBD utilizado é o H2, um database de memória. Este pode ser acessado, após a inicialização do servidor (back-end), na URL 
   http://localhost:8080/h2, utilizando o usuário: admin, e a senha (password): admin123@.
   
   O database foi projetado utilizando Modelagem de Dados, a partir dos modelos Conceitual e Lógico. Para tal, o software brModelo foi utilizado e deste gerado os arquivos fonte (.brm) e os arquivos de saída (.png) que podem ser acessados no diretório /transfer-backend/src/main/java/br/com/transfer/entity/der

   ![thumb](/transfer-backend/src/main/java/br/com/transfer/entity/der/modelo-conceitual.png)

   Figura 1 - DER (Modelo Conceitual)

   ![thumb](/transfer-backend/src/main/java/br/com/transfer/entity/der/modelo-logico.png)

   Figura 2 - DER (Modelo Lógico)
   
   Também foram adicionadas propriedades no arquivo application.properties, a fim de permitir o acesso ao H2 database, por meio de seu console web, configurações para exibir no console do Tools, o código SQL gerado pelo Hibernate a cada transação no banco, além de outras configurações.
   
   Como gerador de números identificadores das contas bancárias no padrão XXXXXX, foi utilizado uma SEQUENCE, startando no número 100000.
   
   Como política de CORS, foi configurado um header permissivo somente para a aplicação front-end (cliente), cuja URL é http://localhost:8081  

## Instalação

   **BACK-END**

   1. Instale o [OpenJDK 8+](https://openjdk.java.net/) (ou [JDK 8+](https://www.oracle.com/java/), se preferir) e defina as variáveis de ambiente do Java;
   2. Instale o [Spring Tool Suite 4.16.0](https://spring.io/tools).
   3. Instale um browser de sua preferência;
   4. Baixe o zip do GitHub, descompacte e abra o projeto no Spring Tool Suite: File > Open Projects from File System... > Directory > Localize e selecione o diretório transfer-backend
   5. Para executar, clique sobre o projeto e em seguida pressione Run or Run as > Spring Boot App.
   6. Após o start do server Apache Tomcat, vá ao browser e acesse: http://localhost:8080, que é a URL raiz do projeto.
   7. Já para acessar a REST API, siga http://localhost:8080/api/{query} 
   A query representa as operações:
   
      Usuário:
         - POST: /usuarios
         - PUT: /usuarios/{usuarioId}
         - DELETE: /usuarios/{usuarioId}
         - GET: /usuarios e /usuarios/{usuarioId}       
      
      Conta Bancária:
         - POST: /contas_bancarias/{usuarioId}
         - PUT: /contas_bancarias/{contaBancariaId}
         - DELETE: /contas_bancarias/{contaBancariaId}
         - GET: /contas_bancarias e /contas_bancarias/{contaBancariaId}
       
       Transferência:
         - POST: /transferencias/{contaBancariaOrigemId}/{contaBancariaDestinoId}
         - PUT: /transferencias/{transferenciasId}
         - DELETE: /transferencias/{transferenciasId}
         - GET: /transferencias e /usuarios/{transferenciasId} 

   8. Para visualizar/interagir com o database, acesse siga http://localhost:8080/h2. Usuário: admin, Senha: admin123@
   9. As operações também podem ser testadas com o Postman
   
   **FRONT-END**
   
   1. Abra o terminal/prompt 
   2. cd your-path-front-end/transfer-frontend /* Acesse  o diretório do app cliente */
   3. npm run serve /* start a aplicação/servidor */
   4. Siga http://localhost:8081
   5. Nota: para startar é necessário ter instalado o Node JS e o NPM
   6. Ao iniciar, você visualizará um dashboard, com todas as operações disponíveis para teste. Assim crie usuários, crie contas bancárias e crie as tranferências. Cada operação retornará uma mensagem na tela de sucesso ou erro, dependendo dos dados informados no input.