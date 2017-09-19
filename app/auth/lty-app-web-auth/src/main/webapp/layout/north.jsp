<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" charset="utf-8">
	function logoutFun(b) {
		$.getJSON('${pageContext.request.contextPath}/login/logout.shtml',
				function(result) {
					location.replace(location.href);

				});
	}
	function userInfoFun() {
		parent.lw
				.dialog({
					href : '${pageContext.request.contextPath}/userController/userInfo.action',
					width : 490,
					height : 285,
					modal : true,
					title : '用户信息',
					buttons : [ {
						text : '修改密码',
						iconCls : 'icon-edit',
						handler : function() {
							var d = $(this).closest('.window-body');
							$('#user_userInfo_form')
									.form('submit',{url : '${pageContext.request.contextPath}/userController/modifyCurrentUserPwd.action',
												success : function(result) {
													try {
														var r = $
																.parseJSON(result);
														if (r.success) {
															d.dialog('destroy');
														}
														$.messager.show({
															title : '提示',
															msg : r.msg
														});
													} catch (e) {
														$.messager.alert('提示',
																result);
													}
												}
											});
						}
					} ],
					onClose : function() {
						$(this).dialog('destroy');
					},
					onLoad : function() {
					}
				});
	}

	/*客服管理）*/
	function openMenuKFGL() {
		parent.lw.node(
				"${pageContext.request.contextPath}/hande/orderMonth.jsp",
				"客服管理", "icon-add", true);
	}
	/*销售月报（标箱）*/
	function openMenuSend() {
		messagePush.send(1);
	}
</script>
<div id="sessionInfoDiv" style="position: absolute;right: 5px;top:10px;">

	<c:if test="${sessionInfo.userId != null}">[<strong>${sessionInfo.loginName}</strong>]，欢迎你！</c:if>
</div>
<div style="position: absolute; right: 0px; bottom: 0px; ">
	<a id="btn" href="#" class="easyui-linkbutton" onclick="openMenuKFGL()"
		data-options="iconCls:'icon-edit',plain:true">客服管理</a> <a id="btn"
		href="#" class="easyui-linkbutton" onclick="openMenuSend()"
		data-options="iconCls:'icon-add',plain:true">测试推送信息</a><a
		href="javascript:void(0);" class="easyui-menubutton"
		data-options="menu:'#layout_north_kzmbMenu',iconCls:'icon-save'">基础数据</a>
	<a href="javascript:void(0);" class="easyui-menubutton"
		data-options="menu:'#layout_north_zxMenu',iconCls:'icon-back'">注销</a>
</div>
<div id="layout_north_pfMenu" style="width: 120px; display: none;">
	<div onclick="changeTheme('default');">default</div>
	<div onclick="changeTheme('gray');">gray</div>
	<div onclick="changeTheme('metro');">metro</div>
</div>
<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
	<div onclick="userInfoFun();">个人信息</div>

	<div class="menu-sep"></div>
	<div>
		<span>更换主题</span>
		<div style="width: 120px;">
			<div onclick="changeTheme('ui-pepper-grinder');">pepper-grinder</div>
			<div onclick="changeTheme('metro-blue');">blue</div>
			<div onclick="changeTheme('metro-gray');">metro-gray</div>
			<div onclick="changeTheme('metro-green');">green</div>
			<div onclick="changeTheme('metro-arange');">arange</div>
			<div onclick="changeTheme('gray');">gray</div>
			<div onclick="changeTheme('metro');">metro</div>
			<div onclick="changeTheme('ui-sunny');">ui-sunny</div>
			<div onclick="changeTheme('ui-cupertino');">cupertino</div>
			<div onclick="changeTheme('ui-dark-hive');">dark-hive</div>
			<div onclick="changeTheme('default');">default</div>

		</div>
	</div>
</div>
<div id="layout_north_zxMenu" style="width: 100px; display: none;">
	<div onclick="logoutFun();">锁定窗口</div>
	<div class="menu-sep"></div>
	<div onclick="logoutFun();">重新登录</div>
	<div onclick="logoutFun(true);">退出系统</div>
</div>


