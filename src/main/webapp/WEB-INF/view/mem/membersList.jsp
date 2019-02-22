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
                    <a href="javaScript:openDialog('新增')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">成为会员</a>
                </td>
            </tr>
        </table>
    </div>
    <table id="membersTable"></table>
    <div id="openStaff">
        <form id="formId" method="post">
            <input  style="display:none"  name="ids" id="ids">
            <input type="hidden" class="easyui-validatebox" name="uid" >
            <table>
                <tr>
                    <td>会员类型</td>
                    <td>
                        <input id="mid" class="easyui-combotree" name="mid" style="width:180px">
                    </td>
                </tr>
                <tr>
                    <td>结束时间</td>
                    <td>
                    <%--    <input  style="display:none"  class="easyui-datebox" name="createDate">--%>
                        <input class="easyui-datebox" name="duetoDate">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <script>
        $(function(){
            staffList();
            queryMem();
        })


        //新增员工
        function openDialog(text){
            $("#openStaff").dialog({
                title:text+'会员',
                width:600,
                height:540,
                closed:false,
                //可以调整大小
                resizable:true,
                cache:false,
                //背景添加阴影
                modal:true,
                buttons:[{
                    text:'确定',
                    iconCls:'icon-save',
                    handler:function(){

                        // 通过id来控制，执行新增还是修改的函数
                        if($("#ids").val() != null && $("#ids").val() != ''){
                            // 有id 走修改
                            upMem();
                        } else {
                            // 没有id 走新增
                            memAdd();
                        }

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
        //查询会员列表
        function staffList(){
            $("#membersTable").datagrid({
                url:'${ctx}/members/queryMemners',
                fit:true,
                loadMsg:'当前网络不好！请稍等......',
                pagination:true,
                pagePosition:'bottom',
                pageNumber:1,
                pageSize:3,
                pageList:[3,6,15,21,42],
                toolbar:"#searchStaff",
                columns:[[
                    {field:'membersId',title:'会员编号',align:'center',checkbox:true},
                    {field:'membersName',title:'会员名称',align:'center'},
                    {field:'createDate',title:'创建时间',align:'center'},
                    {field:'pName',title:'套餐名称',align:'center'},
                    {field:'duetoDate',title:'到期时间',align:'center'},
                    {field:'sitesUserName',title:'用户名',align:'center'},
                    {field:'tool',title:'操作',align:'center',
                        formatter: function(value,row,index){
                            var str = '<a href="javascript:queryMembersId('+row.membersId+')">修改</a>';
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

        //加载会员
        function queryMem(){
            $("#mid").combobox({
                url:"<%=request.getContextPath() %>/members/queryMem",
                valueField:"membersId",
                textField:"membersName"
            })
        }

        //成为会员
        function memAdd(){
            $("#formId").form("submit",{
                url:"<%=request.getContextPath() %>/members/saveMem",
                success:function(data){
                        $.messager.alert("提示",data,"info");
                        $("#membersTable").datagrid("load");
                        $("#openStaff").dialog("close");
                        if(data=="购买成功"){
                            $("#membersTable").datagrid("load");
                            $("#openStaff").dialog("close");
                        }
                }
            })

        }

        //修改回显
         function queryMembersId(membersId){
             $.ajax({
                 url:"<%=request.getContextPath()%>/members/queryBymId",
                 data:{membersId:membersId},
                 type: 'post',
                 success:function(data){
                     openDialog('修改');
                     $("#formId").form('load',data);
                 },error:function(){
                     $.messager.alert("提示","错误","info");
                 }

             })
         }

         function  upMem(){
             $("#formId").form("submit",{
                 url:"<%=request.getContextPath() %>/members/upMem",
                 success:function(){
                     $.messager.alert("提示","修改成功","info");
                         $("#membersTable").datagrid("load");
                         $("#openStaff").dialog("close");
                     }
             })

         }


    </script>
</body>
</html>
