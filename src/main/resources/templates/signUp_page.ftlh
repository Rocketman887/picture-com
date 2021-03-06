<#include "resources/style.ftlh">
<#include "resources/header.ftlh">
<!doctype html>
<html lang="en">
<#import "spring.ftl" as spring>

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>signUp</title>
    <@style/>
</head>
<body>
<@header/>
<div class="signUp_layout">
    <div class="signUp_title"><@spring.message 'signUp_page.registration.title'/></div>
    <@spring.bind "userForm"/>
    <form action="/signUp" method="post">
        <@spring.formInput "userForm.email" "class = \"login_input\" name=\"email\" placeholder = \"email\"" "email" />
        <@spring.showErrors "<br>" "error" />
        <@spring.formInput "userForm.name" "class = \"login_input\" name=\"name\" placeholder = \"name\"" "text" />
        <@spring.showErrors "<br>" "error" />
        <@spring.formInput "userForm.password" "class = \"password_input\" name=\"password\"  placeholder = \"password"\" />
        <@spring.showErrors "<br>" "error" />
        <label>
            <input type="checkbox" name="remember-me">remember me
        </label>
        <input type="submit" value="signUp" class="signInSubmit"/>
        <a href="http://localhost:8080/signIn">
            Already have an account? Sign In!
        </a>
    </form>
</div>
</body>
</html>