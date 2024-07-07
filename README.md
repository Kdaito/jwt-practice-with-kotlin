## 1. ログインする

| 仮パスワード   | メールアドレス |
|----------|---------|
| password | user@example.com      |

```shell
curl -X POST http://localhost:8080/login \
-H "Content-Type: application/json" \
-d '{"email": "user@example.com", "password": "password"}'
```

正常にAPIが動いていれば、JWTが返却されます。


## 2. JWTを使用してリクエストする

```shell
TOKEN="取得したJWT"

curl -X POST http://localhost:8080/greeting \
-H "Content-Type: application/json" \
-H "Authorization: Bearer $TOKEN" \
-d '{"greeting": "Hello"}'
```