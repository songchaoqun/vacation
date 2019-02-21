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
<%--    <div id="searchStaff">
        <table>
            <tr>
                <td>
                    <a href="javaScript:openDialogStaff('新增')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
                    用户名:<input class="easyui-textbox" id="staffName">
                    <a href="javascript:searchUser()" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
                </td>
            </tr>
        </table>
    </div>--%>
    <table id="packList"></table>
<%--    <div id="openStaff">
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
    </div>--%>
    <script>
        $(function(){
            packList();
        })
        //查询员工
        function packList(){
            $("#packList").datagrid({
                url:'${ctx}/pack/queryPackages',
                fit:true,
/*                fitColumns:true,
                striped:true,*/
                loadMsg:'当前网络不好！请稍等......',
/*                pagination:true,
                pagePosition:'bottom',
                pageNumber:1,
                pageSize:3,
                pageList:[3,6,15,21,42],
                toolbar:"#searchStaff",*/
                columns:[[
                    {field:'pId',title:'套餐编号',align:'center',checkbox:true},
                    {field:'pName',title:'套餐名称',align:'center'},
                    {field:'price',title:'价格',align:'center'},
                    {field:'membersName',title:'会员名称',align:'center'}
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


    </script>
</body>
</html>
