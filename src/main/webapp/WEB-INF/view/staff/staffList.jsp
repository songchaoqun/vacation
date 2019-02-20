<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/25
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
</head>
<body>
    <div id="searchStaff">
        <table>
            <tr>
                <td>
                    <a href="javaScript:openDialogStaff('新增')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
                    用户名:<input class="easyui-textbox" id="staffName">
                    <a href="javascript:searchUser()" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
                </td>
            </tr>
        </table>
    </div>
    <table id="staffList"></table>
    <div id="openStaff">
        <form id="formId" method="post">
            <table>
                <tr>
                    <td>员工账号</td>
                    <td>
                        <input type="text" class="easyui-validatebox" name="staffName" data-options="required:true">
                    </td>
                </tr>
                <tr>
                    <td>员工密码</td>
                    <td>
                        <input type="text" class="easyui-validatebox" name="password" data-options="required:true">
                    </td>
                </tr>
                <tr>
                    <td>角色</td>
                    <td>
                        <input name="roleIds" class="easyui-combobox" data-options="required:true,multiple:true,valueField:'id',textField:'name',url:'${ctx}/staffRole/selectStaffRoleNames'">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <script>
        $(function(){
            staffList();
        })
        //新增员工
        function openDialogStaff(text){
            $("#openStaff").dialog({
                title:text+'员工',
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
                        $("#formId").form('submit',{
                            url:"${ctx}/staff/addStaff",
                            success:function(pm){
                                $("#formId").form("reset");
                                $("#openStaff").dialog("close");
                                $.messager.alert("提示","新增成功");
                                staffList();
                            }
                        })
                    }
                },{
                    text:'取消',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $("#formId").form("reset");
                        $("#openStaff").dialog("close");
                    }
                }],
                onClose:function(){
                    $("#formId").form("reset");
                }
            });
        }
        //查询员工
        function staffList(){
            $("#staffList").datagrid({
                url:'${ctx}/staff/queryStaffList',
                fit:true,
                fitColumns:true,
                striped:true,
                loadMsg:'当前网络不好！请稍等......',
                pagination:true,
                pagePosition:'bottom',
                pageNumber:1,
                pageSize:3,
                pageList:[3,6,15,21,42],
                toolbar:"#searchStaff",
                columns:[[
                    {field:'id',title:'编号',align:'center',checkbox:true},
                    {field:'staffName',title:'用户姓名',align:'center'},
                    {field:'password',title:'角色',align:'center'},
                    {field:'tool',title:'操作',align:'center',
                        formatter: function(value,row,index){
                            var str = '<a href="javascript:removeStaff('+row.id+')">删除</a>';
                            return str;
                        }
                    },
                ]],
                //rowStyler 调整奇偶行颜色
                rowStyler: function(index,row){
                    if(index%2 == 0){
                        return 'background-color:red;';
                    }
                    return 'background-color:#9933FF;';
                }
            })
        }
        //删除员工
        function removeStaff(val){
            $.messager.confirm('提示','你确定删除这条记录吗?',function(r){
                if(r){
                    $.ajax({
                        url: '${ctx}/staff/deleteStaff',
                        type: 'post',
                        data: {id:val},
                        success: function(pm){
                            staffList();
                        },
                        error:function(){
                            $.messager.alert("提示","删除失败,请联系后台管理人员");
                        }
                    })
                }
            });
        }

        function  searchUser(){
            $('#staffList').datagrid({
                queryParams:{
                    staffName:$("#staffName").textbox("getValue")
                }
            })
        }


    </script>
</body>
</html>
