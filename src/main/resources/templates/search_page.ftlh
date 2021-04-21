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
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <@style/>
</head>
<@header/>
<body>

<script type="application/javascript">
    function search() {
        let token = $("meta[name='_csrf']").attr("content");
        let header = $("meta[name='_csrf_header']").attr("content");
        let form = $("#postSearchForm")[0];
        let data = getFormData($("#postSearchForm"));
        console.log(JSON.stringify(data));

        $.ajax({
            type: "POST",
            url: form.action,
            beforeSend: function (request) {
                request.setRequestHeader(header, token);
            },
            data: JSON.stringify(data),
            processData: false,
            cache: false,
            contentType: 'application/json',
            timeout: 600000,
            success: function (data) {
                var a = JSON.stringify(data);
                $('#result').text(a);
            },
            error: function (err) {
                console.log(JSON.stringify(err));
                alert(JSON.stringify(err));
            }
        });
    }
    function getFormData($form){
        var unindexed_array = $form.serializeArray();
        var indexed_array = {};

        $.map(unindexed_array, function(n, i){
            indexed_array[n['name']] = n['value'];
        });

        return indexed_array;
    }
    search()
</script>

<form id = "searchForm" action="/search">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input class = "header_input" type="text" name="title" id="title" placeholder="Insert the title or tag"/>
    <button type="button" onclick="search()">Search</button>
</form>

</body>
</html>