<%-- 
    Document   : info
    Created on : 2019-11-13, 7:55:06
    Author     : Meruem
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Infomation</title>
        <style type="text/css">
        .top{
    /* 设置宽度高度背景颜色 */
    height: auto; /*高度改为自动高度*/
    width:100%;
    margin-left: 0;
    background:#4F94CD;
    position: fixed; /*固定在顶部*/
    top: 0;/*离顶部的距离为0*/
    margin-bottom: 5px;
}
.top ul{
    /* 清除ul标签的默认样式 */
    width: auto;/*宽度也改为自动*/
    list-style-type: none;
    white-space:nowrap;
    overflow: hidden;
    margin-left: 5%;
    /* margin-top: 0;          */
    padding: 0;

}
.top li {
    float:left; /* 使li内容横向浮动，即横向排列  */
    margin-right:2%;  /* 两个li之间的距离*/
    position: relative;
    overflow: hidden;
}

.top li a{
   /* 设置链接内容显示的格式*/
    display: block; /* 把链接显示为块元素可使整个链接区域可点击 */
    color:white;
    width:180px;
    font-size: 30px;
    text-align: center;
    padding: 3px;
    overflow: hidden;
    text-decoration: none; /* 去除下划线 */
    
}
.top li a:hover{
    /* 鼠标选中时背景变为黑色 */
    background-color: #ffcccc;
}
.top ul li ul{
    /* 设置二级菜单 */
    margin-left: -0.2px;
    background:rgb(189, 181, 181);
    position: relative;
    display: none; /* 默认隐藏二级菜单的内容 */

}
.top ul li ul li{
    /* 二级菜单li内容的显示 */
    
    float:none;
    text-align: center;
}
.top ul li:hover ul{
    /* 鼠标选中二级菜单内容时 */
    display: block;
}
    </style>
            <div class="top">
                   <center> 
                    <ul>
                    <li><a href="jump?t=Home">Home</a></li>
                    <li><a href="jump?t=Fiction">Fiction</a></li>
                    <li><a href="jump?t=Science">Science</a></li>
                    <li><a href="jump?t=Economic">Economic</a></li>
                    <li><a href="jump?t=Biography">Biography</a></li>
                    <li><a href="jump?t=Life">Life</a></li>
                    <li><a href="jump?t=Art">Art</a></li>
                    <li>
                        <a href="jump?t=user">User</a>
                        <ul>
                            <li><a href="jump?t=information">Information</a></li>
                            <li><a href="jump?t=logout">Log Out</a></li>
                        </ul>
                    </li>
                    </ul>
                    </center>      
            </div>
    </head>
    <body style="background-color: #F5DEB3;">
        <%
            response.setContentType("text/html;charset=UTF-8");
            HttpSession se=request.getSession(false);
            String n=(String)se.getAttribute("name");
            
            String username = null, passwd = null,email=null,phone=null;
            int age=0,balance=0;
            int number=0;
        try {
                //连接数据库
                String user = "root";
                String password = "abc123";
                String url = "jdbc:mysql://localhost:3306/bk?useSSL=false";
                Connection con = null;
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                String str = null;
                PreparedStatement ps; 
                str = "select * from user_info where username=?"; 
                ps = con.prepareStatement(str);
                ps.setString(1,n);
                ResultSet rs1 = ps.executeQuery();
                if (rs1.next()) {
                    username = rs1.getString(1);
                    passwd = rs1.getString(2);
                    email = rs1.getString(3);
                    phone = rs1.getString(4);
                    age = rs1.getInt(5);
                    balance = rs1.getInt(6);
                    number = rs1.getInt(7);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        %>
        <br><br><br>
        <p style="font-size: 40px">
            Name : <%=username%><br><br>
            Email : <%=email%><br><br>
            Phone : <%=phone%><br><br>
            Age : <%=age%><br><br>
            Balance : <%=balance%><br><br>
            Book(s) borrowed : <%=number%>&nbsp;&nbsp;&nbsp; <a href="view.jsp" style="font-size: 35px">view</a>
        </p>
    </body>
</html>
