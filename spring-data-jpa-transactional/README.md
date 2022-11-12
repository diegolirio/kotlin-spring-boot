# Transactional

## TODO

1. Create Everything
2. Error emmit Rollback
3. AbstractEntity -> id, createdBy, createdAt, updatedAt

## Request

```sh
curl --location --request POST 'http://localhost:8080/v1/orders' \
--header 'Content-Type: application/json' \
--data-raw '{
    "customer": {
        "id": null,
        "cpfCnpj": 35357659869,
        "name": "Diego Lirio",
        "address": {
            "id": null,
            "description": "Av Paulista, 2733 - Bela Vista - São Paulo"
        }
    },
    "items": [
        {
            "product": {
                "id": null,
                "description": "Capinha iPhone 13 PRO Max"
            },
            "amount": 3,
            "price": "19.90"
        }
    ],
    "createdBy": "ddamacena"
}'
```