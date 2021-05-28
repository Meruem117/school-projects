<%-- 
    Document   : chart
    Created on : 2020-6-19, 23:53:22
    Author     : Meruem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="hbase.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chart</title>
        <script src="echarts.min.js"></script>
    </head>
    <body>
        <div id="box" style="width:800px;height:500px;border:1px solid #ccc"></div>
        <%
            Hbase h=new Hbase();
            String v[] = new String[100];
            h.getRS("result_1",v);   
        %>
        <br>
        <script type="text/javascript">
            var res = new Array();
            var ress = new Array();
            <%for(int i=0;i<6;i++){%>
                <%if(i%2==1){%>
                ress[<%=i/2%>] = <%=v[i]%>     //传值给js
            <%}}%>

            var myChart = echarts.init(document.getElementById('box')) //获取装载数据表的容器
            var option = {
                title: {
                text: 'Top three books borrowed'
                },
            tooltip: {},
            legend: {
                data:['Count']
            },
    xAxis: {
        type: 'category',
        data: ['Minecraft','Harry Potter','The Book Thief']
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        data: ress,
        type: 'bar',
        showBackground: true,
        backgroundStyle: {
            color: 'rgba(100, 100, 220, 0.8)'
        }
    }]
};
            myChart.setOption(option)//把echarts配置项启动
        </script>
        
        
        
        
        <div id="box2" style="width:800px;height:600px;border:1px solid #ccc"></div>
        <%
            String v2[] = new String[8];
            h.getRS("result_2",v2);   
        %>
        <br>
        <script type="text/javascript">
            var res2 = new Array();
            <%for(int i=0;i<4;i++){%>
                <%if(i%2==1){%>
                res2[<%=i/2%>] = <%=v2[i]%>     //传值给js
            <%}}%>

            var myChart2 = echarts.init(document.getElementById('box2')) //获取装载数据表的容器
            var option = {
                title: {
                text: 'Age groups'
                },
            tooltip: {},
            legend: {
                data:['Count']
            },
    xAxis: {
        type: 'category',
        data: ['Teen','Adult','Middle-Aged','Old']
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        data: res2,
        type: 'pie',
        showBackground: true,
        backgroundStyle: {
            color: 'rgba(100, 100, 220, 0.8)'
        }
    }]
};
            myChart2.setOption(option)//把echarts配置项启动
        </script>
        
        
        <div id="box3" style="width:1500px;height:800px;border:1px solid #ccc"></div>
        <%
            String v3[] = new String[100];
            h.getRS("result_3",v3);   
        %>
        <br>
        <script type="text/javascript">
            var re = new Array();
            var res3 = new Array();
            <%for(int i=0;i<30;i++){%>
                <%if(i%2==1){%>
                res3[<%=i/2%>] = <%=v3[i]%>     //传值给js
            <%}}%>
            <%for(int i=0;i<30;i++){%>
                <%if(i%2==0){%>
                re[<%=i/2%>] = <%=v3[i]%>     //传值给js
            <%}}%>
            var myChart3 = echarts.init(document.getElementById('box3')) //获取装载数据表的容器
            var option = {
                title: {
                text: 'The time(hour) people borrow'
                },
            tooltip: {},
            legend: {
                data:['Count']
            },
    xAxis: {
        type: 'category',
        data: re
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        data: res3,
        type: 'line',
        showBackground: true,
        backgroundStyle: {
            color: 'rgba(100, 100, 220, 0.8)'
        }
    }]
};
            myChart3.setOption(option)//把echarts配置项启动
        </script>
        
    </body>
</html>
