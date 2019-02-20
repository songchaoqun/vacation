<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/20
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
</head>
<body>
<div id="searchException">
    <table>
        <tr>
            <td>
                <a href="javaScript:removeExceptionByIds()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
            </td>
        </tr>
    </table>
</div>
    <table id="exceptionList"></table>
    <script>
        $(function(){
            exceptionList();
        })
        //查询列表
        function exceptionList(){
            $("#exceptionList").datagrid({
                url:"<%=path%>/excption/queryExcption",
                fit:true,
                striped:true,
                loadMsg:'当前网络不好！请稍等......',
                pagination:true,
                pagePosition:'bottom',
                pageNumber:1,
                toolbar:"#searchException",
                columns:[[
                    {field:'id',title:'编号',align:'center',checkbox:true},
                    {field:'facility',title:'用户设备型号',align:'center'},
                    {field:'errorDate',title:'发生错误的时间',align:'center'},
                    {field:'url',title:'发生错误的路径',align:'center'},
                    {field:'ip',title:'操作的ip',align:'center'},
                    {field:'param',title:'错误的参数',align:'center'},
                    {field:'genre',title:'异常类型',align:'center'},
                    {field:'message',title:'异常信息',align:'center'},
                    {field:'操作',title:'操作',align:'center',
                        formatter: function(value,row,index){
                            var str = '<a href="javascript:removeException(\''+row.id+'\')">删除</a>';
                            return str;
                        }
                    }
                ]],
            });
        }
        //删除
        function removeException(val){
            $.messager.confirm('提示','你确定删除这条记录吗?',function(r){
                if(r){
                    $.ajax({
                        url: '<%=path%>/excption/deleteExcptionById',
                        type: 'post',
                        data: {id:val},
                        success: function(pm){
                            $.messager.alert('提示','删除成功');
                            return exceptionList();
                        },
                        error:function(){
                            $.messager.alert("提示","删除失败,请联系后台管理人员");
                        }
                    })
                }
            });
        }
        //批量删除数据
        function removeExceptionByIds(){
            var selRow = $("#exceptionList").datagrid('getSelections');
            if(selRow.length<=0){
                return $.messager.alert('提示','请选择要删除的数据');
            }
            var id = "";
            for(var i=0;i<selRow.length;i++){
                id += id == ""?selRow[i].id:","+selRow[i].id;
            }
            $.messager.confirm('提示','你确定删除这'+selRow.length+'条记录吗?',function(r){
                if(r){
                    $.ajax({
                        url: '<%=path%>/excption/deleteExcptionById',
                        type: 'post',
                        data: {id:id},
                        success: function(pm){
                            $.messager.alert('提示','删除成功');
                            return exceptionList();
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
