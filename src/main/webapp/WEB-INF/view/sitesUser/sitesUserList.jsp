<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/12
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
</head>
<body>
    <div id="searchSitesUser">
        <table>
            <tr>
                <td>
                    <a href="javaScript:openDialogSitesUser('新增')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
                    <a href="javaScript:Recycle()" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查看回收站</a>
                </td>
            </tr>
        </table>
    </div>
    <table id="sitesUserList"></table>
    <div id="openSitesUser">
        <form id="formId" method="post">
            <input type="hidden" name="id" id="id">
            <table>
                <tr>
                    <td>用户名称</td>
                    <td>
                        <input type="text" class="easyui-validatebox" name="sitesUserName" data-options="required:true">
                    </td>
                </tr>
                <tr>
                    <td>账号</td>
                    <td>
                        <input type="text" class="easyui-validatebox" name="sitesName" data-options="required:true">
                    </td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td>
                        <input type="password" class="easyui-validatebox" name="password" data-options="required:true">
                    </td>
                </tr>
                <tr>
                    <td>手机号</td>
                    <td>
                        <input type="text" class="easyui-validatebox" name="sitesPhone" data-options="required:true">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <script>
        $(function(){
            sitesUserList();
        })
        //查看被删除的用户
        function Recycle(){
            location.href = "${ctx}/menu/recycle";
        }
        //修改网站用户
        function updateSitesUserList(){
            $("#formId").form('submit',{
                url:"${ctx}/sitesUser/updateSitesUser",
                success:function(pm){
                    $("#formId").form("reset");
                    $("#openSitesUser").dialog("close");
                    $.messager.alert("提示","修改成功");
                    sitesUserList();
                }
            })
        }
        //新增网站用户
        function addSitesUser(){
            $("#formId").form('submit',{
                url:"${ctx}/sitesUser/addSitesUser",
                success:function(pm){
                    $("#formId").form("reset");
                    $("#openSitesUser").dialog("close");
                    $.messager.alert("提示","新增成功");
                    sitesUserList();
                }
            })
        }
        function openDialogSitesUser(text){
            $("#openSitesUser").dialog({
                title:text+'用户',
                width:600,
                height:540,
                closed:false,
                //可以调整大小
                resizable:true,
                cache:false,
                //背景添加阴影
                modal:true,
                buttons:[{
                    text:text,
                    iconCls:'icon-save',
                    handler:function(){
                        if($("#id").val() != null && $("#id").val() != ''){
                            updateSitesUserList();
                        }else{
                            addSitesUser();
                        }
                    }
                },{
                    text:'取消',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $("#formId").form("reset");
                        $("#openSitesUser").dialog("close");
                    }
                }],
                onClose:function(){
                    $("#formId").form("reset");
                }
            });
        }
        //查询网站用户信息
        function sitesUserList(){
            $("#sitesUserList").datagrid({
                url:'${ctx}/sitesUser/querySitesUser',
                fit:true,
                fitColumns:true,
                striped:true,
                loadMsg:'当前网络不好！请稍等......',
                pagination:true,
                pagePosition:'bottom',
                pageNumber:1,
                pageSize:3,
                pageList:[3,6,15,21,42],
                toolbar:"#searchSitesUser",
                columns:[[
                    {field:'id',title:'编号',align:'center',checkbox:true},
                    {field:'sitesName',title:'账号',align:'center'},
                    {field:'password',title:'密码',align:'center'},
                    {field:'sitesUserName',title:'用户名称',align:'center'},
                    {field:'sitesPhone',title:'手机号',align:'center'},
                    {field:'state',title:'状态',align:'center',
                        formatter: function(value,row,index){
                            return "正常";
                        }
                    },
                    {field:'tool',title:'操作',align:'center',
                        formatter: function(value,row,index){
                            var str = '<a href="javascript:removeSitesUser('+row.id+')">删除</a>' +
                            '  <a href="javascript:updateSitesUser('+row.id+')">修改</a>';
                            return str;
                        }
                    },
                ]],
                rowStyler: function(index,row){
                    if(index%2 == 0){
                        return 'background-color:red;';
                    }
                    return 'background-color:#9933FF;';
                }
            })
        }
        //用户修改回显
        function updateSitesUser(val){
            $.messager.confirm('提示','你确定修改这条记录吗?',function(r){
                if(r){
                    $.ajax({
                        url: '${ctx}/sitesUser/querySitesUserList',
                        type: 'post',
                        data: {id:val},
                        success: function(pm){
                            openDialogSitesUser('修改');
                            $("#formId").form('load',pm);
                        },
                        error:function(){
                            $.messager.alert("提示","回显失败,请联系后台管理人员");
                        }
                    })
                }
            });
        }
        //删除网站用户
        function removeSitesUser(val){
            $.messager.confirm('提示','你确定删除这条记录吗?',function(r){
                if(r){
                    $.ajax({
                        url: '${ctx}/sitesUser/deleteSitesUser',
                        type: 'post',
                        data: {id:val},
                        success: function(pm){
                            sitesUserList();
                        },
                        error:function(){
                            $.messager.alert("提示","删除失败,请联系后台管理人员");
                        }
                    })
                }
            });
        }
    </script>
</body>
</html>
