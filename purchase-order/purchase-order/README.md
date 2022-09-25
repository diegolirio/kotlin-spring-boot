# Order

## Tasks

## Kafka Command Line

```shell
# enter in container
docker exec -it broker bash
```
```shell
# consumer docker
/bin/kafka-console-consumer --topic cmd.dsr.investments.order.registration --bootstrap-server=broker:9092
```
```shell
# consumer remote
/bin/kafka-console-consumer --topic cmd.dsr.investments.order.registration --bootstrap-server=meu.broker1.com:9092,meu.broker2.com:9092
```
```shell
# producer
/bin/kafka-console-producer --topic cmd.dsr.investments.order.registration --bootstrap-server=localhost:9092
```

## Requests

Generate Order

```shell
curl -i -X POST -H  "Content-Type:application/json" \
    http://localhost:8080/api/orders \
    -d '{
            "productCode": "17a7c157-e164-4a54-b449-adbb7f8f5c21",
            "customerId": "57f4ee10-a8d4-47f2-95de-11efc75ac227",
            "value": "5500.00"
    }'
```

```shell
curl -i -X GET -H  "Content-Type:application/json" \
    http://localhost:8080/api/orders
```

```shell
curl -i -X GET -H  "Content-Type:application/json" \
    http://localhost:8080/api/orders/632e7780ce8eeb42dc29b1be
```

Gradle

> Build generated in `./build/libs/app.jar`
```shell
./gradlew build -x test
```
> Detecting code smells and it is generated in `./build/reports/detekt`. 
> You can open the `detekt.html` in the Browser  
```shell
./gradlew detekt
```
> Run app 
```shell
./gradlew bootRun
```
> Tests 
> // TODO with jacoco
```shell
./gradlew test
```

Docker 

> Build
```sh
./gradlew build
docker build -t liriotech/purchase-order .
```
