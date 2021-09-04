<%-- 
    Document   : change
    Created on : 2019-12-8, 15:29:24
    Author     : Meruem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change</title>
    </head>
    <body style="background: url('picture/6.jpg') no-repeat;background-size:100% 100%;background-attachment: fixed;font-size: 30px;margin-left:50px;">
        <%
            response.setContentType("text/html");
            String name = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phone = request.getParameter("phonenumber");
            String age = request.getParameter("age");
            String balance = request.getParameter("balance");
            String books = request.getParameter("books");
            
            out.print("<form action='change'>");
            out.print("Username:"+name);
            out.println("<input type='hidden' name='name' value ='"+ name +"' style=\"width:150px;height: 30px\"><br><br>");
            out.print("Password:"+password);
            out.print("&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='password' value ='"+password+"' style=\"width:150px;height: 30px\"><br><br>");
            out.print("Email:"+email);
            out.print("&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='email' value ='"+email+"' style=\"width:150px;height: 30px\"><br><br>");
            out.print("Phonenumber:"+phone);
            out.print("&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='phone' value ='"+phone+"' style=\"width:150px;height: 30px\"><br><br>");
            out.print("Age:"+age);
            out.print("&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='age' value ='"+age+"' style=\"width:150px;height: 30px\"><br><br>");
            out.print("Balance:"+balance);
            out.print("&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='balance' value ='"+balance+"' style=\"width:150px;height: 30px\"><br><br>");
            out.print("Books:"+books);
            out.print("&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='books' value ='"+books+"' style=\"width:150px;height: 30px\"><br><br>");
            out.print("<br>&nbsp;&nbsp;&nbsp;&nbsp;<input type='submit' value='Change' style=\"font-size: 30px;\">");
            out.print("</form>");
        %>
    </body>
</html>
