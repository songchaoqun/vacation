<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/13
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
</head>
<body>
    <div id="searchAnswer">
        <table>
            <tr>
                <td>
                    <a href="javaScript:openDialogAnswer('新增')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
                </td>
            </tr>
        </table>
    </div>
    <table id="AnswerList"></table>
    <div id="openAnswer">
        <form id="formId" method="post">
            <input type="hidden" name="problemId" value="${problem}" id="problemId">
            <table>
                <tr>
                    <td>答案内容</td>
                    <td>
                        <input type="text" class="easyui-validatebox" name="answerContent" data-options="required:true">
                    </td>
                </tr>
                <tr>
                    <td>回答问题的用户id</td>
                    <td>
                        <input name="sitesId" class="easyui-combobox" data-options="valueField:'id',textField:'sitesUserName',url:'${ctx}/sitesUser/queryCommentSitesUser'">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <script>
        $(function(){
            AnswerList();
        })
        //新增答案
        function openDialogAnswer(text){
            $("#openAnswer").dialog({
                title:text+'问题',
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
                            url:"${ctx}/answer/addAnswer",
                            success:function(pm){
                                $("#formId").form("reset");
                                $("#openAnswer").dialog("close");
                                $.messager.alert("提示","新增成功");
                                AnswerList();
                            }
                        })
                    }
                },{
                    text:'取消',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $("#formId").form("reset");
                        $("#openAnswer").dialog("close");
                    }
                }],
                onClose:function(){
                    $("#formId").form("reset");
                }
            });
        }
        //查询问题对应答案
        function AnswerList(){
            $("#AnswerList").datagrid({
                url:'${ctx}/answer/queryAnswer?id='+$("#problemId").val(),
                fit:true,
                fitColumns:true,
                striped:true,
                loadMsg:'当前网络不好！请稍等......',
                pagination:true,
                pagePosition:'bottom',
                pageNumber:1,
                pageSize:3,
                pageList:[3,6,15,21,42],
                toolbar:"#searchAnswer",
                columns:[[
                    {field:'id',title:'编号',align:'center',checkbox:true},
                    {field:'answerContent',title:'答案内容',align:'center'},
                    {field:'answerCreateTime',title:'回答时间',align:'center'},
                    {field:'sitesId',title:'回答问题的用户id',align:'center'},
                    {field:'problemId',title:'关联问题表的Id',align:'center'},
                    {field:'tool',title:'操作',align:'center',
                        formatter: function(value,row,index){
                            var str = '<a href="javascript:removeAnswer('+row.id+')">删除</a>';
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
        //删除该条答案
        function removeAnswer(val) {
            $.messager.confirm('提示','你确定删除这条记录吗?',function(r){
                if(r){
                    $.ajax({
                        url: '${ctx}/answer/deleteAnswer',
                        type: 'post',
                        data: {id:val},
                        success: function(pm){
                            AnswerList();
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
