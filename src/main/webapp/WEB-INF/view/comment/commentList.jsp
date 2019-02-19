<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/12
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
</head>
<body>
    <div id="searchComment">
        <table>
            <tr>
                <td>
                    <a href="javaScript:openDialogComment('新增')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
                </td>
            </tr>
        </table>
    </div>
    <table id="commentList"></table>
    <div id="openComment">
        <form id="formId" method="post">
            <input type="hidden" name="id" id="id">
            <table>
                <tr>
                    <td>评论的课程</td>
                    <td>
                        <input name="catalogId" class="easyui-combobox" data-options="valueField:'id',textField:'content',url:'${ctx}/course/queryCourseList'">
                    </td>
                </tr>
                <tr>
                    <td>评论内容</td>
                    <td>
                        <input class="easyui-textbox" name="content" data-options="multiline:true,height:400,width:400" >
                    </td>
                </tr>
                <tr>
                    <td>用户评论</td>
                    <td>
                        <input name="sitesId" class="easyui-combobox" data-options="valueField:'id',textField:'sitesUserName',url:'${ctx}/sitesUser/queryCommentSitesUser'">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <script>
        $(function(){
            commentList();
        })
        //修改评论
        function updateComment(){
            $("#formId").form('submit',{
                url:"${ctx}/comment/updateComment",
                success:function(pm){
                    $("#formId").form("reset");
                    $("#openComment").dialog("close");
                    $.messager.alert("提示","修改成功");
                    commentList();
                }
            })
        }
        //新增评论
        function addComment(){
            $("#formId").form('submit',{
                url:"${ctx}/comment/addComment",
                success:function(pm){
                    $("#formId").form("reset");
                    $("#openComment").dialog("close");
                    $.messager.alert("提示","新增成功");
                    commentList();
                }
            })
        }
        function openDialogComment(text){
            $("#openComment").dialog({
                title:text+'评论',
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
                            updateComment();
                        }else{
                            addComment();
                        }
                    }
                },{
                    text:'取消',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $("#formId").form("reset");
                        $("#openComment").dialog("close");
                    }
                }],
                onClose:function(){
                    $("#formId").form("reset");
                }
            });
        }
        //查询评论
        function commentList(){
            $("#commentList").datagrid({
                url:'${ctx}/comment/queryComment',
                fit:true,
                fitColumns:true,
                striped:true,
                loadMsg:'当前网络不好！请稍等......',
                pagination:true,
                pagePosition:'bottom',
                pageNumber:1,
                pageSize:3,
                pageList:[3,6,15,21,42],
                toolbar:"#searchComment",
                columns:[[
                    {field:'id',title:'编号',align:'center',checkbox:true},
                    {field:'sitesId',title:'用户评论id',align:'center'},
                    {field:'catalogId',title:'评论的课程id',align:'center'},
                    {field:'content',title:'评论内容',align:'center'},
                    {field:'commentTime',title:'评论创建时间',align:'center'},
                    {field:'status',title:'状态',align:'center',
                        formatter: function(value,row,index){
                            return "正常";
                        }
                    },
                    {field:'tool',title:'操作',align:'center',
                        formatter: function(value,row,index){
                            var str = '<a href="javascript:removeComment('+row.id+')">删除</a>' +
                                '  <a href="javascript:updateCommentById('+row.id+')">修改</a>';
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
        //修改回显
        function updateCommentById(val){
            $.messager.confirm('提示','你确定修改这条记录吗?',function(r){
                if(r){
                    $.ajax({
                        url: '${ctx}/comment/queryCommentById',
                        type: 'post',
                        data: {id:val},
                        success: function(pm){
                            openDialogComment('修改');
                            $("#formId").form('load',pm);
                        },
                        error:function(){
                            $.messager.alert("提示","回显失败,请联系后台管理人员");
                        }
                    })
                }
            });
        }
        //删除评论
        function removeComment(val){
            $.messager.confirm('提示','你确定删除这条记录吗?',function(r){
                if(r){
                    $.ajax({
                        url: '${ctx}/comment/deleteComment',
                        type: 'post',
                        data: {id:val},
                        success: function(pm){
                            commentList();
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
