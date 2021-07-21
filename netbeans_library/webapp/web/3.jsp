<%-- 
    Document   : view
    Created on : 2019-12-8, 14:31:57
    Author     : Meruem
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="c.connection"%>
<%@page import="c.connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View</title>
    </head>
    <body style="background: url('picture/4.jpg') no-repeat;background-size:100% 100%;background-attachment: fixed;">
        <%
            Connection con = connection.getConnection();
            PrintWriter o = response.getWriter();
            String sql = null;
            PreparedStatement ps;
            sql = "select * from user_info ";
            String username = null, password=null,email = null, phonenumber = null;
            int age = 0, balance = 0, books = 0;
            ps = con.prepareStatement(sql);
            ResultSet rs1 = ps.executeQuery();
            while (rs1.next()) {
                username = rs1.getString(1);
                password = rs1.getString(2);
                email = rs1.getString(3);
                phonenumber = rs1.getString(4);
                age = rs1.getInt(5);
                balance = rs1.getInt(6);
                books = rs1.getInt(7);
                o.println("<p style=\"font-size: 30px;margin-left:80px;\">&nbsp;&nbsp;&nbsp;&nbsp;"+username+"&nbsp;&nbsp;&nbsp;&nbsp;"+password+"&nbsp;&nbsp;&nbsp;&nbsp;"+email
                        +"&nbsp;&nbsp;&nbsp;&nbsp;"+phonenumber+"&nbsp;&nbsp;&nbsp;&nbsp;"+age+"&nbsp;&nbsp;&nbsp;&nbsp;"
                        +balance+"&nbsp;&nbsp;&nbsp;&nbsp;"+books);
            }
        %>
        <div style="position:absolute; right:50px; bottom:50px;">
                <input type="button" value="Home" onClick="javascrtpt:window.location.href='admin.html'" style="font-size: 30px;font-family:fantasy">
        </div>
    </body>
</html>
