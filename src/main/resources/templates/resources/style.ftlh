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
            margin-left: 160px;
            margin-top: 20px;
            font-size: 16px;
            font-weight: bold;
            display: flex;
        }
        .header_navigation_item{
            margin-left: 24px;
            background: #DB3727;
            color: white;
        }
        .header_nav_item_href{
            text-decoration: none;
            color: white;
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
        .header_basic_message{
            background-color: bisque;
            color: red;
        }
        .basic_image{
            height: 50%;
            width: 50%;
        }
        .image{
            height: 15%;
            width: 15%;
        }
        .user_mini_image{
            height: 25%;
            width: 25%;
            border-radius: 200px;
        }
        .imagePost_wrapper_block{
            display: block;
        }
        .imagePost_wrapper_flex{
            display: flex;
        }
        .header_localization{
            margin-top: 20px;
            font-size: 16px;
            font-weight: bold;
            display: flex;
        }
        .search_wrapper{
            margin-left: 200px;
            padding-left: 40px;
            padding-top: 40px;
            height: 450px;
            width: 1100px;
            margin-top: 40px;
            background:#DB3727;
            border-radius: 10px;
        }
        .search_head_wrapper{
            color: white;
        }
        .search_category_wrapper{
            font-weight: bold;
            color: white;
        }
        .search_button{
            color: white;
            font-weight: bolder;
            background-color: cadetblue;
            text-align:center;;
            width:150px;
            height: 30px;
        }
        .profile_block_wrapper{
            margin-left: 400px;
            margin-top: 40px;
            padding-left: 40px;
            color: white;
            background-color: #DB3727;
            height: 200px;
            width: 400px;
            border-radius:10px;
            display: block;
        }
        .profile_data_wrapper{
            display: block;
            padding-top: 20px;
            padding-left: 20px;
            font-weight: bolder;
        }
        .edit_profile_button{
            color: white;
            font-weight: bold;
            background-color: cadetblue;
            margin-top: 20px;
            margin-left: 20px;
            width:150px;
            height: 30px;
        }
        .admin_panel_button{
            color: white;
            font-weight: bold;
            width:150px;
            height: 30px;
            background-color: cadetblue;
            margin-top: 20px;
            margin-left: 20px;
        }
        .profile_image{
            height: 20%;
            width: 20%;
            margin-top: 20px;
        }

        .user_profile_data{
            margin-left: 350px;
            font-size: 30px;
            margin-top: 20px;
            display: flex;
            width: 800px;
            background-color: #DB3727;
            border-radius:10px ;
        }
        .user_profile_textData{
            font-size: 30px;
            margin-left: 20px;
            font-weight: bold;
            color: white;
            display: block;
        }
        .imagePost_card_wrapper{
            margin-left: 350px;
            font-size: 20px;
            margin-top: 20px;
            display: flex;
            height: 700px;
            color: white;
            width: 900px;
            background-color: #DB3727;
            border-radius:10px ;
        }
        .imagePost_card{
            display: block;
            padding-top: 20px;
            padding-left: 20px;
            font-weight: bolder;
        }
        .createPost_card{
            height: 500px;
            width: 300px;
            background: #DB3727;
            color: white;
            margin-left: 600px;
            margin-top: 40px;
            padding-left: 20px;
            padding-top:20px;
        }
    </style>
</#macro>