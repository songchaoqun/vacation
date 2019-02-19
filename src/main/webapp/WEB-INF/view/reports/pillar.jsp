<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/13
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>柱</title>
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
    <script type="text/javascript" src="<%=path%>/js/echarts.min.js"></script>
</head>
<body>
<div id="container" style="height: 100%"></div>
<script type="text/javascript">
    $(function(){
        Echarts();
    })
    function Echarts(){
        $.ajax({
            type:'post',
            url:'${ctx}/mold/reportsPillar',
            cache:false,
            success:function(data){
                myChart.setOption({
                    xAxis:{data:data.container},
                    series:{data:data.data}
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
            formatter: "{类型}{b}<br/>: {c} (数量)"
        },
        xAxis: {
            type: 'category',
            data: []
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [],
            type: 'bar'
        }]
    };
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
</script>
</body>
</html>
