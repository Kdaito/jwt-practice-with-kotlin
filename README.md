# JWT-Practice

こちらのリポジトリは、Spring BootとSpring Securityを使用し、JWT認証を実装したAPIです。

| エンドポイント   | 説明                                                                                                          |
|-----------|-------------------------------------------------------------------------------------------------------------|
| /login    | パスワードとメールアドレスをもとに認証を行い、認証が成功すればJWTを返却します。 このアプリでは、認証情報はダミーのものが用意されています。                                     |
| /greeting | 挨拶文を送ると認証情報のメールアドレスと合わせて「（挨拶文）、（認証されたメールアドレス）！」という挨拶文を返します。認証ユーザーのみがアクセスできるエンドポイントのため、ヘッダーにJWTを設定する必要があります。 |


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