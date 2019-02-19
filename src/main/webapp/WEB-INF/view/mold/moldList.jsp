<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/11
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
</head>
<body>
    <div id="searchMold">
        <table>
            <tr>
                <td>
                    <a href="javaScript:openDialogMold('新增')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
                </td>
            </tr>
        </table>
    </div>
    <table id="moldList"></table>
    <div id="openMold">
        <form id="formId" method="post">
            <table>
                <tr>
                    <td>类型名称</td>
                    <td>
                        <input type="text" class="easyui-validatebox" name="name" data-options="required:true">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <script>
        $(function(){
            moldList();
        })
        //新增类型
        function openDialogMold(text){
            $("#openMold").dialog({
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
                            url:"${ctx}/mold/addMold",
                            success:function(pm){
                                $("#formId").form("reset");
                                $("#openMold").dialog("close");
                                $.messager.alert("提示","新增成功");
                                moldList();
                            }
                        })
                    }
                },{
                    text:'取消',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $("#formId").form("reset");
                        $("#openMold").dialog("close");
                    }
                }],
                onClose:function(){
                    $("#formId").form("reset");
                }
            });
        }
        //查询所有类型
        function moldList(){
            $("#moldList").datagrid({
                url:'${ctx}/mold/queryMold',
                fit:true,
                fitColumns:true,
                striped:true,
                loadMsg:'当前网络不好！请稍等......',
                pagination:true,
                pagePosition:'bottom',
                pageNumber:1,
                pageSize:3,
                pageList:[3,6,15,21,42],
                toolbar:"#searchMold",
                columns:[[
                    {field:'id',title:'编号',align:'center',checkbox:true},
                    {field:'name',title:'类型名称',align:'center'},
                    {field:'tool',title:'操作',align:'center',
                        formatter: function(value,row,index){
                            var str = '<a href="javascript:removeMold('+row.id+')">删除</a>';
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
        //删除类型
        function removeMold(val){
            $.messager.confirm('提示','你确定删除这条记录吗?',function(r){
                if(r){
                    $.ajax({
                        url: '${ctx}/mold/deleteMold',
                        type: 'post',
                        data: {id:val},
                        success: function(pm){
                            moldList();
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
