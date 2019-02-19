<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/13
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>饼</title>
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
    <script type="text/javascript" src="<%=path%>/js/echarts.min.js"></script>
</head>
<body style="height: 100%; margin: 0">
<div id="container" style="height: 100%"></div>
<script type="text/javascript">
    $(function() {
        Echarts();
    })
    function Echarts(){
        $.ajax({
            type:'post',
            url:'${ctx}/mold/reportsCake',
            cache:false,
            success:function(data){
                myChart.setOption({
                    series:{data:data},
                })
            }
        })
    }
    var dom = document.getElementById("container");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        backgroundColor : '#2c343c',
        title : {
            text : '头部标题',
            left : 'center',
            top : 20,
            textStyle : {
                color : 'pink'
            }
        },
        tooltip : {//鼠标悬停提示
            trigger : 'item',
            formatter: "{类型}{b}<br/>: {c} (数量)",
            axisPointer : { // 坐标轴指示器，坐标轴触发有效
                type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        visualMap : {
            show : false,
            min : 10,
            max : 10000,
            inRange : {
                colorLightness : [ 0, 1 ]
            }
        },
        series : [ {
            name : '访问来源',
            type : 'pie',
            radius : '55%',
            center : [ '50%', '50%' ],
            data : [

            ].sort(function(a, b) {
                return a.value - b.value;
            }),
            roseType : 'radius',
            label : {
                normal : {
                    textStyle : {
                        color : 'rgba(255, 255, 255, 0.3)'
                    }
                }
            },
            labelLine : {
                normal : {
                    lineStyle : {
                        color : 'rgba(255, 255, 255, 0.3)'
                    },
                    smooth : 0.2,
                    length : 10,
                    length2 : 20
                }
            },
            itemStyle : {
                normal : {
                    color : '#c23531',
                    shadowBlur : 200,
                    shadowColor : 'rgba(0, 0, 0, 0.5)'
                }
            },
            animationType : 'scale',
            animationEasing : 'elasticOut',
            animationDelay : function(idx) {
                return Math.random() * 200;
            }
        } ]
    };
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
</script>
</body>
</html>
