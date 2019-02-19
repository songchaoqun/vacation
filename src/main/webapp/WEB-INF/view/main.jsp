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
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
</head>
<body>
<!-- layout布局 页面布局 即 inferno 等 -->
<div id="cc" class="easyui-layout" fit="true">
    <div data-options="region:'north',title:'inferno',split:false,collapsible:false" style="height:100px;">
    </div>
    <div data-options="region:'west',title:'菜单栏',split:false,collapsible:true" style="width:200px;">
        <ul id="tt" class="easyui-tree"></ul>
    </div>
    <!-- padding:5px; 间距 -->
    <div data-options="region:'center',title:'展示中心',iconCls:'icon-reload',border:false">
        <!-- easyui选项卡 -->
        <div id="tabs" class="easyui-tabs" data-options="fit:true"></div>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        treeRecursion();
        tabsClick();
    })
    function tabsClick(){
        //给树绑定点击事件
        $('#tt').tree({
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
        $("#tt").tree({
            url:"<%=request.getContextPath()%>/tree/queryTreeList",
        })
    }
</script>
</body>
</html>
