<#include "resources/style.ftlh">
<#include "resources/header.ftlh">
<#include "resources/jquery.ftlh">
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
<@header/>
<body>
<#if message?has_content>
    <div class = "header_basic_image">${message}</div>
</#if>
<h1>ban all users:</h1>
<form action="/banAll" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="ban all">
</form>
<h1>ban user by id:</h1>
<form action="/ban" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="text" name="id" placeholder="user id">
    <input type="submit" value="ban">
</form>
<h1>unban all users:</h1>
<form action="/unBanAll" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="unban all">
</form>
<h1>unban user by id:</h1>
<form action="/unBan" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="text" name="id" placeholder="user id">
    <input type="submit" value="unban">
</form>
<h1>delete image post by id:</h1>
<form action="/deleteImagePost" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="text" name="id" placeholder="image post id">
    <input type="submit" value="delete">
</form>

<h1>delete all image posts:</h1>
<form action="/deleteAllImagePosts" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="delete all">
</form>



</body>
</html>