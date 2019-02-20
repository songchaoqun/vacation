<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/25
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
</head>
<body>
    <div class="easyui-layout" data-options="fit:true">
        <%-- 角色表功能布局 --%>
        <div data-options="region:'west',split:false,collapsible:false,title:'角色列表'" style="width:30%">
            <div id="searchRole">
                <table>
                    <tr>
                        <td>
                            <a href="javaScript:openDialogRole('新增')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
                        </td>
                    </tr>
                </table>
            </div>
            <table id="staffRoleList"></table>
            <div id="openRole">
                <form id="formId" method="post">
                    <table>
                        <tr>
                            <td>角色名称</td>
                            <td>
                                <input type="text" class="easyui-validatebox" name="name" data-options="required:true">
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <script>
            $(function () {
                staffRoleList();
                queryRoleTree(-1);
            })
            //新增角色
            function openDialogRole(text){
                $("#openRole").dialog({
                    title:text+'角色',
                    width:300,
                    height:150,
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
                                url:"<%=path%>/staffRole/addStaffRole",
                                success:function(pm){
                                    $("#formId").form("reset");
                                    $("#openRole").dialog("close");
                                    $("#staffRoleList").datagrid("load");
                                }
                            })

                        }
                    },{
                        text:'取消',
                        iconCls:'icon-cancel',
                        handler:function(){
                            $("#openRole").dialog("close");
                            $("#formId").form("reset");
                        }
                    }],
                    onClose:function(){
                        $("#formId").form("reset");
                    }
                });
            }
            //删除角色信息
            function removeStaffRole(val){
                $.messager.confirm('提示','你确定删除这条记录吗?',function(r){
                    if(r){
                        $.ajax({
                            url: '<%=path%>/staffRole/deleteStaffRole',
                            type: 'post',
                            data: {id:val},
                            success: function(pm){
                                if(pm==1){
                                    $.messager.alert('提示','删除成功');
                                    return $("#staffRoleList").datagrid("load");
                                }else{
                                    $.messager.alert('提示','删除失败,该角色和用户表有关联关系无法删除');
                                    return $("#staffRoleList").datagrid("load");
                                }
                                $.messager.alert("提示","请确定该数据是否存在");
                            },
                            error:function(){
                                $.messager.alert("提示","删除失败,请联系后台管理人员");
                            }
                        })
                    }
                });
            }
            //查询角色信息
            function staffRoleList(){
                $("#staffRoleList").datagrid({
                    url:'${ctx}/staffRole/queryStaffRoleList',
                    fit:true,
                    fitColumns:true,
                    striped:true,
                    loadMsg:'当前网络不好！请稍等......',
                    pagination:true,
                    pagePosition:'bottom',
                    pageNumber:1,
                    pageSize:3,
                    pageList:[3,6,15,21,42],
                    toolbar:"#searchRole",
                    columns:[[
                        {field:'id',title:'编号',align:'center',checkbox:true},
                        {field:'name',title:'角色名称',align:'center'},
                        {field:'tool',title:'操作',align:'center',
                            formatter: function(value,row,index){
                                var str = '<a href="javascript:removeStaffRole('+row.id+')">删除</a>'
                                + '  <a href="javascript:bindRoleTree('+row.id+')">绑定权限</a>';
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
            //绑定权限
            function bindRoleTree(val){
                $("#id").val(val);
                queryRoleTree(val);
            }
        </script>
            <div data-options="region:'center',split:false,collapsible:false,footer:'#ft',title:'权限列表'" style="width:40%">
            <!-- 关联角色权限表的中间表的角色ID -->
            <input type="hidden" name="id" id="id">
            <!-- 右键出弹框 -->
            <div id="mm" class="easyui-menu" style="width:120px;">
                <div onclick="openDialogTree('新增')" data-options="iconCls:'icon-add'">添加</div>
                <div onclick="removeTree()" data-options="iconCls:'icon-remove'">删除</div>
            </div>
            <!-- 定义树 -->
            <ul id="roleTree"></ul>
            <!-- 页脚 -->
            <div id="ft" style="text-align:right">
                <a class="easyui-linkbutton" onclick="saveTree()" data-options="iconCls:'icon-save',plain:true">绑定权限</a>
            </div>
            <div id="openTree" hidden>
                <form id="formIds" method="post">
                    <table>
                        <tr>
                            <td>权限内容</td>
                            <td>
                                <input type="text" class="easyui-validatebox" name="text" data-options="required:true">
                            </td>
                        </tr>
                        <tr>
                            <td>权限节点</td>
                            <td>
                                <select id="pid" name="pid" class="easyui-combotree" style="width:200px;" ></select>
                            </td>
                        </tr>
                        <tr>
                            <td>权限路径</td>
                            <td>
                                <input name="url" type="text" required="required" />
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <script>
            //新增权限
            function openDialogTree(){
                //弹出权限树
                function openDialogNav(text){
                    queryTreeCombotree();
                    $("#openTree").dialog({
                        title:text,
                        width:300,
                        height:240,
                        closed:false,
                        resizable:true,
                        cache:false,
                        modal:true,
                        buttons:[{
                            text:text+'权限',
                            iconCls:'icon-save',
                            handler:function(){
                                $("#formIds").form('submit',{
                                    url:"${ctx}/tree/addTree",
                                    success:function(pm){
                                        $.messager.alert("提示","新增权限成功");
                                        $("#formIds").form("reset");
                                        $("#openTree").dialog("close");
                                        queryRoleTree(-1);
                                    }
                                })
                            }
                        },{
                            text:'取消',
                            iconCls:'icon-cancel',
                            handler:function(){
                                $("#formIds").form('reset');
                                $("#openTree").dialog("close");
                            }
                        }],
                        onClose:function(){
                            $("#formIds").form('reset');
                        }
                    });
                }
            }
            //combotree树 下拉权限节点
            function queryTreeCombotree(){
                $('#pid').combotree({
                    url:"<%=path%>/tree/queryTreeList",
                });
            }
            //删除权限
            function removeTree(){
                var Tree = $("#roleTree").tree("getSelected");
                $.post('${ctx}/tree/deleteTree',{'id':Tree.id},function(data){
                    if(data == 1){
                        $.messager.alert('提示','权限(子节点)删除成功','info');
                        return queryRoleTree(-1);
                    }
                    $.messager.alert('提示','权限已被绑定,不能删除','info');
                });
            }
            //保存绑定权限
            function saveTree(){
                var id = $("#id").val();
                var treeArr = $("#roleTree").tree("getChecked");
                var powerIds = "";
                for(var i=0;i<treeArr.length;i++){
                    powerIds += powerIds==""?treeArr[i].id:","+treeArr[i].id;
                }
                $.post('${ctx}/tree/addRoleTree',{'id':id,'treeRoleIds':powerIds},function(data){
                    if(data == 1){
                        $.messager.alert('提示','权限绑定成功','info');
                        return queryRoleTree($("#id").val());
                    }
                    $.messager.alert('提示','权限绑定失败','info');
                });
            }
            //查询权限树
            function queryRoleTree(val){
                $("#roleTree").tree({
                    url: '${ctx}/tree/queryRoleTreeList?id='+val,
                    checkbox:true,
                    onContextMenu:function(e, node){
                        // 阻止浏览器自带右击事件
                        e.preventDefault();
                        // 点击当前节点触发
                        $('#roleTree').tree('select', node.target);
                        // 显示右击菜单
                        $('#mm').menu('show', {
                            left: e.pageX,
                            top: e.pageY
                        });
                    },
                    onClick:function(node){
                        selectWay(node.id);
                        $("#treeId").val(node.id);
                    },
                })
            }
        </script>
        <div data-options="region:'east',split:false,collapsible:false,title:'权限详细'" style="width:30%">
            <div id="toolWay">
                <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addOrUpdateWay('添加')">添加</a>
            </div>
            <table id="listWay"></table>
            <div id="openWay" hidden="true">
                <form id="formIdWay" method="post">
                    <input type="hidden" name="treeId" id="treeId">
                    <input type="hidden" name="id" id="ids">
                    <table>
                        <tr>
                            <td>详情名称</td>
                            <td>
                                <input type="text" class="easyui-validatebox" name="name" data-options="required:true">
                            </td>
                        </tr>
                        <tr>
                            <td>详情地址</td>
                            <td>
                                <input type="text" class="easyui-validatebox" name="url" data-options="required:true">
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <script>
            //查询权限路径
            function selectWay(val){
                $("#listWay").datagrid({
                    url: "${ctx}/way/queryWayList?id=" + val,
                    fit: true,
                    toolbar: "#toolWay",
                    columns: [[
                        {field:'id',title:'编号',checkbox:true},
                        {field:'name',title:'权限详情名称'},
                        {field:'url',title:'权限详情地址'},
                        {field:'操作',title:'操作',
                            formatter: function(value,row,index){
                                var str = '<a href="javascript:removeWay('+row.id+')">删除</a>';
                                return str;
                            }
                        }
                    ]]
                })
            }
            //新增权限路径
            function addOrUpdateWay(text){
                $("#openWay").dialog({
                    title:text+'权限详情',
                    width:300,
                    height:200,
                    modal: true,
                    buttons:[{
                        text:'保存',
                        iconCls:'icon-save',
                        handler:function(){
                            $("#formIdWay").form('submit',{
                                url:"${ctx}/way/addWay",
                                success:function(pm){
                                    $.messager.alert("提示","新增成功");
                                    $("#formIdWay").form("reset");
                                    $("#openWay").dialog("close");
                                    selectWay($("#treeId").val());
                                }
                            })
                        }
                    },{
                        text:'取消',
                        iconCls:'icon-cancel',
                        handler:function(){
                            $("#ids").val("");
                            $("#formIdWay").form('reset');
                            $("#openWay").dialog("close");
                        }
                    }],
                    onClose:function(){
                        $("#ids").val("");
                        $("#formIdWay").form('reset');
                    }
                })
            }
            //删除权限路径
            function removeWay(val){
                $.messager.confirm('提示','你确定删除这条记录吗?',function(r){
                    if(r){
                        $.ajax({
                            url: '<%=path%>/way/deleteWay',
                            type: 'post',
                            data: {id:val},
                            success: function(pm){
                                $.messager.alert('提示','删除成功');
                                return selectWay($("#treeId").val());
                            },
                            error:function(){
                                $.messager.alert("提示","后台出错,请联系后台管理人员");
                            }
                        })
                    }
                });
            }
        </script>
    </div>
</body>
</html>
