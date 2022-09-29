# kafka Connect

### Create a MySQL Sink

```json
{
    "name": "connect-sink-orders",
    "config": {
        "connector.class": "io.confluent.connect.jdbc.JdbcSourceConnector",
        "errors.log.include.messages": "true",
        "connection.password": "root",
        "auto.register.schemas": "false",
        "tasks.max": "1",
        "query": "select * from orders",
        //"config.providers": "file",
        "mode": "bulk",
        "value.converter.schema.registry.url": "http://schema-registry:8081",
        "key.converter.schemas.enable": "false",
        //"topic.prefix": "cmd.db.investments.order.corporateeventsadm.process-corporate-event",
        "topic.prefix": "cmd.cdc.investments.order.event",
        "tables": "",
        "task.class": "io.confluent.connect.jdbc.source.JdbcSourceTask",
        "connection.user": "root",
        "poll.interval.ms": "10000",
        "name": "connect-sink-orders",
        "value.converter.schemas.enable": "true",
        //"config.providers.file.class": "org.apache.kafka.common.config.provider.FileConfigProvider",
        "connection.url": "jdbc:mysql://mysql:3306/orderdb",
        "value.converter": "io.confluent.connect.avro.AvroConverter",
        "errors.log.enable": "true",
        "key.converter": "org.apache.kafka.connect.storage.StringConverter",
        "key.converter.schema.registry.url": "http://schema-registry:8081"
    },
    "tasks": [
        {
            "connector": "connect-sink-orders",
            "task": 0
        }
    ],
    "type": "source"
}
```

Create a Connect

```sh
curl -i -X POST -H  "Content-Type:application/json" \
    http://localhost:8083/connectors \
    -d '{
    "name": "connect-sink-orders",
    "config": {
        "connector.class": "io.confluent.connect.jdbc.JdbcSourceConnector",
        "errors.log.include.messages": "true",
        "connection.password": "root",
        "auto.register.schemas": "false",
        "tasks.max": "1",
        "query": "select * from orders",
        "mode": "bulk",
        "value.converter.schema.registry.url": "http://schema-registry:8081",
        "key.converter.schemas.enable": "false",
        "topic.prefix": "cmd.cdc.investments.order.event",
        "tables": "",
        "task.class": "io.confluent.connect.jdbc.source.JdbcSourceTask",
        "connection.user": "root",
        "poll.interval.ms": "10000",
        "name": "connect-sink-orders",
        "value.converter.schemas.enable": "true",
        "connection.url": "jdbc:mysql://mysql:3306/orderdb",
        "value.converter": "io.confluent.connect.avro.AvroConverter",
        "errors.log.enable": "true",
        "key.converter": "org.apache.kafka.connect.storage.StringConverter",
        "key.converter.schema.registry.url": "http://schema-registry:8081"
    },
    "tasks": [
        {
            "connector": "connect-sink-orders",
            "task": 0
        }
    ],
    "type": "source"
}'
``` 

```sh
curl -i -X PUT -H  "Content-Type:application/json" \
    http://localhost:8083/connectors/connect-sink-orders/config \
    -d '{
            "connector.class": "io.debezium.connector.mysql.MySqlConnector",
            "value.converter": "io.confluent.connect.json.JsonSchemaConverter",
            "value.converter.schemas.enable": "true",
            "value.converter.schema.registry.url": "http://schema-registry:8081",
            "database.hostname": "mysql",
            "database.port": "3306",
            "database.user": "root",
            "database.password": "root",
            "database.server.id": "42",
            "database.server.name": "mysql",
            "table.whitelist": "orderdb.orders",
            "database.history.kafka.bootstrap.servers": "broker:9092",
            "database.history.kafka.topic": "cmd.cdc.investments.order.event",
            "topic.creation.default.replication.factor": "1",
            "topic.creation.default.partitions": "1",
            "decimal.handling.mode": "double",
            "include.schema.changes": "true",
            "transforms": "unwrap,addTopicPrefix",
            "transforms.unwrap.type": "io.debezium.transforms.ExtractNewRecordState",
            "transforms.addTopicPrefix.type":"org.apache.kafka.connect.transforms.RegexRouter",
            "transforms.addTopicPrefix.regex":"(.*)",
            "transforms.addTopicPrefix.replacement":"mysql-debezium-$1"
    }'
``` 

```sql
INSERT INTO `orders` (`id`, `product`, `createat`) VALUES (NULL, 'aaa', CURRENT_TIMESTAMP);
```
