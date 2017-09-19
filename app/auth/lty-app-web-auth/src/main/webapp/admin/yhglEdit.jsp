<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
	$(function() {
		$('#admin_yhglEdit_combogrid').combogrid({
			multiple : true,
			nowrap : false,
			url : '${pageContext.request.contextPath}/role/combogrid.shtml',
			panelWidth : 450,
			panelHeight : 200,
			method:'GET',
			idField : 'id',
			textField : 'name',
			pagination : true,
			fitColumns : true,
			editable : true,
			rownumbers : true,
			mode : 'remote',
			delay : 500,
			pageSize : 100,
			pageList : [ 100 ],
			columns : [ [ {
				field : 'id',
				title : '编号',
				width : 150,
				hidden : true
			}, {
				field : 'name',
				title : '角色名称',
				width : 150
			}, {
				title : '可访问资源ID',
				field : 'resourceIds',
				width : 300,
				hidden : true
			}, {
				title : '可访问资源',
				field : 'resources',
				width : 300,
				formatter : function(value, row, index) {
					var resourceNames = "";
					if (value && value.length > 0) {
						for (var i = 0; i < value.length; i++) {
							resourceNames += value[i].text+",";
						}
						
						resourceNames = resourceNames.toString().substring(0,resourceNames.length-1)
					}
					return resourceNames;

				}
			} ] ]
		});
	});
</script>
<div align="center">
	<form id="admin_yhglEdit_editForm" method="post">
		<table class="tableForm">
			<tr>
				<th style="width: 100px;">编号</th>
				<td><input name="id" readonly="readonly" />
				</td>
				<th style="width: 80px;">登录名称</th>
				<td><input name="loginName" class="easyui-validatebox" data-options="required:true" />
				</td>
			</tr>
			<tr>
				
				<th>所属角色</th>
				<td><input id="admin_yhglEdit_combogrid" name="roleIds" style="width: 155px;" />
				</td>
			</tr>
		</table>
	</form>
</div>