<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/12
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
</head>
<body>
    <table id="sitesUserList"></table>
    <script>
        $(function(){
            sitesUserList();
        })
        //查询网站用户信息
        function sitesUserList(){
            $("#sitesUserList").datagrid({
                url:'${ctx}/sitesUser/queryRecycleSitesUser',
                fit:true,
                fitColumns:true,
                striped:true,
                loadMsg:'当前网络不好！请稍等......',
                pagination:true,
                pagePosition:'bottom',
                pageNumber:1,
                pageSize:3,
                pageList:[3,6,15,21,42],
                toolbar:"#searchSitesUser",
                columns:[[
                    {field:'id',title:'编号',align:'center',checkbox:true},
                    {field:'sitesName',title:'账号',align:'center'},
                    {field:'password',title:'密码',align:'center'},
                    {field:'sitesUserName',title:'用户名称',align:'center'},
                    {field:'sitesPhone',title:'手机号',align:'center'},
                    {field:'state',title:'状态',align:'center',
                        formatter: function(value,row,index){
                            return "已被删除";
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
    </script>
</body>
</html>
