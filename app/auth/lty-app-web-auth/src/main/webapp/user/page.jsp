<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
function admin_yhgl_searchFun() {
	alert("begin to query!");
}
</script>
<div class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'north',title:'查询条件',border:false" style="height: 165px;overflow: hidden;" align="center">
		<form id="admin_yhgl_searchForm">
			<table class="tableForm">
				<tr>
					<th style="width: 170px;">检索用户名称(可模糊查询)</th>
					<td><input name="name" style="width: 315px;" /></td>
				</tr>
			</table>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="admin_yhgl_searchFun();">过滤条件</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="admin_yhgl_cleanFun();">清空条件</a>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table id="admin_yhgl_datagrid">
			<thead>
				<tr>
					<th>登录名称</th>
					<th>账户信息</th>
					<th>类型</th>
					<th>状态</th>
					<th>创建时间</th>
<!-- 					<th>所属角色名称</th> -->
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${page.rows}">
					<tr>
						<td>${user.loginName}</td>
						<td>Jerry.Wong</td>
						<td>${user.type}</td>
						<td>${user.status}</td>
						<td>${user.createtime}</td>
<%-- 						<td>${user.loginName}</td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>