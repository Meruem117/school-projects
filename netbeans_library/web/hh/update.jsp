<%-- 
    Document   : update
    Created on : 2020-6-20, 0:30:14
    Author     : Meruem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="hbase.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
       <%
            Hbase h=new Hbase();
            
            String id = request.getParameter("id");
            String cname = request.getParameter("cname");
            String value = request.getParameter("value");
            
            h.updateTable("logs",id,"cf",cname,value);
        %>
        <div style="text-align:center;height:40px; line-height:40px;font-family: cursive;">
            <p style="font-size: 30px">Successfully Update</p>
            <a href="analysis.html" style="font-size:25px;">Click here to continue</a>
        </div>
    </body>
</html>
