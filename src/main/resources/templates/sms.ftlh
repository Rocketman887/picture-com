<#include "resources/style.ftlh">
<#include "resources/header.ftlh">
<#import "spring.ftl" as spring>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <@style/>
</head>
<body>
<@header/>

<form action="/sendSms" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="text" name="number" placeholder="telephone number">
    <input type="text" name="text" placeholder="text">
    <input type="submit" value="send">
</form>

</body>
</html>