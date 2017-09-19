<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div align="center">
	<form id="admin_jsglcdEdit_editForm" method="post">
		<table class="tableForm">
			<tr>
				<th>编号</th>
				<td><input name="id" readonly="readonly" /></td>
				<th>角色名称</th>
				<td><input name="name" class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
			<tr>
				<th>菜单授权</th>
				<td colspan="3"><input id="admin_jsglcdEdit_pid" name="menuIds" class="easyui-combotree" data-options="url:'${pageContext.request.contextPath}/menu/treegrid.shtml',method:'get',parentField : 'pid',lines : true,multiple:true" style="width: 370px;" /><img src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png" onclick="$('#admin_jsglcdEdit_pid').combotree('clear');" /></td>
			</tr>
		</table>
	</form>
</div>