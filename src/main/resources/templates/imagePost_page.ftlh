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
    <@jquery/>
    <@style/>
</head>
<body>
<@header/>

</body>
<div class="imagePost_card_wrapper">
<img class="basic_image" src="/img/${imagePost.getImagePath()}">
    <div style="display: block">
        <div class="imagePost_card">
            <div style="display: flex">
                <img class="user_mini_image" src="/img/${owner.getImagePath()}">${owner.getName()}
            </div>
            <h2><@spring.message 'createImagePost_page.title'/></h2>
            <h1>${imagePost.getTitle()}</h1>
            <h2><@spring.message 'createImagePost_page.tag'/></h2>
            <h1>${imagePost.getTag()}</h1>
            <h2><@spring.message 'createImagePost_page.type'/></h2>
            <h1>${imagePost.getType()}</h1>

        </div>
        <#if user?has_content>
            <#if imagePost.ownerId == user.getId()>
                <a href="/imagePosts/update/${imagePost.getId()}"><button>Edit</button></a>
            </#if>
        </#if>
    </div>
    <div>
</html>