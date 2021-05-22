<#macro header>
    <div class="appHeader">
        <div class="header_name_layout">
            picture.com
        </div>
        <div class="header_navigation_list">
            <div class="header_navigation_item"><a class="header_nav_item_href"
                                                   href="http://localhost:8080/imagePosts/all">
                    <@spring.message 'header.main'/>
                </a></div>
            <div class="header_navigation_item"><a class="header_nav_item_href" href="http://localhost:8080/profile">
                    <@spring.message 'header.profile'/>
                </a></div>
            <div class="header_navigation_item"><a class="header_nav_item_href" href="http://localhost:8080/search">
                    <@spring.message 'header.search'/>
                </a></div>
            <div class="header_navigation_item"><a class="header_nav_item_href" href="http://localhost:8080/imagePosts/create">
                    <@spring.message 'header.create'/>
                </a></div>
            <div class="header_navigation_item"><a class="header_nav_item_href" href="http://localhost:8080/signIn">
                    <@spring.message 'header.signIn'/>
                </a></div>
            <div class="header_navigation_item"><a class="header_nav_item_href" href="http://localhost:8080/signUp">
                    <@spring.message 'header.signUp'/>
                </a></div>
            <div class="header_navigation_item"><a class="header_nav_item_href" href="http://localhost:8080/logout">
                </a></div>
         </div>
        <div class="header_localization"><@spring.message 'header.localization'/>
            <div style="margin-left: 10px"><a class="header_nav_item_href" href="?lang=ru">RU</a></div>
            <div style="margin-left: 10px"><a class="header_nav_item_href" href="?lang=en">EN</a></div>
        </div>
        </div>
    </div>

</#macro>