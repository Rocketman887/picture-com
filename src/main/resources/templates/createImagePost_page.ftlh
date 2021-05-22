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
<div class="createPost_card">
<form action="/imagePosts/create" method="post" enctype="multipart/form-data">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <h2><@spring.message 'createImagePost_page.title'/></h2>
    <input required type="text" name="title" placeholder="title"/>
    <h2><@spring.message 'createImagePost_page.tag'/></h2>
    <input required type="text" name="tag" placeholder="tag"/>
    <h2><@spring.message 'createImagePost_page.type'/></h2>
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
    <h2><@spring.message 'createImagePost_page.image'/></h2>
    <input required align="center" type="file" name="file">
    <h2><@spring.message 'createImagePost_page.description'/></h2>
    <textarea name = "description" placeholder="Description"></textarea>
    <input  class="search_button" type="submit" value="add image post"/>
</form>
</body>
</html>