# API usage examples

Create product:
```http
POST /api/v1/products
Content-Type: application/json
{"sku":"KB-100","name":"Mechanical Keyboard","description":"Compact keyboard","price":89.90,"stockQuantity":20}
```

Create customer:
```http
POST /api/v1/customers
Content-Type: application/json
{"firstName":"Ada","lastName":"Lovelace","email":"ada@example.test"}
```

Place order:
```http
POST /api/v1/orders
Content-Type: application/json
{"customerId":1,"items":[{"productId":1,"quantity":2}]}
```

All errors use a consistent JSON shape with timestamp, status, code, message, path and field errors. See `week-08/openapi.yaml` for the full contract.
