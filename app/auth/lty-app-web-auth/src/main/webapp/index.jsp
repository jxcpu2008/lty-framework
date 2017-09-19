<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML >
<html>
<head>
<title>深圳市李天一科技股份有限公司</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="">
<meta http-equiv="description" content="数据平台">
<jsp:include page="inc.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		$('#demo_index_layout').layout('collapse', 'west');
	});
</script>
</head>
<body id="demo_index_layout" class="easyui-layout">
	<div
		data-options="region:'north',href:'${pageContext.request.contextPath}/layout/north.jsp'"
		style="height: 60px;overflow: hidden;" class="logo"></div>
	<div
		data-options="region:'west',title:'功能导航',href:'${pageContext.request.contextPath}/layout/west.jsp'"
		style="width: 200px;overflow: hidden;"></div>
	<div
		data-options="region:'center',title:'',href:'${pageContext.request.contextPath}/layout/center.jsp'"
		style="overflow: hidden;"></div>

	<div
		data-options="region:'south',href:'${pageContext.request.contextPath}/layout/south.jsp'"
		style="height: 27px;overflow: hidden;"></div>

</body>
</html>