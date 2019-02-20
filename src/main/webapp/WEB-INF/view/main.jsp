<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/16
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/view/common/base.jsp"%>
</head>
<style type="text/css">
    body{
        font-size:12px;
        background-image: url(<%=request.getContextPath()%>/image/bg.gif);
        background-repeat: repeat;
    }
    ul,li,h2{margin:0;padding:0;}
    ul{list-style:none;}
    #top{
        width:909px;
        height:26px;
        background-image: url(<%=request.getContextPath()%>/image/h2bg.gif);
        margin-top: 0;
        margin-right: auto;
        margin-bottom: 0;
        margin-left: auto;
        background-repeat: repeat-x;
    }
    #top h2{
        width:150px;
        height:24px;
        float:left;
        font-size:12px;
        text-align:center;
        line-height:20px;
        color:#0066FF;
        font-weight: bold;
        padding-top: 2px;
        border-right-width: 1px;
        border-left-width: 1px;
        border-right-style: solid;
        border-left-style: solid;
        border-right-color: #99BBE8;
        border-left-color: #99BBE8;
    }
    #top .jg {
        width: 5px;
        float: left;
        background-color: #DCE6F5;
        height: 26px;
    }
    #topTags{
        width:740px;
        height:24px;
        float:left;
        margin-top: 0;
        margin-right: auto;
        margin-bottom: 0;
        margin-left: auto;
        padding-top: 2px;
        border-right-width: 1px;
        border-left-width: 1px;
        border-right-style: solid;
        border-left-style: solid;
        border-right-color: #99BBE8;
        border-left-color: #99BBE8;
        padding-left: 10px;
    }
    #topTags ul li{
        float:left;
        width:100px;
        height:21px;
        margin-right:4px;
        display:block;
        text-align:center;
        cursor:pointer;
        padding-top: 3px;
        color: #15428B;
        font-size: 12px;
    }
    #main{
        width:909px;
        height:501px;
        background-color:#F5F7E6;
        margin-top: 0;
        margin-right: auto;
        margin-bottom: 0;
        margin-left: auto;
    }
    #main .jg {
        width: 5px;
        float: left;
        background-color: #DFE8F6;
        height: 500px;
    }
    #leftMenu{
        width:150px;
        height:500px;
        background-color:#DAE7F6;
        float:left;
        border-right-width: 1px;
        border-left-width: 1px;
        border-right-style: solid;
        border-left-style: solid;
        border-right-color: #99BBE8;
        border-left-color: #99BBE8;
    }
    #leftMenu ul{margin:10px;}
    #leftMenu ul li{
        width:130px;
        height:22px;
        display:block;
        cursor:pointer;
        text-align:center;
        margin-bottom:5px;
        background-color: #D9E8FB;
        background-image: url(<%=request.getContextPath()%>/image/tabbg01.gif);
        background-repeat: no-repeat;
        background-position: 0px 0px;
        padding-top: 2px;
        line-height: 20px;
    }
    #leftMenu ul li a{
        color:#000000;
        text-decoration:none;
        background-image: url(<%=request.getContextPath()%>/image/tb-btn-sprite_03.gif);
        background-repeat: repeat-x;
    }
    #content{
        width:750px;
        height:500px;
        float:left;
        border-right-width: 1px;
        border-left-width: 1px;
        border-right-style: solid;
        border-left-style: solid;
        border-right-color: #99BBE8;
        border-left-color: #99BBE8;
        background-color: #DAE7F6;
    }
    .content{
        width:740px;
        height:490px;
        display:none;
        padding:5px;
        overflow-y:auto;
        line-height:30px;
        background-color: #FFFFFF;
    }
    #footer{
        width:907px;
        height:26px;
        background-color:#FFFFFF;
        line-height:20px;
        text-align:center;
        margin-top: 0;
        margin-right: auto;
        margin-bottom: 0;
        margin-left: auto;
        border-right-width: 1px;
        border-left-width: 1px;
        border-right-style: solid;
        border-left-style: solid;
        border-right-color: #99BBE8;
        border-left-color: #99BBE8;
        background-image: url(<%=request.getContextPath()%>/image/h2bg.gif);
        background-repeat: repeat-x;
    }
    .content1 {width:740px;height:490px;display:block;padding:5px;overflow-y:auto;line-height:30px;}
