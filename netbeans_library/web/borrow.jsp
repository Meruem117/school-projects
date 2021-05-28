<%-- 
    Document   : borrow
    Created on : 2019-12-9, 15:51:33
    Author     : Meruem
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="c.connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrow</title>
    </head>
    <body style="background:url('picture/5.jpg') no-repeat;background-size:100% 100%;background-attachment: fixed;">
        <script>
            function bClick()
            {
                alert("Borrowed successfully");
            }
        </script>
        <%
            HttpSession s = request.getSession(false);
            String bookname = (String) s.getAttribute("bn");
            String author = null, putdate = null, category = null, num = null;
            int price = 0, ava = 0;

            Connection con = connection.getConnection();

            String sql = null;
            PreparedStatement ps = null;
            sql = "select * from book_info where bookname = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, bookname);
            ResultSet rs1 = ps.executeQuery();
            while (rs1.next()) {
                num = rs1.getString(1);
                bookname = rs1.getString(2);
                author = rs1.getString(3);
                putdate = rs1.getString(4);
                category = rs1.getString(5);
                price = rs1.getInt(6);
                ava = rs1.getInt(8);

                out.print("<p style=\"font-size: 50px;color: blue;margin-top: 5%;margin-left: 6%\">" + bookname + "</p>");
                out.print("<div style=\"font-size: 40px;color: blue;margin-top: 5%;margin-left: 9%\">");
                out.print("Book Number :" + num + "<br><br>");
                out.print("Author :" + author + "<br><br>");
                out.print("Put Date :" + putdate + "<br><br>");
                out.print("Category :" + category + "<br><br>");
                out.print("Price :" + price + "<br><br>");
                out.print("Availiable Number :" + ava + "<br><br>");
                out.print("<a href='borrow?num="+ num + "&bookname="+ bookname + "&category="+ category + "' onclick=\"bClick()\">Borrow </a>");
                out.print("</div>");
            }
        %>
        <!--
        <p style="font-size: 50px;color: blue;margin-top: 5%;margin-left: 6%"> <%=bookname%> </p>
        <div style="font-size: 40px;color: blue;margin-top: 5%;margin-left: 9%">
            Book Number : <%=num%>  <br><br>
            Author : <%=author%> <br><br>
            Put Date : <%=putdate%> <br><br>
            Category : <%=category%> <br><br>
            Price : <%=price%> $ <br><br>
            Availiable Number : <%=ava%> <br><br>
            <a href="borrow?num='+ num + '&bookname='+ bookname + '&category='+ category + '" onclick="bClick()">Borrow</a>
        </div>
        -->
    </body>
</html>
