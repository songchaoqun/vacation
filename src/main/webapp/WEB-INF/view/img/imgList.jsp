<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/13
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
</head>
<body>
<style>
    .slider {
        width: 600px;
        height: 300px;
        margin-bottom: 10px;
    }

    .slider ul {
        position: relative;
        margin-top: -50px;
        margin-left: 240px;
        width: 200px;
        height: 100px;
    }

    .slider ul li {
        width: 15px;
        height: 15px;
        float: left;
        margin-left: 10px;
        list-style: none;
        border-radius: 20px;
        background: white;
    }
</style>
<div class="slider">
    <a href=""><img border="0px" id="slider_img" src="${ctx}/images/3.jpg"/></a>
    <ul>
        <li id="1"></li>
        <li id="2"></li>
        <li id="3"></li>
        <li id="4"></li>
        <li id="5"></li>
    </ul>
</div>
<script>
    //图片轮播
    var i = 1;
    //如果scroll为true，轮播，否则停止轮播
    var scroll = true;
    //动画事件，在2000ms内完成function
    setInterval(function () {
        if (scroll) {
            if (i == 5) {
                i = 0;
            }
            $(".slider ul li:eq(" + i + ")").css("background", "gray");//让小圆点变灰色
            $(".slider ul li:eq(" + i + ")").siblings().css("background", "white");//同级的小圆点变白色
            i++;
            $("#slider_img").attr("src", "${ctx}/images/" + i + ".jpg");//这里可以看出和图片的命名有关
        }
    }, 2000);

    $(function () {
// 图片轮播
        $(".slider ul li:eq(0)").css("background", "gray");
        $(".slider ul li:eq(0)").siblings().css("background", "white");
        $("#slider_img").attr("src", "${ctx}/images/3.jpg");
        $(".slider ul li").hover(function () {//当鼠标移到圆点上
            scroll = false;//停止轮播
            $a = $(this).attr("id");
            $("#slider_img").attr("src", "${ctx}/images/" + $a + ".jpg");
            i = $a;//从当前图片开始轮播
            $(this).css("cursor", "pointer").css("background", "gray");
            $(this).siblings().css("background", "white");

        }, function () {
            scroll = true;
        })
    })
</script>
</body>
</html>
