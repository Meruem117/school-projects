<%-- 
    Document   : view
    Created on : 2019-12-18, 17:17:57
    Author     : Meruem
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="c.connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View</title>
    </head>
    <body style="background-color: #F5DEB3;font-size: 25px;">
        <%
            Connection con = connection.getConnection();
            HttpSession s = request.getSession(false);
            String sql5 = null;                            //test one
            String username =(String) s.getAttribute("name");
            String bookname, num, category, borrowed_date, expect_date;
            PreparedStatement ps3;
            sql5 = "select * from borrowed_info where username=?";
            ps3 = con.prepareStatement(sql5);
            ps3.setString(1, username);
            ResultSet rs3 = ps3.executeQuery();
            while (rs3.next()) {
                username = rs3.getString(4);
                bookname = rs3.getString(2);
                category = rs3.getString(3);
                num = rs3.getString(1);
                borrowed_date = rs3.getString(6);
                expect_date = rs3.getString(7);
                out.print("<br>");
                out.println(username+ "&nbsp;&nbsp;&nbsp;");
                out.println(bookname+ "&nbsp;&nbsp;&nbsp;");
                out.println(num+ "&nbsp;&nbsp;&nbsp;");
                out.println(category+ "&nbsp;&nbsp;&nbsp;");
                out.println(borrowed_date+ "&nbsp;&nbsp;&nbsp;");
                out.println(expect_date+ "&nbsp;&nbsp;&nbsp;");
            }
        %>
    </body>
</html>
