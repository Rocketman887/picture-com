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

<img class="basic_image" src="/img/${imagePost.getImagePath()}">
<h1>${imagePost.getTag()}</h1>
<h1>${imagePost.getTitle()}</h1>
<h1>${imagePost.getType()}</h1>

<form action="/imagePosts/delete/${imagePost.id}" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input  class="image_button" type="submit" value="Delete"/>
</form>

<form action="/imagePosts/update/${imagePost.id}" method="post" enctype="multipart/form-data">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input required type="text" name="title" placeholder="title"/>
    <input required type="text" name="tag" placeholder="tag"/>
    <label for = "type">Category</label>
    <select id="type" name="type">
        <option value="all">All</option>
        <option value="nature">Nature</option>
        <option value="films">Films</option>
        <option value="abstractions">Abstractions</option>
        <option value="cars">Cars</option>
        <option value="sport">Sport</option>
        <option value="sport">Other</option>
    </select>
    <input required align="center" type="file" name="file">
    <textarea required name="text" placeholder="Description">
        ${imagePost.getDescription()}
    </textarea>
    <input  class="image_button" type="submit" value="ENTER"/>
</form>
</body>

</html>