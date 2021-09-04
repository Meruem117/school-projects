<%-- 
    Document   : 9
    Created on : 2019-12-18, 17:07:36
    Author     : Meruem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Return</title>
    </head>
    <body style="font-size: 25px;background: url('picture/4.jpg') no-repeat;background-size:100% 100%;background-attachment: fixed;">
        <div style="width: 30%;height: 250px;border: 2px solid white;background-color: #ccccff;opacity:0.6;filter:alpha(opacity=60);margin-top: 200px;margin-left: 700px">
            <form action="returnbook" method="get" style="font-size: 30px;text-align: center">
                <br>
                Booknumber : <input type="text" name="bn" style="width:150px;height: 30px"> <br><br>
                Username : <input type="text" name="un" style="width:150px;height: 30px"> <br><br>
                <input type="submit" value="Return" style="font-size: 25px" onclick="bClick()">
            </form>
        </div>
        <script>
            function bClick()
            {
                alert("Return Successfully");
            }
        </script>
        <div style="position:absolute; right:50px; bottom:50px;">
            <input type="button" value="Home" onClick="javascrtpt:window.location.href = 'admin.html'" style="font-size: 30px;font-family:fantasy">
        </div>
    </body>
</html>
