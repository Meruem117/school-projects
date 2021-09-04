<%-- 
    Document   : home
    Created on : 2020-6-19, 23:12:49
    Author     : Meruem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="hbase.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete</title>
    </head>
    <body>
        <%
            Hbase h=new Hbase();
            
            String id = request.getParameter("id");
            String cname = request.getParameter("cname");
            
            h.deleteColumn("logs",id,"cf",cname);
        %>
        <div style="text-align:center;height:40px; line-height:40px;font-family: cursive;">
            <p style="font-size: 30px">Successfully Delete</p>
            <a href="analysis.html" style="font-size:25px;">Click here to continue</a>
        </div>
    </body>
</html>
