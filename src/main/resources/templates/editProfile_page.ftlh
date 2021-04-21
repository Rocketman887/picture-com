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
    <title>Document</title>
    <@jquery/>
    <@style/>
</head>
<body>

<@header/>
EDIT NAME
<@spring.bind "nameEditForm"/>
<form method="post" action="/editProfile/name">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <@spring.formInput "nameEditForm.name" "class = \"password_input\" name=\"text\"  placeholder = \"name\"" />
    <@spring.formInput "nameEditForm.password" "class = \"password_input\" name=\"password\"  placeholder = \"password\"" />
    <@spring.showErrors "<br>" "error" />
    <input type="submit" value="ENTER"/>
</form>

EDIT PASSWORD
<@spring.bind "passwordEditForm"/>
<form method="post" action="/editProfile/password">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <@spring.formInput "passwordEditForm.oldPassword" "class = \"password_input\" name=\"password\"  placeholder = \"password\"" />
    <@spring.formInput "passwordEditForm.newPassword" "class = \"password_input\" name=\"password\"  placeholder = \"password\"" />
    <@spring.formInput "passwordEditForm.repeatNewPassword" "class = \"password_input\" name=\"password\"  placeholder = \"password\"" />
    <@spring.showErrors "<br>" "error" />
    <input type="submit" value="ENTER"/>
</form>

EDIT IMAGE
<div class="prof">
    <form method="post" enctype="multipart/form-data" action="/editProfile/image">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <div class="image_box">
                <div class="example-1">
                    <div class="form-group">
                        <label class="label">
                            <i class="material-icons">attach</i>
                            <span class="title">Добавить фото</span>
                            <input type="file" name="file">
                        </label>
                    </div>
                </div>
                <input class="image_button" type="submit" value="ENTER"/>
        </div>
    </form>
</body>
</html>