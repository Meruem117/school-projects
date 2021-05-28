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
        <title>Borrowed Books</title>
    </head>
    <body style="font-size: 25px;background: url('picture/3.jpg') no-repeat;background-size:100% 100%;background-attachment: fixed;">
        <%
            try {
                String bookname = null, username = null;
                String num = null, category = null, phonenumber = null, bdate = null, edate = null;
                int overdue = 0;
                Connection con = connection.getConnection();

                String sql = null;

                sql = "select * from borrowed_info";
                PreparedStatement ps;
                ps = con.prepareStatement(sql);

                ResultSet rs1 = ps.executeQuery();

                while (rs1.next()) {
                    num = rs1.getString(1);
                    bookname = rs1.getString(2);
                    category = rs1.getString(3);
                    username = rs1.getString(4);
                    phonenumber = rs1.getString(5);
                    bdate = rs1.getString(6);
                    edate = rs1.getString(7);
                    overdue = rs1.getInt(8);

                    out.print("<br><br>");
                    out.println(num + "&nbsp;&nbsp;&nbsp;");
                    out.println(bookname + "&nbsp;&nbsp;&nbsp;");
                    out.println(category + "&nbsp;&nbsp;&nbsp;");
                    out.println(username + "&nbsp;&nbsp;&nbsp;");
                    out.println(phonenumber + "&nbsp;&nbsp;&nbsp;");
                    out.println(bdate + "&nbsp;&nbsp;&nbsp;");
                    out.println(edate + "&nbsp;&nbsp;&nbsp;");
                    out.println(overdue + "&nbsp;&nbsp;&nbsp;");
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