</style>
<script type="text/javascript">
    window.onload=function(){
        function $(id){return document.getElementById(id)}
        var menu=$("topTags").getElementsByTagName("ul")[0];//顶部菜单容器
        var tags=menu.getElementsByTagName("li");//顶部菜单
        var ck=$("leftMenu").getElementsByTagName("ul")[0].getElementsByTagName("li");//左侧菜单
        var j;
//点击左侧菜单增加新标签
        for(var i=0;i<ck.length;i++){
            ck[i].onclick=function(){
                $("welcome").style.display="none"//欢迎内容隐藏
                clearMenu();
                this.style.background='url(<%=request.getContextPath()%>/image/tabbg02.gif)'
//循环取得当前索引
                for(var j=0;j<8;j++){
                    if(this==ck[j]){
                        if($("p"+j)==null){
                            openNew(j,this.innerHTML);//设置标签显示文字
                        }
                        clearStyle();
                        $("p"+j).style.background='url(<%=request.getContextPath()%>/image/tabbg1.gif)';
                        clearContent();
                        $("c"+j).style.display="block";
                    }
                }
                return false;
            }
        }
//增加或删除标签
        function openNew(id,text){
            var tagMenu=document.createElement("li");
            tagMenu.id="p"+id;
            tagMenu.innerHTML=text+"&nbsp;&nbsp;"+"<img src='<%=request.getContextPath()%>/image/off.gif' style='vertical-align:middle'/>";
//标签点击事件
            tagMenu.onclick=function(evt){
                clearMenu();
                ck[id].style.background='url(<%=request.getContextPath()%>/image/tabbg02.gif)'
                clearStyle();
                tagMenu.style.background='url(<%=request.getContextPath()%>/image/tabbg1.gif)';
                clearContent();
                $("c"+id).style.display="block";
            }
//标签内关闭图片点击事件
            tagMenu.getElementsByTagName("img")[0].onclick=function(evt){
                evt=(evt)?evt:((window.event)?window.event:null);
                if(evt.stopPropagation){evt.stopPropagation()} //取消opera和Safari冒泡行为;
                this.parentNode.parentNode.removeChild(tagMenu);//删除当前标签
                var color=tagMenu.style.backgroundColor;
//设置如果关闭一个标签时，让最后一个标签得到焦点
                if(color=="#ffff00"||color=="yellow"){//区别浏览器对颜色解释
                    if(tags.length-1>=0){
                        clearStyle();
                        tags[tags.length-1].style.background='url(<%=request.getContextPath()%>/image/tabbg1.gif)';
                        clearContent();
                        var cc=tags[tags.length-1].id.split("p");
                        $("c"+cc[1]).style.display="block";
                        clearMenu();
                        ck[cc[1]].style.background='url(<%=request.getContextPath()%>/image/tabbg1.gif)';
                    }
                    else{
                        clearContent();
                        clearMenu();
                        $("welcome").style.display="block"
                    }
                }
            }
            menu.appendChild(tagMenu);
        }
//清除菜单样式
        function clearMenu(){
            for(i=0;i<ck.length;i++){
                ck[i].style.background='url(<%=request.getContextPath()%>/image/tabbg01.gif)';
            }
        }
//清除标签样式
        function clearStyle(){
            for(i=0;i<tags.length;i++){
                menu.getElementsByTagName("li")[i].style.background='url(<%=request.getContextPath()%>image/tabbg2.gif)';
            }
        }
//清除内容
        function clearContent(){
            for(i=0;i<7;i++){
                $("c"+i).style.display="none";
            }
        }
    }
</script>
</head>
<body>
<div id="top">
    <h2>管理菜单</h2>
    <div class=jg></div>
    <div id="topTags">
        <ul>
        </ul>
    </div>
</div>
<div id="main">
    <div id="leftMenu"  >
        <ul>
            <li></li>
        </ul>
    </div>
    <div class=jg></div>
    <div id="content">
                <!-- easyui选项卡 -->
                <div id="tabs" class="easyui-tabs" data-options="fit:true"></div>
    </div>
</div>
<div id="footer"><marquee>课堂管理系统~~ 欢迎您光临</marquee></div>
</body>
<script type="text/javascript">
    $(function(){
        treeRecursion();
        tabsClick();
    })
    function tabsClick(){
        //给树绑定点击事件
        $('#leftMenu').tree({
            onClick: function(node){
                //先判断路径是否存在
                if(node.url != null && node.url != ""){
                    //判断选项卡是否存在
                    if($("#tabs").tabs("exists",node.text)){
                        //如果存在：选择打开
                        $("#tabs").tabs("select",node.text);
                    }else{
                        //如果不存在则通过将参数传到tabs方法，通过tabs方法打开一个tabs选项卡
                        tabs(node.text,node.url)
                        /* //如果不存在：添加选择卡
                        $("#tabs").tabs("add",{
                            title:node.text,
                            content:createJsp(node.url),
                            closable:true
                        }) */
                    }
                }
            }
        });
    }
    //根据的到的url参数动态跳转后台路径的方法
    function createJsp(url){
        if(url!=null){
            return '<iframe scrolling="auto" frameborder="0"  src="<%=request.getContextPath()%>'+url+'" style="width:100%;height:100%;"></iframe>';
        }
        return "欢迎访问该首页!!!!";
    }
    //选项卡
    function tabs(text,url){
        $('#tabs').tabs('add',{
            title:text,    //选项卡名称
            content:createJsp(url),//选项卡内容
            tools:[{
                iconCls:'icon-mini-refresh',
                handler:function(){
                    $('#tabs').tabs('update', {
                        tab: $('#tabs').tabs('getSelected'),
                        options: {
                            content:createJsp(url)
                        }
                    });
                }
            }],
            closable:true,
        });
    }
    //后台递归树
    function treeRecursion(){
        $("#leftMenu").tree({
            url:"<%=request.getContextPath()%>/tree/queryTreeList",
        })
    }
</script>
</html>
