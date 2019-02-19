<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/13
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
</head>
<body>
    <div id="searchProblem">
        <table>
            <tr>
                <td>
                    <a href="javaScript:openDialogProblem('新增')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
                </td>
            </tr>
        </table>
    </div>
    <table id="ProblemList"></table>
    <div id="openProblem">
        <form id="formId" method="post">
            <table>
                <tr>
                    <td>提出的问题</td>
                    <td>
                        <input type="text" class="easyui-validatebox" name="problemName" data-options="required:true">
                    </td>
                </tr>
                <tr>
                    <td>是否为热门</td>
                    <td>
                        <select name="hottest">
                            <option value="1">是</option>
                            <option value="0">不是</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>提出问题的id</td>
                    <td>
                        <input name="sitesId" class="easyui-combobox" data-options="valueField:'id',textField:'sitesUserName',url:'${ctx}/sitesUser/queryCommentSitesUser'">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <script>
        $(function(){
            ProblemList();
        })
        //新增问题
        function openDialogProblem(text){
            $("#openProblem").dialog({
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
                            url:"${ctx}/problem/addProblem",
                            success:function(pm){
                                $("#formId").form("reset");
                                $("#openProblem").dialog("close");
                                $.messager.alert("提示","新增成功");
                                ProblemList();
                            }
                        })
                    }
                },{
                    text:'取消',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $("#formId").form("reset");
                        $("#openProblem").dialog("close");
                    }
                }],
                onClose:function(){
                    $("#formId").form("reset");
                }
            });
        }
        //查询问题
        function ProblemList(){
            $("#ProblemList").datagrid({
                url:'${ctx}/problem/queryProblem',
                fit:true,
                fitColumns:true,
                striped:true,
                loadMsg:'当前网络不好！请稍等......',
                pagination:true,
                pagePosition:'bottom',
                pageNumber:1,
                pageSize:3,
                pageList:[3,6,15,21,42],
                toolbar:"#searchProblem",
                columns:[[
                    {field:'id',title:'编号',align:'center',checkbox:true},
                    {field:'problemName',title:'提出的问题',align:'center'},
                    {field:'problemCreateTime',title:'问题的创建时间',align:'center'},
                    {field:'hottest',title:'是否为热门',align:'center',
                        formatter: function(value,row,index){
                            return value == 1 ? "是" : "不是";
                        }
                    },
                    {field:'sitesId',title:'提出问题的id',align:'center'},
                    {field:'tool',title:'操作',align:'center',
                        formatter: function(value,row,index){
                            var str = '<a href="javascript:removeProblem('+row.id+')">删除</a>' +
                            '   <a href="javascript:addAnswer('+row.id+')">添加答案</a>';
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
        //给问题添加答案
        function addAnswer(val){
            location.href = "${ctx}/menu/answerList?id="+val;
        }
        //删除问题
        function removeProblem(val){
            $.messager.confirm('提示','你确定删除这条记录吗?',function(r){
                if(r){
                    $.ajax({
                        url: '${ctx}/problem/deleteProblem',
                        type: 'post',
                        data: {id:val},
                        success: function(pm){
                            ProblemList();
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
