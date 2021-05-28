<%-- 
    Document   : modify
    Created on : 2019-12-8, 9:30:08
    Author     : Meruem
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="c.connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify</title>
    </head>
    <body style="background: url('picture/6.jpg') no-repeat;background-size:100% 100%;background-attachment: fixed;font-size: 25px">
        <%
            Connection con = connection.getConnection();
            String m = "abc";//request.getParameter("m");

            String sql = null;
            PreparedStatement ps;
            sql = "select * from user_info where username = ?";
            String username = null, password = null, email = null, phonenumber = null;
            int age = 0, balance = 0, books = 0;
            ps = con.prepareStatement(sql);
            ps.setString(1, m);
            ResultSet rs1 = ps.executeQuery();
            while (rs1.next()) {
                username = rs1.getString(1);
                password = rs1.getString(2);
                email = rs1.getString(3);
                phonenumber = rs1.getString(4);
                age = rs1.getInt(5);
                balance = rs1.getInt(6);
                books = rs1.getInt(7);

                out.print("<br><br>");
                out.println("Username:"+username+"<br><br>");
                out.println("Password:"+password+"<br><br>");
                out.println("Email:"+email+"<br><br>");
                out.println("Phonenumber:"+phonenumber+"<br><br>");
                out.println("Age:"+age+"<br><br>");
                out.println("Balance:"+balance+"<br><br>");
                out.println("Books:"+books+"<br><br>");
                out.println("<a href='change.jsp?username=" + username + "&password=" + password + "&email=" + email + "&phonenumber=" + phonenumber + "&age=" + age + "&balance=" + balance + "&books=" + books + "'>change</a>");
            }
        %>
        <!--
        <h2 style="font-size: 30px;margin-left:50px;margin-top: 150px">Username &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Password 
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Email 
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Phone Number 
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Age
            &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Balance 
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Books borrowed
        </h2>
        <p style="font-size: 30px;margin-left:50px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=username%>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=password%>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=email%>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=phonenumber%>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%=age%>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%=balance%>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%=books%>
            <a href="change.jsp?username=' + username + '&password=' + password + '&email=' + email + '&phonenumber=' + phonenumber + '&age=' + age + '&balance=' + balance + '&books=' + books + '" style="margin-left: 150px">Change</a>
        </p>
        -->
    </body>
</html>
