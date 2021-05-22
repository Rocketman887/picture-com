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
    <title>search</title>
    <@style/>
</head>
<@header/>
<body>
<div class="search_wrapper">
<h1 class="search_head_wrapper">Search by title:</h1>
<form id = "title" action="/searchByTitle">
    <input class = "header_input" type="text" name="title" id="title" placeholder="Insert the title of image"/>
    <input class="search_button" id = "search_submit"type="submit" value="search by title"/>
</form>
<h1 class="search_head_wrapper">Search by tag:</h1>
<form id = "tag" action="/searchByTag">
    <input class = "header_input" type="text" name="tag" id="tag" placeholder="Insert the tag of image"/>
    <input class="search_button" id = "search_submit"type="submit" value="search by tag"/>
</form>
<h1 class="search_head_wrapper">Search by category:</h1>
<form id = "type" action="/searchByType">
    <label  class="search_category_wrapper" for = "type">Category</label>
    <select id="type" name="type">
        <option value="all">All</option>
        <option value="nature">Nature</option>
        <option value="films">Films</option>
        <option value="abstractions">Abstractions</option>
        <option value="cars">Cars</option>
        <option value="sport">Sport</option>
        <option value="sport">Other</option>
    </select>
    <input class="search_button" id = "search_submit" type="submit" value="search by category"/>
</form>

</div>

</body>
</html>