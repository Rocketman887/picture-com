<#include "resources/style.ftlh">
<#include "resources/header.ftlh">
<#include "resources/jquery.ftlh">

<!doctype html>
<html lang="en">
<#import "spring.ftl" as spring>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>signIn</title>
    <@jquery/>
    <@style/>
</head>
<body>
<@header/>
<div class="signIn_layout">
    <div class="signIn_title"></div>
    <form action="/signIn" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input id="login" type="email" minlength="5" name="email" placeholder="email" class="login_input"/>
        <input id = "password" type="password" name="password" minlength="5" placeholder="password" class="password_input"/>
        <label>
            <input type="checkbox" name="remember-me">remember me
        </label>
        <input type="submit" value="signIn" class="signInSubmit"/>
        <a href="http://localhost:8080/signUp">
            Don't have an account yet? Sign up!
        </a>
    </form>
</div>
</body>
</html>