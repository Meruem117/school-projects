<%-- 
    Document   : 1
    Created on : 2019-11-29, 18:17:42
    Author     : Meruem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Books</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body  style="background: url('picture/2.jpg') no-repeat; background-size: 100% 100%; background-attachment: fixed;">
        <div style="float: left;width:35%;height:600px;border:2px solid white;margin-left: 220px;background-color:rgba(100,150,150,0.6);margin-top: 100px">
            <form action="add" style="font-size: 25px">
                <br>
                Book No:<input type="text" name="no" style="width:150px;height: 30px"><br><br>
                Book Name:<input type="text" name="name" style="width:150px;height: 30px"><br><br>
                Author:<input type="text" name="author" style="width:150px;height: 30px"><br><br>
                Date:<input type="text" name="date" style="width:150px;height: 30px"><br><br>
                Category:<input type="text" name="category" style="width:150px;height: 30px"><br><br>
                Price: <input type="text" name="price" style="width:150px;height: 30px"><br><br>
                Total Number:<input type="text" name="tnum" style="width:150px;height: 30px"><br><br>
                Availiable Number:<input type="text" name="anum" style="width:150px;height: 30px"><br><br>
                <input type="submit" value="Add" style="font-size: 20px;font-family: Segoe Print;margin-left: 25px" onclick="aClick()">  <br>           
            </form>
        </div>
        <script>
            function aClick()
            {
                alert("Add Successfully");
            }
        </script>
        <div  style="width:35%;height:450px;border:2px solid white;background-color:rgba(100,150,150,0.6);float: right;margin-right: 220px;margin-top: 100px">
            <form action="delete" style="font-size: 25px">
                <br>
                Book No:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="bn" style="width:150px;height: 30px"><br><br>
                <input type="submit" value="Delete" style="font-size: 20px;font-family: Segoe Print;margin-left: 25px" onclick="bClick()">  
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
