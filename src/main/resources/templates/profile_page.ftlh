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
    <title>profile</title>
    <@jquery/>
    <@style/>
</head>
<body>
<#if message?has_content>
    <div class = "header_basic_image">${message}</div>
</#if>
<@header/>

<div class="user_profile_data">
    <img class="profile_image" src="/img/${userDTO.getImagePath()}">
    <div style="display: block">
    <div class="user_profile_textData">
        <h4>Username: ${userDTO.getName()}</h4>
        <h4>Email: ${userDTO.getEmail()}</h4>
        <h4></h4><a href="http://localhost:8080/myImagePosts" style="color: white" >Your image posts</a></h4>
    </div>
    <a href="http://localhost:8080/editProfile"><button class="edit_profile_button">Edit Profile</button></a>
        <#if admin?has_content>
            <a href="http://localhost:8080/admin"><button class="edit_profile_button">Admin panel</button></a>
        </#if>
    </div>
</div>
</body>
</html>