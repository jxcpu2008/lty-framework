<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
	$("#pwd").on('input', function(e) {
		$("input[name=password]").val(hex_sha1($("#pwd").val()));
	});
</script>
<div align="center">
	<form id="admin_yhglAdd_addForm" method="post">
		<input name="password" type="password" hidden=true />
		<table class="tableForm">
			<tr>
				<th style="width: 100px;">编号</th>
				<td><input name="id" readonly="readonly" /></td>
				<th style="width: 80px;">登录名称</th>
				<td><input name="loginName" class="easyui-validatebox"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input id="pwd" type="password" class="easyui-validatebox"
					data-options="required:true" style="width: 150px;" /></td>

			</tr>
		</table>
	</form>
</div>