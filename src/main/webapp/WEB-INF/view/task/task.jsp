<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<%@ include file="/WEB-INF/view/common/base.jsp" %>
</head>
<body>
	<!-- 条件查询 -->
	<div id="searchDiv">
		创建时间：<input class="easyui-datebox" id="sdate">--
		<input class="easyui-datebox" id="edate">
		<a href="javascript:searchUSer()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
		<br>
		 <a href="javascript:deletes()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
		<a href="javascript:openDig()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">创建任务</a>
	</div>
	<!-- 定义表格 -->
	<table id="myTable">
	</table> 
	<!-- 定义弹框、对话框 -->
	<div id="myDialog" class="easyui-dialog" style="width:300px;height:300px" data-options="modal:true,collapsible:true,minimizable:true,maximizable:true,resizable:true,buttons:'#myButton',closed:true,iconCls:'icon-save'">
		<form id="myForm" method="post">
		  <input style="display:none" name="id">
		  <table>
		  <tr>
			<td>任务名称</td>
			<td>
				<input class="easyui-textbox" name="task_name">
			</td>
		  </tr>

		   <tr>
			<td>执行人</td>
			<td>
				<input class="easyui-combobox" name="fin_id" id="roleId" >
			</td>
		  </tr>

		  </table>			
		</form>
	</div>
	<!-- 定义按钮 -->
	<div id="myButton">
		<a href="javascript:addUser()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">保存</a>
		<a href="javascript:closeDig()" class="easyui-linkbutton"  data-options="iconCls:'icon-cancel'">关闭</a>
	</div>
</body>
<script type="text/javascript">
    function updateById(id){
    	$.messager.confirm("提示","是否确认完成",function(r){
    		$.ajax({
    			    url:"${ctx}/task/updateStatus?id="+id,
    			    success:function(){
    			    	searchUSer();
    			    }		
    		})
    		
    	})
    }



	//初始角色
		
	function initRole(){
		$("#roleId").combobox({
			url:"${ctx}/task/queryTaff",
			valueField:"id",
			textField:"staffName",
			multiple:true
		})
	}


	//关闭按钮
	function closeDig(){
		$("#myDialog").dialog('close');
	}
	//新增、修改用户
	function addUser(){

		
		$("#myForm").form("submit",{
			url:"${ctx}/task/addTask",
			/*onSubmit:function(){
				//var pwd = $("#pwd").passwordbox("getValue");
				//var pwd2 = $("#pwd2").passwordbox("getValue");
				if(pwd!=pwd2){
					$.messager.alert("提示","密码不一致","info");
					return false;
				}
				return true;
			},*/
			success:function(){
				$.messager.alert("提示","保存成功！","info");
				//关闭弹框
				$("#myDialog").dialog('close');		
				//刷新页面
				searchUSer();
			}
		})
	}
	//打开新增对话框
	function openDig(){
		//清除市的下拉列表的缓存

		//重置表单
		$("#myForm").form("clear");
		//打开弹框加载角色
		initRole();
		$("#myDialog").dialog({
			title:'新增用户',
			closed:false   //true 关闭 false 打开
		})
	}
	//批量删除
	function deletes(){
		//获取所有选中的复选框
		var arr = $("#myTable").datagrid("getChecked");		
		if(arr.length<=0){
			$.messager.alert("提示消息","请至少选择一条数据！","warning");
			return;
		}
		$.messager.confirm("提示","是否确认删除"+arr.length+"条数据？",function(r){
			if(r){
					var ids = "";
					for(var i=0;i<arr.length;i++){
						//alert(arr[i].id);
						if(ids==""){
							ids += arr[i].id;
						}else{
							ids += ","+arr[i].id;
						}
					}
					$.ajax({
						url:"<%=request.getContextPath() %>/user/deleteAll.do",
						type:"post",
						data:{"ids":ids},
						success:function(){
							//alert("删除成功");
							$.messager.alert("提示消息","成功删除"+arr.length+"条数据！","info");
							//刷新页面
							searchUSer();
						},error:function(){
							//alert("删除失败");
							$.messager.alert("提示消息","删除失败！","error");
						}
					})
			}
		})
	}
	//条件查询
	function searchUSer(){
		$("#myTable").datagrid("load",{
			sdate:$("#sdate").datebox("getValue"),
			edate:$("#edate").datebox("getValue")
		})
	}

	//alert(1)
	$("#myTable").datagrid({
		url:"${ctx}/task/queryTask",
		columns:[[//{field:'check',checkbox:true},//显示复选框   field：字段必须唯一，不能重复
		          {field:'id',title:'ID'},
		          {field:'task_name',title:'任务名称'},
		          {field:'cre_name',title:'创建人'},
                  {field:'fin_name',title:'执行人'},
		          {field:'status',title:'状态',formatter:function(value,row,index){
		        	if(value==0){
		        		return"未完成";
		        	}else if(value==1){
		        		return"完成";
		        	}
		          }},
		          {field:'cre_time',title:'创建时间'},
		          {field:'tools',title:'操作',width:100,align:'center',formatter:function(value,row,index){
		        	 
		        	  var str = "<a href='javascript:updateById("+row.id+")'>完成</a>";
                      str += "|<a href='javascript:deleteUser("+row.id+")'>删除</a>";

		        	  return str;
		          }}]],
		 pagination:true,//开启分页
		 pageList:[1,2,3,4], //初始化页面大小选择列表
		 pageSize:2 , //初始化每页显示条数，默认是10
		 pageNumber:1, //当前页,默认是1
		// fit:true,
		 //pagePosition:"both",
		 loadMsg:"正在努力加载中。。。", //请求后台的提示信息
		 rownumbers:true,		   //显示行号
		 //singleSelect:true,      //只能单选
		 toolbar: "#searchDiv"     //添加工具栏 ： div的id
		
	})
	
	//单个删除
	function deleteUser(id){
		//alert(id);
		$.messager.confirm("提示","是否确认删除！",function(r){
			if(r){
				$.ajax({
					url:"${ctx}/task/delTask",
					type:"post",
					data:{"ids":id},
					success:function(){
						//alert("删除成功");
						$.messager.alert("提示消息","删除成功！","info");
						//刷新页面
						searchUSer();
					},error:function(){
						//alert("删除失败");
						$.messager.alert("提示消息","删除失败！","error");
					}
				})				
			}
		})		
	}

</script>	
</html>