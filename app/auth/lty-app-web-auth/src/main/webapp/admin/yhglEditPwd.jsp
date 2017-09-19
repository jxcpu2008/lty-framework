<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div align="center">
	<form id="admin_yhglEditPwd_editForm" method="post">
		<table class="tableForm">
			<tr>
				<th>登录用户</th>
				<td><input name="loginName" readonly="readonly" /></td>
			</tr>
			<tr>
				<th>新密码</th>
				<td><input type="password" name="pwd" class="easyui-validatebox" data-options="required:true" style="width: 150px;" />
				</td>
			</tr>
		</table>
	</form>
</div>