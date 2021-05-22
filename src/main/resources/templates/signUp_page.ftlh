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
    <title>signUp</title>
    <@jquery/>
    <@style/>
</head>
<body>
<#if message?has_content>
    <div class = "header_basic_image">${message}</div>
</#if>
<@header/>
<div class="signUp_layout">
    <div class="signUp_title"><@spring.message 'signUp_page.title'/></div>
    <@spring.bind "userForm"/>
    <form action="/signUp" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <@spring.formInput "userForm.email" "class = \"login_input\" name=\"email\" placeholder = \"email\"" "email" />
        <@spring.showErrors "<br>" "error" />
        <@spring.formInput "userForm.name" "class = \"login_input\" name=\"name\" placeholder = \"name\"" "text" />
        <@spring.showErrors "<br>" "error" />
        <@spring.formInput "userForm.password" "class = \"password_input\" name=\"password\"  placeholder =\"password\"" />
        <@spring.showErrors "<br>" "error" />
        <label>
            <input type="checkbox" name="remember-me"><@spring.message 'remember.me'/>
        </label>
        <input type="submit" value="signUp" class="signInSubmit"/>
        <a href="http://localhost:8080/signIn">
            <@spring.message 'signUp_page.message'/>
        </a>
    </form>
</div>
</body>
</html>