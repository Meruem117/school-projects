<%-- 
    Document   : insert
    Created on : 2020-6-20, 0:30:07
    Author     : Meruem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="hbase.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert</title>
    </head>
    <body>
        <%
            Hbase h=new Hbase();
            
            String username = request.getParameter("username");
            String age = request.getParameter("age");
            String bookname = request.getParameter("bookname");
            String booktype = request.getParameter("booktype");
            String time = request.getParameter("time");
            String id = request.getParameter("id");
            
            h.updateTable("logs",id,"cf","username",username);
            h.updateTable("logs",id,"cf","age",age);
            h.updateTable("logs",id,"cf","bookname",bookname);
            h.updateTable("logs",id,"cf","booktype",booktype);
            h.updateTable("logs",id,"cf","time",time);
            
        %>
        <div style="text-align:center;height:40px; line-height:40px;font-family: cursive;">
            <p style="font-size: 30px">Successfully Insert</p>
            <a href="analysis.html" style="font-size:25px;">Click here to continue</a>
        </div>
    </body>
</html>
