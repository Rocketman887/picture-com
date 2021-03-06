<#macro style>
    <style>
        body{
            font-family: Arial,Helvetica Neue,Helvetica,yandex-sans-rub-sign,sans-serif;
        }
        .appHeader{
            width: 100%;
            height: 56px;
            color:white;
            display: flex;
            background-color: #DB3727;
        }
        .header_name_layout{
            font-size: 36px;
            alignment: center;
            display: flex;
            margin-left: 120px;
            margin-top: 8px;
        }

        .header_navigation_list{
            margin: auto;
            line-height: 20px;
            flex-wrap: wrap;
            font-size: 16px;
            font-weight: bold;
            display: flex;
        }
        .header_navigation_item{
            margin-left: 24px;
        }
        .header_nav_item_href{
            text-decoration: none;
            color: white;
        }
        .header_nav_item_exit{
            background-image: url("drawables/logout_icon.png");
        }
        .header_profile_item{
            margin-left: 400px;
        }
        .header_input{
            margin-left: 100px;
            font-size: 20px;
            height: 36px;
            width: 800px;
            font-weight: normal;
            outline: none;
        }
        .signIn_layout{
            color: #DB3727;
            height: 400px;
            width: 280px;
            display: block;
            margin: auto;
            vertical-align: middle;
        }
        .signIn_title{
            margin: auto;
            font-size: 48px;
            text-align: center;
        }
        .signIn_login{
            font-size: 20px;
            display: block;
        }
        .login_input{
            height: 28px;
            width: 280px;
        }
        .signIn_password{
            font-size: 20px;
            display: block;
        }
        .password_input{
            height: 28px;
            width: 280px;
        }
        .signInSubmit{
            margin-top: 28px;
            height: 44px;
            width: 280px;
            background-color: #DB3727;
            color: white;
        }
        .message{
            margin:5px;
            text-align:center;
        }
        .signUp_layout{
            color: #DB3727;
            height: 400px;
            width: 280px;
            display: block;
            margin: auto;
            vertical-align: middle;
        }
        .signUp_title{
            margin: auto;
            font-size: 48px;
            text-align: center;
        }
        .signUp_login{
            font-size: 20px;
            display: block;
        }
        .signUp_password{
            font-size: 20px;
            display: block;
        }
        .signUp_submit{
            margin-top: 28px;
            height: 44px;
            width: 280px;
            background-color: #DB3727;
            color: white;
        }
        .error{
            color:red;
        }
    </style>
</#macro>