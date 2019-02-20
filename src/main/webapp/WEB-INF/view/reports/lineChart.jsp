<%--
  Created by IntelliJ IDEA.
  User: 19473
  Date: 2019/2/20
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>折线阴影图</title>
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
    <script type="text/javascript" src="<%=path%>/js/echarts.min.js"></script>

</head>
<body>
<div id="container" style="height: 100%"></div>
<script>
    $(function(){
        Funnel();
    })
    function Funnel() {
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
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: []
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [],
            type: 'line',
            areaStyle: {}
        }]
    };


    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
</script>

</body>
</html>
