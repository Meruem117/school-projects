<%-- 
    Document   : Reset_Modify
    Created on : 2019-11-21, 22:30:19
    Author     : Lenovo
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="c.connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="newjsp.jsp">
        <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
        <title>Modify</title>
        <style type="text/css">
            body{
                margin: 0;
                padding: 0;
                background: url('picture/6.jpg') no-repeat;
                background-size:100% 100%;
                background-attachment: fixed;
            }
            .search-box{
                position: absolute;
                top:30%;
                left:50%;
                transform: translate(-50%,-50%);
                background: #2f3640;
                height: 40px;
                border-radius: 40px;
                padding: 10px;
            }
            .search-box:hover>.search-txt{
                width: 240px;
                padding: 0 6px;
            }
            .search-box:hover>.search-btn{
                background: white;
            }
            .search-btn{
                color: #e84118;
                float:right ;
                width: 40px;
                height: 40px;
                border-radius: 50%;
                background: #2f3640;
                display: flex;
                justify-content: center;
                align-items: center;
            }
            .search-txt{
                border: none;
                background: none;
                outline: none;
                float: left;
                padding: 0;
                color: white;
                font-size: 16px;
                transition: 0.4s;
                line-height: 40px;
                width: 0px;
            }
        </style>
    </head>
    <body>
        <h1 style="color: #003366;font-family:MS Reference Sans Serif;text-align: center;font-size: 60px">Modify user information</h1>
        <div class="search-box">
            <input class="search-txt" type="text" name="m" placeholder="Type the user name" >
            <a class="search-btn" href="modify.jsp?m='+ m + '">
                <i class="fas fa-search"></i>
            </a>
        </div>
        <div style="position:absolute; right:50px; bottom:50px;">
                <input type="button" value="Home" onClick="javascrtpt:window.location.href='admin.html'" style="font-size: 30px;font-family:fantasy">
        </div>
    </body>
</html>
