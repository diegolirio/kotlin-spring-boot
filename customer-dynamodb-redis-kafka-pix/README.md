# Customer DynamoDB Redis Kafka

## Running app local

> Running infra -> Dynamo, Redis, Kafka.   
> When the infra is UP, Starting Spring-Boot Application
```shell
docker-compose up
```

## Arquitetura de Codigo

```
|--- customer-app
           |--- application
                    |--- adapters
                            |--- in
                                  |--- entrypoint
                                  |--- consumer/kafka
                            |--- out
                                  |--- dataprovider
                                  |--- producer/kafka
                                  |--- cache
           |--- domain
                   |--- UpdateCustomerUseCase.java
                   |--- ports
                           |--- inputs
                                    |--- UpdateCustomerInput.java
                           |--- outputs
                                    |--- CustomerServiceOutput.java
```   

![Screen Shot 2021-09-16 at 12 07 01](https://user-images.githubusercontent.com/83074806/133637173-9090f09d-07ec-4828-9072-ef971693f182.png)
> Imagem Retirada do Livro --> [Get Your Hands Dirty on Clean Architecture by Tom Hombergs](https://www.amazon.com.br/Your-Hands-Dirty-Clean-Architecture/dp/1839211962)


## Separar aplicacao em 2 modulos Gradle `Application e Domain`
> A ideia é que a `application` pensada em microservice ter tudo o
>  que seria voltado para aplicacao receber as Entradas e Saidas de Dados
>  como API Rest/Http, Databases/Repository, Cache, Brokers e etc,
> tudo isso seria os Lados da aplicacao levando em consideração
>  a imagem do Hexagono que simboliza a arquitetura...

> `Domain` seria o coração da aplicação, protegido de frameworks
>  como Spring, não importando qual banco estaria usando e protegendo
>  a regra de negócio com Contratos UseCase implementados por Inputs e
>  utlizando como IoC os Outputs como Contrato para saída para Infraestutura, o Domain
>  deve absorver todos os Principios SOLID potencializando uma arquitetura clean.

## Criando gradle modules com DSL kotlin

No intellij  `project => New => Module...`:   
   
<img width="839" alt="Screen Shot 2021-08-13 at 14 06 52" src="https://user-images.githubusercontent.com/83074806/129394866-dce62219-4c4d-4991-a1dd-0aa82990d86b.png">
   
Selecione `Gradle` e `Module SDK` (no caso do exemplo é SDK 11) e como Additional Libraries selecione `Kotlin/JVM`:
   
<img width="785" alt="Screen Shot 2021-08-13 at 14 10 09" src="https://user-images.githubusercontent.com/83074806/129395264-3623b273-6f3a-41ec-a797-b84fdacc14fd.png">

Agora Diigite o nome do Seu Module:   

<img width="739" alt="Screen Shot 2021-08-13 at 14 10 47" src="https://user-images.githubusercontent.com/83074806/129395357-29a60322-d961-4df2-a2d0-7257088ae06b.png">

No arquivo `settings.gradle.kts` será incluído seu sub-projeto `domain`:

```kotlin
rootProject.name = "customer-dynamodb-redis-kafka-pix"
include("domain")
```

### No arquivo `build.gradle.kts` do Projeto Principal adicione o `allprojects`:

```kotlin
allprojects {
	group = "com.example"
	version = "1.0.0"

	tasks.withType<JavaCompile> {
		sourceCompatibility = "11"
		targetCompatibility = "11"
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}
}
```

E buildScript:   

```kotlin
buildscript {
	repositories {
		mavenCentral()
	}
}
``` 

Arquivo completo: https://github.com/diegolirio/kotlin-spring-boot/blob/master/customer-dynamodb-redis-kafka-pix/build.gradle.kts.   

### Sub Projeto Domain

No build.gradle.kts deverá ter algumas dependencias e deverá ser evitado frameworks e muitas libs:    

```kotlin
plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("javax.inject:javax.inject:1")
}
```

Estrutura Domain:   

<img width="443" alt="Screen Shot 2021-08-13 at 14 20 01" src="https://user-images.githubusercontent.com/83074806/129396300-7466f30b-7ea9-4949-9a16-4f8b13d1dd30.png">

###  Sub Projeto Application

> As dependencias que normalmente são utilizadas no Projeto Principal agora fica em uma camada a parte chamada `Application` que contem os Frameworks de apoio a aplicação.

```kotlin
plugins {
    id("org.springframework.boot")

    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
	implementation(project(":domain"))
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	runtimeOnly("io.micrometer:micrometer-registry-new-relic")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("com.amazonaws:aws-java-sdk-dynamodb:1.11.740")
	implementation("com.amazonaws:aws-java-sdk-core:1.11.740")
}

```

---

### Criar um CRUD com DynamoDB usando o localstack para simular a Infra AWS

[Docker-Compose.yml](./docker-compose.yml)

```shell
docker-compose up
```

> Após subir os containers você pode verificar a saúde da sua infra `curl http://localhost:4566/health`.  
   
Get All
```sh
curl --request GET --url http://localhost:8080/customers
```

Get By ID
```shell
curl --request GET \
  --url http://localhost:8080/customers/32a4b660-1df2-416b-8946-e45e92e51055
```

Post
```sh
curl --request POST \
  --url http://localhost:8080/customers \
  --header 'Content-Type: application/json' \
  --data '{
	"name": "Diego",
	"age": 15
}'
```

Put
````shell
curl --request PUT \
  --url http://localhost:8080/customers/32a4b660-1df2-416b-8946-e45e92e51055 \
  --header 'Content-Type: application/json' \
  --data '{
	"name": "Diego Lirio",
	"age": 20
}'
````

Delete
```shell
curl --request DELETE \
  --url http://localhost:8080/customers/32a4b660-1df2-416b-8946-e45e92e51055
```


Repository é acessada pelo [dataprovider](https://github.com/diegolirio/kotlin-spring-boot/tree/master/customer-dynamodb-redis-kafka-pix/application/src/main/kotlin/com/example/application/dataprovider).   

---

#### Configurar Cacheable Spring com Redis no Controller para HttpMethods GET e nos POST, PUT, PATCH e DELETE Limpar o Cache

![customer-cache](https://user-images.githubusercontent.com/83074806/129500137-2166441a-5d81-4bcf-86d6-85146ed5bdad.png)

---

### Criar um contexto Transacional Simulando um Envio Pix, utlizando Kafka com o ID do cliente e o valor e o codigo-pix-de-destino

---

### Teste de Performance :: Hey -> https://github.com/rakyll/hey 

> Utilizar o mesmo ID do cliente, valor e codigo-pix.

---

### Aplicacao devera garantir a idempotencia da transacao, onde nao importa se é executado 1 ou 2 ou 15 requests, a aplicacao devera se comportar como tivesse recebido somente 1 requisicao

---



Ref.:   
https://kotlindays.com/2019/12/06/multi-module-spring-boot-in-kotlin-dsl/index.html   
https://docs.gradle.org/current/userguide/kotlin_dsl.html#sec:multi_project_builds    
https://medium.com/trainingcenter/localstack-testando-servi%C3%A7os-aws-7f9f24de293c   
https://hub.docker.com/r/localstack/localstack   
https://reflectoring.io/aws-localstack/      
https://www.baeldung.com/spring-boot-redis-cache   


