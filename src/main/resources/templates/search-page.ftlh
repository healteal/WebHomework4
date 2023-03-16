<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Main page</title>
</head>
<body>
<form action="/search-page" method="get">
    Введите логин для поиска <input type="text" name="user_login">
    <input type="submit" value="Найти">
</form>
<#if answer??>
    ${answer}
</#if>
<#if userObject??>
    ${userObject.firstName} ${userObject.lastName} ${userObject.age}
</#if>
</body>
</html>