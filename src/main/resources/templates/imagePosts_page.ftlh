<#include "resources/style.ftlh">
<#include "resources/header.ftlh">
<#import "resources/pager.ftlh" as p>
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
<#if message?has_content>
    <div class = "header_basic_image">${message}</div>
</#if>
<@header/>
<@p.pager url page/>
<div class="imagePost_wrapper_block">
<#list page.content as imagePost>
        <a href="http://localhost:8080/imagePosts/${imagePost.id}"><img class="image" src="/img/${imagePost.imagePath}"/></a>
</#list>
</div>
</div>
</body>
</html>