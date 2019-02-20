<%--
  Created by IntelliJ IDEA.
  User: zbq
  Date: 2019/2/20
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>环形</title>
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
    <script type="text/javascript" src="<%=path%>/js/echarts.min.js"></script>
</head>
<body id="main" style="width:450px;height:300px;">
<div id="container" style="height: 100%"></div>

<script type="text/javascript">
    $(function(){
        Circle();
    })
    function  Circle(){
        $.ajax({
            type:'post',
            url:'${ctx}/mold/reportsCake',
            cache:false,
            success:function(data){
                myChart.setOption({
                    series:{data:data},
                    legend:{data:name}
                })
            }
        })
    }
    var dom = document.getElementById("container");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient : 'vertical',
            x : 'left',
            data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {
                    show: true,
                    type: ['pie', 'funnel'],
                    option: {
                        funnel: {
                            x: '25%',
                            width: '50%',
                            funnelAlign: 'center',
                            max: 1548
                        }
                    }
                },
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        series : [
            {
                name:'访问来源',
                type:'pie',
                radius : ['50%', '70%'],
                itemStyle : {
                    normal : {
                        label : {
                            show : false
                        },
                        labelLine : {
                            show : false
                        }
                    },
                    emphasis : {
                        label : {
                            show : true,
                            position : 'center',
                            textStyle : {
                                fontSize : '30',
                                fontWeight : 'bold'
                            }
                        }
                    }
                },
                data:[

                ]
            }
        ]
    };

    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
</script>
</body>
</html>
