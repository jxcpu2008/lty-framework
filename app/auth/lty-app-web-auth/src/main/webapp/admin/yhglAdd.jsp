<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/enum.js" charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
		// easyui的消息框
// 		$.messager.alert('新增用户', 'aaaaaaaaaaaaaaaaaaaaaaaaaa!');
		
		// 从后台获取枚举类型数据
// 		$("#userType").combobox(
// 			{
// 				url 		: '${pageContext.request.contextPath}/user/types.shtml',
// 				method 		: 'GET',
// 				limitToList : true,
// 				panelHeight : "auto",
// 				success		: function(data) {
					
//                 	var optionData = [];  
//                     for (var i = 0; i < data.length; i++) {  
//                     	optionData.push({"desc" : data[i].desc, "value" : data[i].value});
//                     }  
//                  }
// 			}
// 		);

		// 从本地js文件加载枚举类型数据
		$("#userType").combobox(
			{
				limitToList : true,
				panelHeight : "auto",
				data : userType
			}
		);
	});

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
				<td><input name="loginName" class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
			<tr>
				<th style="width: 100px;">密码</th>
				<td>
					<input id="pwd" type="password" class="easyui-validatebox" data-options="required:true" style="width:143px;" />
				</td>
				<th style="width: 80px;">用户类型</th>
				<td>
					<input id="userType" class="easyui-combobox" name="type" style="width:150px;"
						data-options="editable:false, valueField:'value', textField:'desc'" />
				</td>
			</tr>
			<tr>
				<th style="width: 100px;">生日</th>
				<td>
					<input name="birthday" onFocus="WdatePicker({readOnly:true, dateFmt:'yyyy-MM-dd'})"/>
				</td>
			</tr>
		</table>
	</form>
</div>