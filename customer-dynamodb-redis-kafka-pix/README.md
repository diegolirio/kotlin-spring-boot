# Customer DynamoDB Redis Kafka

## Arquitetura de Codigo


```
|--- customer-app
           |--- application
                      |--- gateway/provider
                      |--- entrypoint
                      |--- producer/kafka
                      |--- cache
           |--- domain
                   |--- UpdateCustomerUseCase.java
                   |--- inputs
                            |--- UpdateCustomerInput.java
                   |--- outputs
                            |--- CustomerServiceOutput.java
```                                                       

### Separar aplicacao em 2 modulos Gradle `Application e Domain`
> A ideia é que a application pensada em microservice ter tudo o
>  que seria voltado para aplicacao receber as Entradas e Saidas de Dados
>  como API Rest/Http, Databases/Repository, Cache, Brokers e etc,
> tudo isso seria os Lados da aplicacao levando em consideração
>  a imagem do Hexagono que simboliza a arquitetura...

> Domain seria o coração da aplicação, protegido de frameworks
>  como Spring, não importando qual banco estaria usando e protegendo
>  a regra de negócio com Contratos UseCase implementados por Inputs e
>  utlizando como IoC Outputs para saída para Infraestutura, o Domain
>  deve absorver todos os Principios SOLID.

### Criar um CRUD com DynamoDB usando o localstack para simular a Infra AWS

### Configurar Cacheable Spring com Redis no Controller para HttpMethods GET e nos POST, PUT, PATCH Evitar o Cache

### Criar um contexto Transacional Simulando um Envio Pix, utlizando Kafka com o ID do cliente e o valor e o codigo-pix-de-destino

### Utilizar o mesmo ID do cliente, valor e codigo-pix. Usar como teste de performance o Hey --> https://github.com/rakyll/hey

### Aplicacao devera garantir a idempotencia da transacao, onde nao importa se é executado 1 ou 2 ou 15 requests, a aplicacao devera se comportar como tivesse recebido somente 1 requisicao



Ref.:   
https://kotlindays.com/2019/12/06/multi-module-spring-boot-in-kotlin-dsl/index.html   
https://docs.gradle.org/current/userguide/kotlin_dsl.html#sec:multi_project_builds    
https://medium.com/trainingcenter/localstack-testando-servi%C3%A7os-aws-7f9f24de293c   
https://hub.docker.com/r/localstack/localstack   
https://reflectoring.io/aws-localstack/    

