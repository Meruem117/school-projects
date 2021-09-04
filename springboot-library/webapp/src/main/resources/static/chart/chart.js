function initMap(){
    var myChart1 = echarts.init(document.getElementById('map'));
    myChart1.showLoading();

    var v = [];

    var data = [
        {name: '北京', value: 279},
        {name: '长沙', value: 175},
        {name: '常州', value: 123},
        {name: '成都', value: 58},
        {name: '重庆', value: 66},
        {name: '大连', value: 47},
        {name: '海口', value: 44},
        {name: '杭州', value: 84},
        {name: '济南', value: 92},
        {name: '兰州', value: 99},
        {name: '上海', value: 385},
        {name: '深圳', value: 341},
        {name: '苏州', value: 50},
        {name: '天津', value: 105},
        {name: '武汉', value: 273},
        {name: '无锡', value: 71},
        {name: '扬州', value: 123}
    ];

    var geoCoordMap = {
        '北京':[116.46,39.92],
        '长沙':[113,28.21],
        '常州':[119.95,31.79],
        '成都':[104.06,30.67],
        '重庆':[106.54,29.59],
        '大连':[121.62,38.92],
        '海口':[110.35,20.02],
        '杭州':[120.19,30.26],
        '济南':[117,36.65],
        '兰州':[103.73,36.03],
        '上海':[121.48,31.22],
        '深圳':[114.07,22.62],
        '苏州':[120.62,31.32],
        '天津':[117.2,39.13],
        '武汉':[114.31,30.52],
        '无锡':[120.29,31.59],
        '扬州':[119.42,32.39]
    };

    // var convertData = function (data) {
    //     var res = [];
    //     for (var i = 0; i < data.length; i++) {
    //         var geoCoord = geoCoordMap[data[i].name];
    //         if (geoCoord) {
    //             res.push({
    //                 name: data[i].name,
    //                 value: geoCoord.concat(v[i])
    //             });
    //         }
    //     }
    //     console.log(res);
    //     return res;
    // };

    option1 = {
        title: {
            text: '全国用户分布情况',
            subtext: 'data from project',
            left: 'center'
        },
        tooltip : {
            trigger: 'item'
        },
        bmap: {
            center: [114.31,30.52],
            zoom: 6,
            roam: true,
            mapStyle: {
                styleJson: [{
                    'featureType': 'water',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#d1d1d1'
                    }
                }, {
                    'featureType': 'land',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#f3f3f3'
                    }
                }, {
                    'featureType': 'railway',
                    'elementType': 'all',
                    'stylers': {
                        'visibility': 'off'
                    }
                }, {
                    'featureType': 'highway',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#fdfdfd'
                    }
                }, {
                    'featureType': 'highway',
                    'elementType': 'labels',
                    'stylers': {
                        'visibility': 'off'
                    }
                }, {
                    'featureType': 'arterial',
                    'elementType': 'geometry',
                    'stylers': {
                        'color': '#fefefe'
                    }
                }, {
                    'featureType': 'arterial',
                    'elementType': 'geometry.fill',
                    'stylers': {
                        'color': '#fefefe'
                    }
                }, {
                    'featureType': 'poi',
                    'elementType': 'all',
                    'stylers': {
                        'visibility': 'off'
                    }
                }, {
                    'featureType': 'green',
                    'elementType': 'all',
                    'stylers': {
                        'visibility': 'off'
                    }
                }, {
                    'featureType': 'subway',
                    'elementType': 'all',
                    'stylers': {
                        'visibility': 'off'
                    }
                }, {
                    'featureType': 'manmade',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#d1d1d1'
                    }
                }, {
                    'featureType': 'local',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#d1d1d1'
                    }
                }, {
                    'featureType': 'arterial',
                    'elementType': 'labels',
                    'stylers': {
                        'visibility': 'off'
                    }
                }, {
                    'featureType': 'boundary',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#fefefe'
                    }
                }, {
                    'featureType': 'building',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#d1d1d1'
                    }
                }, {
                    'featureType': 'label',
                    'elementType': 'labels.text.fill',
                    'stylers': {
                        'color': '#999999'
                    }
                }]
            }
        },
        series : [
            {
                name: 'Number',
                type: 'scatter',
                coordinateSystem: 'bmap',
                data: v,
                symbolSize: function (val) {
                    return val[2] / 10;
                },
                encode: {
                    value: 2
                },
                label: {
                    formatter: '{b}',
                    position: 'right',
                    show: false
                },
                itemStyle: {
                    color: 'purple'
                },
                emphasis: {
                    label: {
                        show: true
                    }
                }
            },
            {
                name: 'Top 5',
                type: 'effectScatter',
                coordinateSystem: 'bmap',
                data: v.sort(function (a, b) {
                    return b.value - a.value;
                }).slice(0, 5),
                symbolSize: function (val) {
                    return val[2] / 10;
                },
                encode: {
                    value: 2
                },
                showEffectOn: 'render',
                rippleEffect: {
                    brushType: 'stroke'
                },
                hoverAnimation: true,
                label: {
                    formatter: '{b}',
                    position: 'right',
                    show: true
                },
                itemStyle: {
                    color: 'purple',
                    shadowBlur: 10,
                    shadowColor: '#333'
                },
                zlevel: 1
            }
        ]
    };

    // myChart1.setOption(option);

    $.ajax({
                type: "GET",
                async: true, //异步请求（同步请求将会锁住浏览器，其他操作须等请求完成才可执行）
                url: "./GetService1", //请求发送到TestServlet
                data: {},
                dataType: "json", //返回数据形式为json
                // 请求成功后接收数据nums两组数
                success: function (result) {
                    // result为服务器返回的json对象
                    if (result) {
                        v.splice(0,17);
                        for (var i = 0; i < result.length; i++) {
                            var geo = geoCoordMap[data[i].name];
                            v.push({
                                name: data[i].name,
                                value: geo.concat(result[i])
                            })
                            // v[i] = result[i]; //迭代取出数量并填入数值数组
                        }
                        option1.series[0].data = v;
                        option1.series[1].data= v.sort(function (a, b) {
                            return b.value[2] - a.value[2];
                        }).slice(0, 5);
                        myChart1.setOption(option1);
                        myChart1.hideLoading(); //隐藏加载动画
                    }

                },
                error: function (err) {
                    //请求失败时执行该函数
                    alert("图表请求数据失败!");
                    myChart1.hideLoading();
                }
            });

    $("#update1").click(function () {
                myChart1.showLoading(); //显示加载动画
                // ajax发起数据请求
                $.ajax({
                    type: "GET",
                    async: true, //异步请求（同步请求将会锁住浏览器，其他操作须等请求完成才可执行）
                    url: "./GetService1", //请求发送到TestServlet
                    data: {},
                    dataType: "json", //返回数据形式为json
                    // 请求成功后接收数据nums数据
                    success: function (result) {
                        // result为服务器返回的json对象
                        if (result) {
                            v.splice(0,17);
                            for (var i = 0; i < result.length; i++) {
                                var geo = geoCoordMap[data[i].name];
                                v.push({
                                    name: data[i].name,
                                    value: geo.concat(result[i])
                                })
                                // v[i] = result[i]; //迭代取出数量并填入数值数组
                            }
                            option1.series[0].data = v;
                            option1.series[1].data= v.sort(function (a, b) {
                                return b.value[2] - a.value[2];
                            }).slice(0, 5);
                            myChart1.setOption(option1);
                            myChart1.hideLoading(); //隐藏加载动画
                        }

                    },
                    error: function (err) {
                        //请求失败时执行该函数
                        alert("图表请求数据失败!");
                        myChart1.hideLoading();
                    }
                });
            });

}

