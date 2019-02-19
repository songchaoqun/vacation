<%--<%@ page language="java" contentType="text/html; charset=UTF-8" %>--%>
<%@ include file="/WEB-INF/view/common/tags.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/WEB-INF/view/common/metas.jsp" %>
	<!-- 引入EasyUI的样式文件-->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/easyui/themes/default/easyui.css" type="text/css"/>
	<!-- 引入EasyUI的图标样式文件-->
	<link rel="stylesheet"href="<%=request.getContextPath() %>/easyui/themes/icon.css" type="text/css"/>
	<!-- 引入JQuery -->
	<script type="text/javascript" src="<%=request.getContextPath() %>/easyui/jquery.min.js"></script>
	<!-- 引入EasyUI -->
	<script type="text/javascript" src="<%=request.getContextPath() %>/easyui/jquery.easyui.min.js"></script>
	<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
	<script type="text/javascript" src="<%=request.getContextPath() %>/easyui/locale/easyui-lang-zh_CN.js"></script>
	<!-- 引入EasyUI的生成树的插件 -->
	<script type="text/javascript" src="<%=request.getContextPath() %>/easyui/util-js.js"></script>
	<!-- 引入Masonry Layouts也就是瀑布流 布局 -->
	<%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/masonry.pkgd.js"></script>--%>
	<!-- uploadify上传文件插件 -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/js/uploadify/uploadify.css" type="text/css">
	<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath() %>/js/uploadify/jquery.uploadify.min.js"></script>
	<!-- ueditor副文本编辑器 -->
<%--	<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath() %>/js/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath() %>/js/ueditor/ueditor.all.js"></script>--%>
	<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
	<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<%--
	<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath() %>/js/ueditor/lang/zh-cn/zh-cn.js"></script>
--%>
</head>
<body>

</body>
</html>