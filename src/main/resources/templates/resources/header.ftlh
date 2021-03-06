<#macro header>
    <div class="appHeader">
        <div class="header_name_layout">
            picture.com
        </div>
        <script type="application/javascript">
            function search() {
                let token = $("meta[name='_csrf']").attr("content");
                let header = $("meta[name='_csrf_header']").attr("content");
                let form = $("#searchForm")[0];
                let data = getFormData($("#searchForm"));
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
            <input class = "header_input" type="text" name="title" id="title" placeholder="Insert the title or tag"/>
            <button type="button" onclick="search()">Search</button>
        </form>
        <h2><a href="?lang=ru">RU</a></h2>
        <h2><a href="?lang=en">EN</a></h2>
        <div><a href="http://localhost:8080/logout"></a></div>
    </div>
</#macro>