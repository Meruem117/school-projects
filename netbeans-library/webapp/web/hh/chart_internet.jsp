<%-- 
    Document   : chart_internet
    Created on : 2020-6-23, 0:14:03
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
        <div id="box" style="width:600px;height:400px;border:1px solid #ccc"></div>
        <%
            Hbase h=new Hbase();
            String v[] = new String[10];
            h.getRS("result_4",v);   

        %>
        <br>
        <script type="text/javascript">
            var res = new Array();
            var ress = new Array();
           <%for(int i=0;i<4;i++){%>
                <%if(i%2==1){%>
                ress[<%=i/2%>] = <%=v[i]%>     //传值给js
            <%}}%>
            var myChart = echarts.init(document.getElementById('box')) //获取装载数据表的容器
            var option = {
                title: {
                text: 'Inside and outside country'
                },
            tooltip: {},
            legend: {
                data:['Count']
            },
    xAxis: {
        type: 'category',
        data: ['Iutside','Onside']
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        data: ress,
        type: 'pie',
        showBackground: true,
        backgroundStyle: {
            color: 'rgba(100, 100, 220, 0.8)'
        }
    }]
};
            myChart.setOption(option)//把echarts配置项启动
        </script>
        
        
        <div id="box2" style="width:1600px;height:400px;border:1px solid #ccc"></div>
        <%
            String v2[] = new String[1000];
            h.getRS("result_5",v2);   

        %>
        <br>
        <script type="text/javascript">
            var res2 = new Array();
           <%for(int i=0;i<50;i++){%>
                <%if(i%2==1){%>
                res2[<%=i/2%>] = <%=v2[i]%>     //传值给js
            <%}}%>
            var myChart2 = echarts.init(document.getElementById('box2')) //获取装载数据表的容器
            var option = {
                title: {
                text: 'Borrow rate of every library'
                },
            tooltip: {},
            legend: {
                data:['Count']
            },
    xAxis: {
        type: 'category',
        data: ['Western','Park','Ortega','North_Beach','Noe_Valley','Mission_Bay','Mission','Merced','Marina','Main_Library','Ingleside','West_Portal','Excelsior','Eureka_Valley','Chinatown',
                'Bernal_Heights','Anza','Unknown','Sunset','Richmod','Presidio','Potrero','Portola','Parkside']
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        data: res2,
        type: 'line',
        showBackground: true,
        backgroundStyle: {
            color: 'rgba(100, 100, 220, 0.8)'
        }
    }]
};
            myChart2.setOption(option)//把echarts配置项启动
        </script>
        
        
        
        <div id="box3" style="width:600px;height:400px;border:1px solid #ccc"></div>
        <%
            String v3[] = new String[6];
            h.getRS("result_6",v3);   

        %>
        <br>
        <script type="text/javascript">
            var res3 = new Array();
           <%for(int i=0;i<6;i++){%>
                <%if(i%2==1){%>
                res3[<%=i/2%>] = <%=v3[i]%>     //传值给js
            <%}}%>
            var myChart3 = echarts.init(document.getElementById('box3')) //获取装载数据表的容器
            var option = {
                title: {
                text: 'The three libraries lending the least books'
                },
            tooltip: {},
            legend: {
                data:['Count']
            },
    xAxis: {
        type: 'category',
        data: ['North_Beach','Bernal_Heights','Anza']
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        data: res3,
        type: 'bar',
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
