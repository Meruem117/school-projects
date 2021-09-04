<%-- 
    Document   : 6
    Created on : 2019-12-9, 16:05:39
    Author     : Meruem
--%>
<%@page import="java.sql.SQLException"%>
<%@page import="c.connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Damaged Books</title>
    </head>
    <body style="font-size: 25px;background: url('picture/3.jpg') no-repeat;background-size:100% 100%;background-attachment: fixed;">
        <%
            try {
                String bookname = null;
                String num = null, category = null, author = null;
                int amount = 0;
                Connection con = connection.getConnection();

                String sql = null;

                sql = "select * from destroyed_info";
                PreparedStatement ps;
                ps = con.prepareStatement(sql);

                ResultSet rs1 = ps.executeQuery();

                while (rs1.next()) {
                    num = rs1.getString(1);
                    bookname = rs1.getString(2);
                    author = rs1.getString(3);
                    category = rs1.getString(4);
                    amount = rs1.getInt(5);

                    out.print("<br><br>");
                    out.println(num + "&nbsp;&nbsp;&nbsp;");
                    out.println(bookname + "&nbsp;&nbsp;&nbsp;");
                    out.println(author + "&nbsp;&nbsp;&nbsp;");
                    out.println(category + "&nbsp;&nbsp;&nbsp;");
                    out.println(amount + "&nbsp;&nbsp;&nbsp;");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.setContentType("text/html;charset=UTF-8");
        %>
        <div style="position:absolute; right:50px; bottom:50px;">
            <input type="button" value="Home" onClick="javascrtpt:window.location.href = 'admin.html'" style="font-size: 30px;font-family:fantasy">
        </div>
    </body>
</html>
