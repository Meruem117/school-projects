<%-- 
    Document   : regist
    Created on : 2019-11-8, 11:13:41
    Author     : Meruem
--%>

<%@page import="org.apache.log4j.Logger"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body style="background:url('picture/6.jpg') no-repeat; background-size:100% 100%; background-attachment: fixed;">
        <div style="position:absolute;top:30%;left:50%;margin:-150px 0 0 -200px;width:450px;height:610px;background-color:rgba(0,255,255,0.6)">
        <form action="regist" style="font-size: 35px;text-align: center" method="post">
            <br>
            Username : <input type="text" name="name" style="width:150px;height: 30px" placeholder="Username" required><br><br>
            Password : <input type="password" name="password" style="width:150px;height: 30px" placeholder="Password" required><br><br>
            Confirm : <input type="password" name="password2" style="width:150px;height: 30px" placeholder="Password" required><br><br>
            Email : <input type="email" name="email" style="width:150px;height: 30px" placeholder="Email" required><br><br>
            Phone : <input type="text" name="phone" style="width:150px;height: 30px" placeholder="Phone" required><br><br>
            Age : <input type="text" name="age" style="width:150px;height: 30px" placeholder="Age" required><br><br>
            <input type="submit" value="Regist" style="font-size: 25px"> <br>
        </form>
        </div>
    </body>
</html>
