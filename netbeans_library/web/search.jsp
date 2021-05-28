<%-- 
    Document   : search
    Created on : 2019-12-3, 20:29:56
    Author     : Meruem
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="c.connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Info</title>
    </head>
    <body style="background:url('picture/5.jpg') no-repeat;background-size:100% 100%;background-attachment: fixed;">
        <script>
            function bClick()
            {
                alert("Borrowed successfully");
            }
        </script>
        <%
            String bookname = null;
            String author = null, putdate = null, category = null, num = null;
            int price = 0, ava = 0;

            Connection con = connection.getConnection();
            String search = request.getParameter("search");

            String sql = null;
            PreparedStatement ps = null;
            if (search.startsWith("LS")) {
                num = search;
                sql = "select * from book_info where num = ?";
            } else {
                bookname = search;
                sql = "select * from book_info where bookname = ?";
            }
            ps = con.prepareStatement(sql);
            ps.setString(1, search);
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
                out.print("<a href='borrow?num=" + num + "&bookname=" + bookname + "&category=" + category + "' onclick=\"bClick()\">Borrow </a>");
                out.print("</div>");
            }
        %>
    </body>
</html>
