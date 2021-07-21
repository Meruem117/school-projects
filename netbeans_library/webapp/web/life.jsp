<%-- 
    Document   : life
    Created on : 2019-11-10, 20:18:22
    Author     : Meruem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Life</title>
        <style>
             body{
                margin: 0;
                background-color: #F5DEB3;
            }
            a{
                font-size: 30px;
                margin-left: 100px;
                margin-left: 48px;
                margin: 0;
            }
            div{
                font-size: 25px;
                font-family: serif;
            }
        </style>
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
    <body>
        <br><br><br>
        <h2 style="font-family: cursive;font-size: 60px;margin-left: 50px">L i f e</h2>
        <script>
        function changeColor(x) {
        x.style.background = '#d6f4fe';
        }
        function changeColorBack(x) {
         x.style.background = '#F5DEB3';
        };
        </script>

    <div>
        <div style="margin-left:240px;display:inline-block;border: solid #00cccc;width: 350px;height: 450px" onmousemove="changeColor(this)" onmouseleave="changeColorBack(this)">
            <br>
            <center>
            <img src="picture/life/1.png" alt="Minecraft" style="height: 360px;width: 240px"/><br>
            <a href="read?t=Minecraft"> 《MINECRAFT》 </a>
            </center>
        </div>
        <div style="margin-left:50px;display:inline-block;border: solid #00cccc;width: 350px;height: 450px" onmousemove="changeColor(this)" onmouseleave="changeColorBack(this)">
            <br>
            <center>
            <img src="picture/life/2.jpg" alt="French Cooking" style="height: 360px;width: 240px"/><br>
            <a href="read?t=French Cooking" style="font-size:28px"> 《FRENCH COOKING》 </a>
            </center>
        </div>
        <div style="margin-left:50px;display:inline-block;border: solid #00cccc;width: 350px;height: 450px" onmousemove="changeColor(this)" onmouseleave="changeColorBack(this)">
            <br>
            <center>
            <img src="picture/life/3.jpg" alt="Succulent Life" style="height: 360px;width: 240px"/><br>
            <a href="read?t=Succulent Life"> 《SUCCULENT LIFE》 </a>
            </center>
        </div>
        <br>
        <br>
        <div style="margin-left:240px;display:inline-block;border: solid #00cccc;width: 350px;height: 450px" onmousemove="changeColor(this)" onmouseleave="changeColorBack(this)">
            <br>
            <center>
            <img src="picture/life/4.jpg" alt="Be Your Own Psychiatrist" style="height: 340px;width: 250px"/><br>
            <a href="read?t=Be Your Own Psychiatrist" style="font-size:23px"> 《BE YOUR OWN PSYCHIATRIST》 </a>
            </center>
        </div>
        <div style="margin-left:50px;display:inline-block;border: solid #00cccc;width: 350px;height: 450px" onmousemove="changeColor(this)" onmouseleave="changeColorBack(this)">
            <br>
            <center>
            <img src="picture/life/5.jpg" alt="Please , Refrigerator" style="height: 330px;width: 230px"/><br>
            <a href="read?t=Please , Refrigerator" style="font-size:26px"> 《PLEASE, REFRIGERATOR》 </a>
            </center>
        </div>
        <div style="margin-left:50px;display:inline-block;border: solid #00cccc;width: 350px;height: 450px" onmousemove="changeColor(this)" onmouseleave="changeColorBack(this)">
            <br>
            <center>
            <img src="picture/life/6.jpg" alt="Very Complicated Knowledge" style="height: 330px;width: 230px"/><br>
            <a href="read?t=Very Complicated Knowledge" style="font-size:25px"> 《VERY COMPLICATED KNOWLEDGE》 </a>
            </center>
        </div>
    </div>
    </body>
</html>
