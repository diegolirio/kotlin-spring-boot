# Order

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
    http://localhost:8080/api/orders/632e7780ce8eeb42dc29b1be
```