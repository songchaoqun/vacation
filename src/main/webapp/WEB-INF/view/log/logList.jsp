<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/20
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
</head>
<body>
    <div id="searchLog">
        <table>
            <tr>
                <td>
                    <a href="javaScript:removeLogByIds()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
                </td>
            </tr>
        </table>
    </div>
    <table id="logList"></table>
    <script>
        $(function(){
            queryLog();
        })
        //查询列表
        function queryLog(){
            $("#logList").datagrid({
                url:"<%=path%>/log/queryLog",
                fit:true,
                striped:true,
                loadMsg:'当前网络不好！请稍等......',
                pagination:true,
                pagePosition:'bottom',
                pageNumber:1,
                toolbar:"#searchLog",
                columns:[[
                    {field:'id',title:'编号',align:'center',checkbox:true},
                    {field:'userName',title:'用户名称',align:'center'},
                    {field:'className',title:'实体类名',align:'center'},
                    {field:'method',title:'方法名',align:'center'},
                    {field:'reqParam',title:'参数',align:'center'},
                    {field:'createTime',title:'创建时间',align:'center'},
                    {field:'ip',title:'IP地址',align:'center'},
                    {field:'url',title:'请求的方法',align:'center'},
                    {field:'操作',title:'操作',align:'center',
                        formatter: function(value,row,index){
                            var str = '<a href="javascript:removeLog(\''+row.id+'\')">删除</a>';
                            return str;
                        }
                    }
                ]],
            });
        }
        //删除
        function removeLog(val){
            $.messager.confirm('提示','你确定删除这条记录吗?',function(r){
                if(r){
                    $.ajax({
                        url: '<%=path%>/log/deleteLogById',
                        type: 'post',
                        data: {id:val},
                        success: function(pm){
                            $.messager.alert('提示','删除成功');
                            return queryLog();
                        },
                        error:function(){
                            $.messager.alert("提示","删除失败,请联系后台管理人员");
                        }
                    })
                }
            });
        }
        //批量删除数据
        function removeLogByIds(){
            var selRow = $("#logList").datagrid('getSelections');
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
                        url: '<%=path%>/log/deleteLogById',
                        type: 'post',
                        data: {id:id},
                        success: function(pm){
                            $.messager.alert('提示','删除成功');
                            return queryLog();
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
