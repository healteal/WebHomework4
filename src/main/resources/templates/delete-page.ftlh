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
<form action="/delete-page" method="post">
    Введите логин для удаления <input type="text" name="user_login">
    <input type="submit" value="Удалить">
</form>
<#if response??>
    ${response}
</#if>
</body>
</html>