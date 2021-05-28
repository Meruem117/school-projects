<%-- 
    Document   : 2
    Created on : 2019-11-29, 18:17:48
    Author     : Meruem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>User</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head> 
    <body style="background: url('picture/3.jpg')no-repeat;background-size: 100% 100%;background-attachment: fixed">
        <div style="float: left;width: 30%;height: 550px;border: 2px solid white;margin-left: 300px;background-color: #ccccff;opacity:0.6;filter:alpha(opacity=60);margin-top: 100px">
            <form action="regist" method="post" style="font-size: 25px">
                <br>
                Username:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name" style="width:150px;height: 30px"><br><br>
                Password:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="password" style="width:150px;height: 30px"><br><br>
                Confirm:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="password2" style="width:150px;height: 30px"><br><br>
                E-mail:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="email" name="email" style="width:150px;height: 30px"><br><br>
                Phone Number:<input type="number" name="phone" style="width:150px;height: 30px"><br><br>
                Age:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="age" style="width:150px;height: 30px"><br><br>
                Balance:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="balance" style="width:150px;height: 30px"><br><br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="Add" style="font-size: 20px;font-family: Segoe Print;margin-left: 25px" onclick="aClick()">
            </form>
            <script>
                function aClick()
                {
                    alert("Add Successfully");
                }
            </script>
        </div>
        <div style="float: right;width: 30%;height: 500px;border: 2px solid white;margin-right: 300px;background-color: #ccccff;opacity:0.6;filter:alpha(opacity=60);margin-top: 100px">
            <form action="withdraw" style="font-size: 25px" method="get">
                <br>
                Username:<input type="text" name="delete" style="width:150px;height: 30px;"><br><br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="Delete" style="font-size: 20px;font-family: Segoe Print;margin-left: 25px;" onclick="bClick()">
            </form>
        </div>
        <script>
            function bClick()
    {
	alert("Delete Successfully");
    }
        </script>
        <div style="position:absolute; right:50px; bottom:50px;">
                <input type="button" value="Home" onClick="javascrtpt:window.location.href='admin.html'" style="font-size: 30px;font-family:fantasy">
        </div>
    </body>
</html>
