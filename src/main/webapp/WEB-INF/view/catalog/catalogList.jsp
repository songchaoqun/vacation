<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/12
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
</head>
<body>
    <div id="searchCatalog">
        <a href="javaScript:openDialogCatalog('新增')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
    </div>
    <table id="catalogList" class="easyui-treegrid"></table>
    <div id="openCatalog">
        <form id="formId" method="post">
            <table>
                <tr>
                    <td>目录名称</td>
                    <td>
                        <input type="text" class="easyui-validatebox" name="moldName" data-options="required:true">
                    </td>
                </tr>
                <tr>
                    <td>视频跳转路径</td>
                    <td>
                        <input type="text" class="easyui-validatebox" name="moldUrl" data-options="required:true">
                    </td>
                </tr>
                <tr>
                    <td>课程名称</td>
                    <td>
                        <input name="courseId" class="easyui-combobox" data-options="valueField:'id',textField:'content',url:'${ctx}/course/queryCourseList'">
                    </td>
                </tr>
                <tr>
                    <td>上级名称</td>
                    <td>
                        <input name="pid" class="easyui-combobox" data-options="valueField:'id',textField:'moldName',url:'${ctx}/catalog/queryHostCatalog'">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <script>
        $(function(){
            catalogList();
        })
        //新增目录
        function openDialogCatalog(text){
            $("#openCatalog").dialog({
                title:text+'目录',
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
                            url:"${ctx}/catalog/addCatalog",
                            success:function(pm){
                                $("#formId").form("reset");
                                $("#openCatalog").dialog("close");
                                $.messager.alert("提示","新增成功");
                                catalogList();
                            }
                        })
                    }
                },{
                    text:'取消',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $("#formId").form("reset");
                        $("#openCatalog").dialog("close");
                    }
                }],
                onClose:function(){
                    $("#formId").form("reset");
                }
            });
        }
        //查询所有目录
        function catalogList(){
            $('#catalogList').treegrid({
                url:'<%=path%>/catalog/queryCatalog',
                idField:'id',
                treeField:'moldName',
                fit:true,
                checkOnSelect:false,
                selectOnCheck:false,
                toolbar:"#searchCatalog",
                checked:false,
                checkbox:true,
                columns:[[
                    {field:'id',title:'编号'},
                    {field:'moldName',title:'目录名称'},
                    {field:'moldUrl',title:'视频跳转路径'},
                    {field:'courseName',title:'课程名称'},
                    {field:'pid',title:'pid'},
                    {field:'tool',title:'操作',align:'center',
                        formatter: function(value,row,index){
                            var str = '<a href="javascript:removeCatalog('+row.id+')">删除</a>';
                            return str;
                        }
                    }
                ]]
            });
        }
        // 删除目录
        function removeCatalog(val){
            $.messager.confirm('提示','你确定删除这条记录吗?',function(r){
                if(r){
                    $.ajax({
                        url: '${ctx}/catalog/deleteCatalog',
                        type: 'post',
                        data: {id:val},
                        success: function(pm){
                            catalogList();
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
