<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/11
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/view/common/base.jsp" %>
</head>
<body>
    <div id="searchCourse">
        <table>
            <tr>
                <td>
                    <a href="javaScript:openDialogCourse('新增')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
                </td>
            </tr>
        </table>
    </div>
    <table id="CourseList"></table>
    <div id="openCourse">
        <form id="formId" method="post">
            <input type="hidden" name="id" id="id">
            <table>
                <tr>
                    <td>课程封面</td>
                    <td>
                        <input type="hidden" name="cover"/>
                        <input type="file" id="imgFileBTN" data-options="required:true"/>
                        <div id="showImgDiv"></div>
                        <div id="showBars"></div>
                    </td>
                </tr>
                <tr>
                    <td>课程类型</td>
                    <td>
                        <input name="mold" class="easyui-combobox" data-options="valueField:'id',textField:'name',url:'${ctx}/mold/queryMoldByList'">
                    </td>
                </tr>
                <tr>
                    <td>课程标题</td>
                    <td>
                        <input type="text" name="content" >
                    </td>
                </tr>
                <tr>
                    <td>类别</td>
                    <td>
                        <select name="category">
                            <option value="免费">免费</option>
                            <option value="会员">会员</option>
                        </select>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <script>
        $(function(){
            CourseList();
            uploadify();
        })
        //新增课程
        function openDialogCourse(text){
            $("#openCourse").dialog({
                title:text+'课程',
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
                            url:"${ctx}/course/addCourse",
                            success:function(pm){
                                $("#formId").form("reset");
                                $("#openCourse").dialog("close");
                                $.messager.alert("提示","新增成功");
                                CourseList();
                            }
                        })
                    }
                },{
                    text:'取消',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $("#formId").form("reset");
                        $("#openCourse").dialog("close");
                    }
                }],
                onClose:function(){
                    $("#formId").form("reset");
                }
            });
        }
        //查询课程
        function CourseList(){
            $("#CourseList").datagrid({
                url:'${ctx}/course/queryCourse',
                fit:true,
                fitColumns:true,
                striped:true,
                loadMsg:'当前网络不好！请稍等......',
                pagination:true,
                pagePosition:'bottom',
                pageNumber:1,
                pageSize:3,
                pageList:[3,6,15,21,42],
                toolbar:"#searchCourse",
                columns:[[
                    {field:'id',title:'编号',align:'center',checkbox:true},
                    {field:'cover',title:'课程封面',align:'center',
                        formatter: function(value,row,index){
                            return "<img src='${ctx}/testController/displayImg?img="+value+"' id='showImg' style='width: 150px;height: 200px;'>";
                        }
                    },
                    {field:'moldName',title:'课程类型',align:'center'},
                    {field:'content',title:'课程标题',align:'center'},
                    {field:'browse',title:'浏览数',align:'center'},
                    {field:'category',title:'类别',align:'center'},
                    {field:'tool',title:'操作',align:'center',
                        formatter: function(value,row,index){
                            var str = '<a href="javascript:removeCourse('+row.id+')">删除</a>' +
                            '<a href="javascript:updateCourse('+row.id+')">修改</a>';
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
        //修改课程
        function updateCourse(val){
            $.messager.confirm('提示','你确定修改这条记录吗?',function(r){
                if(r){
                    $.ajax({
                        url: '${ctx}/course/queryCourseById',
                        type: 'post',
                        data: {id:val},
                        success: function(pm){
                            $("#formId").form('load',pm);
                            var str = "<img src='${ctx}/testController/displayImg?img="+pm.cover+"' id='showImg' style='width: 150px;height: 200px;'>"
                            $("#showImgDiv").html(str);
                            $("#openCourse").dialog({
                                title:'修改课程',
                                width:600,
                                height:540,
                                closed:false,
                                //可以调整大小
                                resizable:true,
                                cache:false,
                                //背景添加阴影
                                modal:true,
                                buttons:[{
                                    text:'修改',
                                    iconCls:'icon-save',
                                    handler:function(){
                                        $("#formId").form('submit',{
                                            url:"${ctx}/course/updateCourse",
                                            success:function(pm){
                                                $("#formId").form("reset");
                                                $("#openCourse").dialog("close");
                                                $.messager.alert("提示","修改成功");
                                                CourseList();
                                            }
                                        })
                                    }
                                },{
                                    text:'取消',
                                    iconCls:'icon-cancel',
                                    handler:function(){
                                        $("#formId").form("reset");
                                        $("#openCourse").dialog("close");
                                    }
                                }],
                                onClose:function(){
                                    $("#formId").form("reset");
                                }
                            });
                        },
                        error:function(){
                            $.messager.alert("提示","修改失败,请联系后台管理人员");
                        }
                    })
                }
            });
        }
        //删除课程
        function removeCourse(val){
            $.messager.confirm('提示','你确定删除这条记录吗?',function(r){
                if(r){
                    $.ajax({
                        url: '${ctx}/course/deleteCourse',
                        type: 'post',
                        data: {id:val},
                        success: function(pm){
                            CourseList();
                        },
                        error:function(){
                            $.messager.alert("提示","删除失败,请联系后台管理人员");
                        }
                    })
                }
            });
        }
        //图片上传的方法
        function uploadify(){
            //文件域的id
            $("#imgFileBTN").uploadify({
                //前台请求后台的url 不可忽略的参数
                'uploader' :"<%=request.getContextPath()%>/testController/uploadImg",
                //插件自带 不可忽略的参数
                'swf' : '<%=request.getContextPath()%>/js/uploadify/uploadify.swf',
                //撤销按钮的图片路径
                'cancelImg' : '<%=request.getContextPath() %>/js/uploadify/uploadify-cancel.png',
                //如果为true 为自动上传 在文件后 为false 那么它就要我们自己手动点上传按钮
                'auto' : true,
                //可以同时选择多个文件 默认为true 不可忽略
                'multi' : false,
                //给上传按钮设置文字
                'buttonText' : '上传图片',
                //上传后队列是否消失
                'removeCompleted' : true,
                'removeTimeout' : 1,
                //上传文件的个数
                'uploadLimit' : 2,
                'fileTypeExts' : '*.jpg;*.jpge;*.gif;*.png',
                'fileSizeLimit' : '2MB',
                //给div的进度条加背景 不可忽略
                'queueID' : 'showBars',
                //controller层方法中接收文件的参数名, 参数名为自定义
                'fileObjName' : 'file',
                //上传成功后的回调函数
                'onUploadSuccess' : function(file, data, response) {
                    if(data!=null){
                        var str = "<img src='${ctx}/testController/displayImg?img="+data+"' id='showImg' style='width: 150px;height: 200px;'>"
                        $("#showImgDiv").html(str);
                        // $("#showImg").attr("src","D:/picture/"+data);
                    }
                    <%--$.ajax({--%>
                        <%--url: '${ctx}/testController/displayImg',--%>
                        <%--type: 'post',--%>
                        <%--data: {img:data},--%>
                        <%--success: function(pm){--%>
                            <%--alert(pm);--%>
                        <%--},--%>
                        <%--error:function(){--%>
                            <%--$.messager.alert("提示","ERROR");--%>
                        <%--}--%>
                    <%--})--%>
                    $("[name='cover']").val(data);
                }
            });
        }
    </script>
</body>
</html>
