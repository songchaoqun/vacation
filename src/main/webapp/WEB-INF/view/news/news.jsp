<%--
  Created by IntelliJ IDEA.
  User: zbq
  Date: 2019/2/22
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
</head>
<body>
<!-- 定义表格 -->
<table id="myTable"></table>
<!-- 工具栏 -->
<div id="toolbar">

    <a href="javascript:openDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>

</div>
<!--新增弹框-->
<div id="myDialog" class="easyui-dialog" data-options="iconCls:'icon-save',closed:true,width:300,height:400,buttons:'#buttons'">
    <form   method="post" id="myForm" >
        <input style="display:none" name="id" id="a">
        <table>
            <tr>
                <td>标题</td>
                <td>
                    <input class="easyui-textbox" name="title">
                </td>
            </tr>
            <tr>
                <td>内容</td>
                <td>
                    <input type="easyui-textbox" name="content">
                </td>
            </tr>
            <tr>
                <td>创建人</td>
                <td>
                    <input class="easyui-combobox" name="createUser" id="createUser">
                </td>
            </tr>
            <tr>
                <td>类型</td>
                <td>
                    <input class="easyui-textbox" name="type">
                </td>
            </tr>

        </table>
    </form>
</div>
<!-- 对话框按钮 -->
<div id="buttons">
    <a href="javascript:saveAd()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">保存</a>
    <a href="javascript:closeDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">关闭</a>
</div>
</body>
<script>
    //初始化
    $(function(){
        initmyTable();
        initUser()
    })

    //初始创建
    function initUser(){
        $("#createUser").combobox({
            url:"${ctx}/news/queryUser",
            valueField:"id",
            textField:"staffName"
        })
    }

    //单个删除
    function deleteNews(id){
        $.messager.confirm("提示","是否确认删除！",function(r){
            if(r){
                $.ajax({
                    url:"${ctx}/news/deleteNews",
                    type:"post",
                    data:{"id":id},
                    success:function(){
                        //alert("删除成功");
                        $.messager.alert("提示消息","删除成功！","info");
                        //刷新页面
                        $("#myTable").datagrid("load");
                    },error:function(){
                        //alert("删除失败");
                        $.messager.alert("提示消息","删除失败！","error");
                    }
                })
            }
        })
    }

    //打开修改弹框--回显
    function openUpdate(id){

        $.ajax({
            url:"${ctx}/news/queryById",
            type:"post",
            data:{"id":id},
            success:function(data){

                //回显数据
                $("#myForm").form("load",data);
                $("#myDialog").dialog({
                    title:"修改新闻",
                    closed:false
                })
            }
        })
    }


    //新增修改广告
    function saveAd(){
        $("#myForm").form("submit",{
            url:"${ctx}/news/saveNews",
            success:function(){
                $.messager.alert("提示","保存成功","info");
                closeDialog();
                $("#myTable").datagrid("load");
            }
        })
    }

    //关闭弹框
    function closeDialog(){
        $("#myDialog").dialog("close");
    }

    //打开新增弹框
    function openDialog(){
        $("#myForm").form("reset");
        $("#myDialog").dialog({
            title:"新增新闻",
            closed:false
        })
    }

    //初始化用户表格
    function initmyTable(){
        $("#myTable").datagrid({
            url:"${ctx}/news/queryNews",
            title:"新闻",
            fit:true,
            pagination:true,
            toolbar:"#toolbar",
            columns:[[
                {field:"check",checkbox:true},
                {field:"id",title:"id"},
                {field:"title",title:"标题"},
                {field:"content",title:"内容"},
                {field:"staffName",title:"创建人"},
                {field:"type",title:"类型"},
                {field:"createTime",title:"创建时间"},
                {field:"tools",title:"操作",formatter:function(value,row,index){
                    return "<a href='javascript:openUpdate("+row.id+")'>修改</a>"+"||<a href='javascript:deleteNews("+row.id+")'>删除</a>";
                }}
            ]]
        })
    }

</script>
</html>
