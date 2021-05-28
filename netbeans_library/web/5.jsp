<%-- 
    Document   : 5
    Created on : 2019-12-9, 16:00:51
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
        <title>Books</title>
    </head>
    <body style="font-size: 25px;background: url('picture/3.jpg') no-repeat;background-size:100% 100%;background-attachment: fixed;">
        <%
            try {
                String bookname = null;
                String author = null, putdate = null, category = null, num = null;
                int price = 0, ava = 0;
                Connection con = connection.getConnection();

                String sql = null;

                sql = "select * from book_info";
                PreparedStatement ps;
                ps = con.prepareStatement(sql);

                ResultSet rs1 = ps.executeQuery();

                while (rs1.next()) {
                    num = rs1.getString(1);
                    bookname = rs1.getString(2);
                    author = rs1.getString(3);
                    putdate = rs1.getString(4);
                    category = rs1.getString(5);
                    price = rs1.getInt(6);
                    ava = rs1.getInt(8);

                    out.print("<br><br>");
                    out.println(num+"&nbsp;&nbsp;&nbsp;");
                    out.println(bookname+"&nbsp;&nbsp;&nbsp;");
                    out.println(author+"&nbsp;&nbsp;&nbsp;");
                    out.println(putdate+"&nbsp;&nbsp;&nbsp;");
                    out.println(category+"&nbsp;&nbsp;&nbsp;");
                    out.println(price+"&nbsp;&nbsp;&nbsp;");
                    out.println(ava+"&nbsp;&nbsp;&nbsp;");
                    //if (ava != 0) {
                    //    out.println("<a href='borrow.jsp?num=" + num + "&bookname=" + bookname + "&category=" + category + "'>change</a>");
                    //}
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.setContentType("text/html;charset=UTF-8");
        %>
        <div style="position:absolute; right:50px; bottom:50px;">
                <input type="button" value="Home" onClick="javascrtpt:window.location.href='admin.html'" style="font-size: 30px;font-family:fantasy">
        </div>
    </body>
</html>