function initBox(){
    var myChart = echarts.init(document.getElementById('bar'));
    myChart.showLoading();

    var nums = [];

    option = {
        color: ['#3398DB'],
        tooltip: {
            trigger: 'axis',
            axisPointer: {   
                type: 'shadow'  
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                data: ['Art', 'Economic', 'Fiction', 'History', 'Life', 'Science'],
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: 'Number',
                type: 'bar',
                barWidth: '60%',
                data: nums
            }
        ]
    };

    // myChart.setOption(option);

    var myChart2 = echarts.init(document.getElementById('pie'));
    myChart2.showLoading();
    // var pie=[
    //     {value: 335, name: 'Art'},
    //     {value: 310, name: 'Economic'},
    //     {value: 234, name: 'Fiction'},
    //     {value: 135, name: 'History'},
    //     {value: 1548, name: 'Life'},
    //     {value: 135, name: 'Science'}
    // ];

    var cate=[
        {cate: 'Art'},
        {cate: 'Economic'},
        {cate: 'Fiction'},
        {cate: 'History'},
        {cate: 'Life'},
        {cate: 'Science'}
    ]

    var pie = [];

    option2 = {
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        legend: {
            orient: 'vertical',
            left: 10,
            data: ['Art', 'Economic', 'Fiction', 'History', 'Life','Science']
        },
        series: [
            {
                name: '类别',
                type: 'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    show: false,
                    position: 'center'
                },
                emphasis: {
                    label: {
                        show: true,
                        fontSize: '30',
                        fontWeight: 'bold'
                    }
                },
                labelLine: {
                    show: false
                },
                data: pie
            }
        ]
    };

    // myChart2.setOption(option2);

    $.ajax({
                type: "GET",
                async: true, //异步请求（同步请求将会锁住浏览器，其他操作须等请求完成才可执行）
                url: "./GetService2", //请求发送到TestServlet
                data: {},
                dataType: "json", //返回数据形式为json
                // 请求成功后接收数据nums两组数据
                success: function (result) {
                    // result为服务器返回的json对象
                    if (result) {
                        pie.splice(0,6);
                        for (var i = 0; i < result.length; i++) {
                            nums[i] = result[i]; //迭代取出数量并填入数值数组
                            pie.push({
                                value: result[i],
                                name: cate[i].cate
                            });
                        }
                        option.series.data = nums;
                        option2.series.data = pie;
                        myChart.setOption(option);
                        myChart.hideLoading(); //隐藏加载动画
                        myChart2.setOption(option2);
                        myChart2.hideLoading();
                    }

                },
                error: function (err) {
                    //请求失败时执行该函数
                    alert("图表请求数据失败!");
                    myChart.hideLoading();
                    myChart2.hideLoading();
                }
            });

    $("#update2").click(function () {
                myChart.showLoading(); //显示加载动画
                // ajax发起数据请求
                $.ajax({
                    type: "GET",
                    async: true, //异步请求（同步请求将会锁住浏览器，其他操作须等请求完成才可执行）
                    url: "./GetService2", //请求发送到TestServlet
                    data: {},
                    dataType: "json", //返回数据形式为json
                    // 请求成功后接收数据nums数据
                    success: function (result) {
                        // result为服务器返回的json对象
                        if (result) {
                            pie.splice(0,6);
                            for (var i = 0; i < result.length; i++) {
                                nums[i] = result[i]; //迭代取出数量并填入数值数组
                                pie.push({
                                    value: result[i],
                                    name: cate[i].cate
                                });
                            }
                            option.series.data = nums;
                            option2.series.data = pie;
                            myChart.setOption(option);
                            myChart.hideLoading(); //隐藏加载动画
                            myChart2.setOption(option2);
                            myChart2.hideLoading();
                        }

                    },
                    error: function (err) {
                        //请求失败时执行该函数
                        alert("图表请求数据失败!");
                        myChart.hideLoading();
                        myChart2.hideLoading();
                    }
                });
            });
}