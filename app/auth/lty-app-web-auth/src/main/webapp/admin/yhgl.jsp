<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/syUtil.js" charset="utf-8"></script>
<script type="text/javascript">
	var map = new Map();  
	map['loginName'] = 'login_name';

	$(function() {
		$('#admin_yhgl_datagrid')
				.datagrid(
						{
							url : '${pageContext.request.contextPath}/user/findUserAndRolesByPage.shtml',
							method : 'GET',
							fit : true,
							fitColumns : true,
							border : false,
							pagination : true,
							idField : 'id',
							pageSize : 10,
							pageList : [ 10, 20, 30, 40, 50 ],
							sortName : 'login_name',
							sortOrder : 'asc',
							checkOnSelect : false,
							selectOnCheck : false,
							frozenColumns : [ [ {
								field : 'id',
								title : '编号',
								width : 150,
								checkbox : true
							}, {
								field : 'loginName',
								title : '登录名称',
								align : 'center',
								width : 120,
								sortable : true
							} ] ],
							columns : [ [
									{
										field : 'realName',
										title : '账户信息',
										align : 'center',
										width : 60,
										formatter : function(value, row, index) {
											return 'jerry';
										}
									},
									{
										field : 'type',
										title : '类型',
										align : 'center',
										width : 150,
										sortable : false
									},
									{
										field : 'status',
										title : '状态',
										align : 'center',
										width : 150,
										sortable : false
									},
									{
										field : 'createTime',
										title : '创建时间',
										width : 150,
										align : 'center',
										formatter : function(value) {
											if (value == null || value == '') {  
										        return '';  
										    }  
										    var dt;  
										    if (value instanceof Date) {  
										        dt = value;  
										    } else {  
										        dt = new Date(value);  
										    }  
										  
										    return dt.format("yyyy-MM-dd hh:mm:ss");
										}
									},
									{
										field : 'userNo',
										title : '用户号',
										width : 150,
										align : 'center',
										sortable : false
									},
									{
										field : 'roles',
										title : '所属角色名称',
										align : 'center',
										width : 150,
										formatter : function(value, row, index) {
											var rolenames = '';
											if (value && value.length > 0) {
												for (var i = 0; i < value.length; i++) {
													rolenames += value[i].name
															+ ",";
												}

												rolenames = rolenames
														.toString()
														.substring(
																0,
																rolenames.length - 1)
											}
											return rolenames;

										}
									},
									{
										field : 'action',
										title : '动作',
										width : 100,
										formatter : function(value, row, index) {
											if (row.id == '0') {
												return '系统用户';
											} else {
												return formatString(
														'<img onclick="admin_yhgl_editFun(\'{0}\');" src="{1}"/>&nbsp;<img onclick="admin_yhgl_deleteFun(\'{2}\');" src="{3}"/>&nbsp;<img onclick="admin_yhgl_modifyPwdFun(\'{4}\');" src="{5}"/>',
														row.id,
														'${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png',
														row.id,
														'${pageContext.request.contextPath}/style/images/extjs_icons/cancel.png',
														row.id,
														'${pageContext.request.contextPath}/style/images/extjs_icons/lock/lock_edit.png');
											}
										}
									} ] ],
							onBeforeLoad : function(param) {
						        onSortColumn(param, map);  
						    },
							onRowContextMenu : function(e, rowIndex, rowData) {
								e.preventDefault();
								$(this).datagrid('unselectAll');
								$(this).datagrid('selectRow', rowIndex);
								$('#admin_yhgl_menu').menu('show', {
									left : e.pageX,
									top : e.pageY
								});
							},
							toolbar : [ {
								text : '增加',
								iconCls : 'icon-add',
								handler : function() {
									admin_yhgl_appendFun();
								}
							}, '-', {
								text : '批量删除',
								iconCls : 'icon-remove',
								handler : function() {
									admin_yhgl_removeFun();
								}
							}, '-', {
								text : '批量设置角色',
								iconCls : 'icon-edit',
								handler : function() {
									admin_yhgl_modifyRoleFun();
								}
							}, '-' ]
						});

	});

	function onSortColumn(param, map) {
	    // 取出map中字段的映射关系值  
	    var fieldSort = map[param.sort];  
	    if (fieldSort != '' && fieldSort != undefined){  
	        // 设置新的排序字段名，设置完之后，发送请求时一并会发送到服务端  
	        param.sort = fieldSort;
	    }
	}
	
	function admin_yhgl_searchFun() {
		$('#admin_yhgl_datagrid').datagrid('load', serializeObject($('#admin_yhgl_searchForm')));
	}
	
	function admin_yhgl_cleanFun() {
		$('#admin_yhgl_searchForm input').val('');
		$('#admin_yhgl_datagrid').datagrid('load', {});
	}
	function admin_yhgl_editFun(id) {
		$('#admin_yhgl_datagrid').datagrid('uncheckAll')
				.datagrid('unselectAll').datagrid('clearSelections');
		var p = parent.lw
				.dialog({
					href : '${pageContext.request.contextPath}/admin/yhglEdit.jsp',
					width : 520,
					height : 200,
					modal : true,
					title : '编辑用户',
					buttons : [ {
						text : '编辑',
						iconCls : 'icon-edit',
						handler : function() {
							var d = $(this).closest('.window-body');
							$('#admin_yhglEdit_editForm')
									.form(
											'submit',
											{
												url : '${pageContext.request.contextPath}/user/edit.shtml',
												success : function(result) {
													try {
														var r = $
																.parseJSON(result);
														if (r.success) {
															$('#admin_yhgl_datagrid').datagrid('reload');
															d.dialog('destroy');
														}
														$.messager.show({
															title : '提示',
															msg : r.msg
														});
														p.dialog('close');
													} catch (e) {

														$.messager.alert(
																'提示异常', e);
													}
												}
											});
						}
					} ],
					onClose : function() {
						$(this).dialog('destroy');
					},
					onLoad : function() {
						var index = $('#admin_yhgl_datagrid').datagrid(
								'getRowIndex', id);
						var rows = $('#admin_yhgl_datagrid')
								.datagrid('getRows');
						var o = rows[index];
						var value = rows[index].roles;
						var ids = "";
						if (value && value.length > 0) {

							for (var i = 0; i < value.length; i++) {
								ids += value[i].id + ",";
							}

							ids = ids.toString().substring(0, ids.length - 1)
						}
						o.roleIds = ids;
						$('#admin_yhglEdit_editForm').form('load', o);
					}
				});
	}
	function admin_yhgl_ceshi() {
		$('#admin_yhgl_datagrid').datagrid('uncheckAll')
				.datagrid('unselectAll').datagrid('clearSelections');
		parent.lw.dialog({
			href : '${pageContext.request.contextPath}/upload/index.jsp',
			width : 620,
			height : 500,
			modal : true,
			title : '上传图片',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-edit',
				handler : function() {

				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			},
			onLoad : function() {

			}
		});
	}
	function admin_yhgl_appendFun() {
		$('#admin_yhgl_datagrid').datagrid('uncheckAll')
				.datagrid('unselectAll').datagrid('clearSelections');
		var p = parent.lw
				.dialog({
					href : '${pageContext.request.contextPath}/admin/yhglAdd.jsp',
					width : 520,
					height : 200,
					modal : true,
					title : '添加用户',
					buttons : [ {
						text : '增加',
						iconCls : 'icon-add',
						handler : function() {
							var d = $(this).closest('.window-body');
							$('#admin_yhglAdd_addForm')
									.form(
											'submit',
											{
												url : '${pageContext.request.contextPath}/user/insertSelective.shtml',
												success : function(result) {
													try {
														var r = $
																.parseJSON(result);
														if (r.success) {
															$(
																	'#admin_yhgl_datagrid')
																	.datagrid(
																			'insertRow',
																			{
																				index : 0,
																				row : r.obj
																			});
															d.dialog('destroy');
														}
														$.messager.show({
															title : '提示',
															msg : r.msg
														});
														p.dialog('close');
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
					}
				});
	}
	function admin_yhgl_removeFun() {
		var rows = $('#admin_yhgl_datagrid').datagrid('getChecked');
		if (rows.length > 0) {
			$.messager
					.confirm(
							'确认',
							'您是否要删除当前选中的项目？',
							function(r) {
								if (r) {
									var currentUserId = '${sessionInfo.userId}';/*当前登录用户的ID*/
									var flag = false;

									$
											.ajax({
												url : '${pageContext.request.contextPath}/user/deleteByPrimaryKey.shtml',
												data : {
													id : rows[0].id
												},
												dataType : 'json',
												success : function(result) {
													if (result.success) {
														$(
																'#admin_yhgl_datagrid')
																.datagrid(
																		'load');
														$(
																'#admin_yhgl_datagrid')
																.datagrid(
																		'uncheckAll')
																.datagrid(
																		'unselectAll')
																.datagrid(
																		'clearSelections');
													}
													if (flag) {
														$.messager.show({
															title : '提示',
															msg : '不可以删除自己！'
														});
													} else {
														$.messager.show({
															title : '提示',
															msg : result.msg
														});
													}
												}
											});
								}
							});
		} else {
			$.messager.show({
				title : '提示',
				msg : '请勾选要删除的记录！'
			});
		}
	}
	function admin_yhgl_deleteFun(id) {
		$('#admin_yhgl_datagrid').datagrid('uncheckAll')
				.datagrid('unselectAll').datagrid('clearSelections');
		$('#admin_yhgl_datagrid').datagrid('checkRow',
				$('#admin_yhgl_datagrid').datagrid('getRowIndex', id));
		admin_yhgl_removeFun();
	}
	function admin_yhgl_modifyPwdFun(id) {
		var p = parent.lw
				.dialog({
					href : '${pageContext.request.contextPath}/admin/yhglEditPwd.jsp',
					width : 300,
					height : 200,
					modal : true,
					title : '编辑用户密码',
					buttons : [ {
						text : '编辑',
						iconCls : 'icon-edit',
						handler : function() {
							var d = $(this).closest('.window-body');
							$('#admin_yhglEditPwd_editForm')
									.form(
											'submit',
											{
												url : '${pageContext.request.contextPath}/user/modifyPwd.shtml',
												success : function(result) {
													try {
														var r = $
																.parseJSON(result);
														if (r.success) {
															d.dialog('destroy');
															$('#admin_yhgl_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid(
																			'clearSelections');
															$('#admin_yhgl_datagrid').datagrid('reload');
														}
														$.messager.show({
															title : '提示',
															msg : r.msg
														});
														p.dialog('close');
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
						$('#admin_yhglEditPwd_editForm').form('load', {
							loginName : loginName
						});
					}
				});
	}
	function admin_yhgl_modifyRoleFun() {
		var rows = $('#admin_yhgl_datagrid').datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			for (var i = 0; i < rows.length; i++) {
				ids.push(rows[i].id);
			}
			var p = parent.lw
					.dialog({
						href : '${pageContext.request.contextPath}/admin/yhglEditRole.jsp',
						width : 300,
						height : 200,
						modal : true,
						title : '批量编辑用户角色',
						buttons : [ {
							text : '编辑',
							iconCls : 'icon-edit',
							handler : function() {
								var d = $(this).closest('.window-body');
								$('#admin_yhglEditRole_editForm')
										.form(
												'submit',
												{
													url : '${pageContext.request.contextPath}/userController/modifyRole.action',
													success : function(result) {
														try {
															var r = $
																	.parseJSON(result);
															if (r.success) {
																$('#admin_yhgl_datagrid').datagrid('reload');
																$('#admin_yhgl_datagrid').datagrid(
																				'uncheckAll')
																		.datagrid(
																				'unselectAll')
																		.datagrid(
																				'clearSelections');
																d
																		.dialog('destroy');
															}
															$.messager.show({
																title : '提示',
																msg : r.msg
															});
															p.dialog('close');
														} catch (e) {
															$.messager.alert(
																	'提示',
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
							$('#admin_yhglEditRole_editForm').form('load', {
								ids : ids
							});
						}
					});
		} else {
			$.messager.show({
				title : '提示',
				msg : '请勾选要编辑的记录！'
			});
		}
	}
</script>
<div class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'north',title:'查询条件',border:false"
		style="height: 165px;overflow: hidden;" align="center">
		<form id="admin_yhgl_searchForm">
			<table class="tableForm">
				<tr>
					<th style="width: 170px;">登录名称(可模糊查询)</th>
					<td><input name="loginName" style="width: 315px;" /></td>
				</tr>
				<tr>
					<th>创建时间</th>
					<td>
						<input name="createTimeStart" onFocus="WdatePicker({readOnly:true, dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>至
						<input name="createTimeEnd" onFocus="WdatePicker({readOnly:true, dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
					</td>
				</tr>
<!-- 				<tr> -->
<!-- 					<th>最后修改时间</th> -->
<!-- 					<td><input name="modifydatetimeStart" -->
<!-- 						onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" />至<input -->
<!-- 						name="modifydatetimeEnd" -->
<!-- 						onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" /></td> -->
<!-- 				</tr> -->
			</table>
			<a href="javascript:void(0);" class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true"
				onclick="admin_yhgl_searchFun();">过滤条件</a> <a
				href="javascript:void(0);" class="easyui-linkbutton"
				data-options="iconCls:'icon-cancel',plain:true"
				onclick="admin_yhgl_cleanFun();">清空条件</a>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table id="admin_yhgl_datagrid"></table>
	</div>
</div>

<div id="admin_yhgl_menu" class="easyui-menu" style="width:120px;display: none;">
	<div onclick="admin_yhgl_appendFun();" data-options="iconCls:'icon-add'">增加</div>
	<div onclick="admin_yhgl_deleteFun();" data-options="iconCls:'icon-remove'">删除</div>
	<div onclick="admin_yhgl_editFun();" data-options="iconCls:'icon-edit'">编辑</div>
	<div onclick="admin_yhgl_ceshi();" data-options="iconCls:'icon-edit'">测试</div>
</div>