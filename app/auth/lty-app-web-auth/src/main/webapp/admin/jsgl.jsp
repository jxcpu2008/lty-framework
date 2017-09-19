<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
	$(function() {
		$('#admin_jsgl_datagrid').datagrid({
			url : '${pageContext.request.contextPath}/role/findRoleResources.shtml',
			fit : true,
			method: 'GET',
			fitColumns : true,
			border : false,
			pagination : true,
			idField : 'id',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'name',
			sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : false,
			frozenColumns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				sortable : true,
				checkbox : true
			}, {
				title : '角色名称',
				field : 'name',
				width : 150,
				sortable : true
			} ] ],
			columns : [ [ {
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
			}, {
				field : 'action',
				title : '动作',
				width : 100,
				formatter : function(value, row, index) {
					if (row.id == '0') {
						return '系统角色';
					} else {
						return formatString('<img onclick="admin_jsgl_editFun(\'{0}\');" src="{1}"/>&nbsp;<img onclick="admin_jsgl_deleteFun(\'{2}\');" src="{3}"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/cancel.png');
					}
				}
			} ] ],
			toolbar : [ {
				text : '增加角色',
				iconCls : 'icon-add',
				handler : function() {
					admin_jsgl_appendFun();
				}
			}, '-', {
				text : '批量删除',
				iconCls : 'icon-remove',
				handler : function() {
					admin_jsgl_removeFun();
				}
			}, '-' , {
				text : '菜单授权',
				iconCls : 'icon-edit',
				handler : function() {
					admin_jsglcd_editFun()
				}
			}, '-'],
			onRowContextMenu : function(e, rowIndex, rowData) {
				e.preventDefault();
				$(this).datagrid('unselectAll');
				$(this).datagrid('selectRow', rowIndex);
				$('#admin_yhgl_menu').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			}
		});
	});

	function admin_jsglcd_editFun() {
		var rows = $('#admin_jsgl_datagrid').datagrid('getChecked');
		if (rows.length > 0) {
			var p = parent.lw.dialog({
				href : '${pageContext.request.contextPath}/admin/jsglcdEdit.jsp',
				width : 520,
				height : 200,
				modal : true,
				title : '菜单授权',
				buttons : [ {
					text : '保存',
					iconCls : 'icon-edit',
					handler : function() {
						var d = $(this).closest('.window-body');
						$('#admin_jsglcdEdit_editForm').form('submit', {
							url : '${pageContext.request.contextPath}/role/editMenu.shtml',
							success : function(result) {
								try {
									var r = $.parseJSON(result);
									if (r.success) {
										d.dialog('destroy');
										$('#admin_jsgl_datagrid').datagrid('reload');
									}
									$.messager.show({
										title : '提示',
										msg : r.msg
									});
									p.dialog('close');
								} catch (e) {
									$.messager.alert('提示异常', result);
								}
							}
						});
					}
				} ],
				onClose : function() {
					$(this).dialog('destroy');
				},
				onLoad : function() {
					var o = rows[0];
					o.menuIds="";
					$.ajax({ 
				        type: "get", 
				        url: "${pageContext.request.contextPath}/role/getMenuIdsByPrimaryKey.shtml", 
				        data:{roleId:o.id},
				        cache:false, 
				        async:false, 
				        success: function(result){ 
				        	var r = $.parseJSON(result);
				        	if (r.success) {
				        		o.menuIds=r.obj;
				        	}
				        } 
				    });
					$('#admin_jsglcdEdit_editForm').form('load', o);
				}
			});
		}else{
			$.messager.show({
				title : '提示',
				msg : '请勾选要编辑的记录！'
			});
		}
		
	}
	function admin_jsgl_editFun(id) {
		$('#admin_jsgl_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		var p = parent.lw.dialog({
			href : '${pageContext.request.contextPath}/admin/jsglEdit.jsp',
			width : 520,
			height : 200,
			modal : true,
			title : '编辑角色',
			buttons : [ {
				text : '编辑',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#admin_jsglEdit_editForm').form('submit', {
						url : '${pageContext.request.contextPath}/role/edit.shtml',
						success : function(result) {
							try {
								var r = $.parseJSON(result);
								if (r.success) {
									d.dialog('destroy');
									$('#admin_jsgl_datagrid').datagrid('reload');
								}
								$.messager.show({
									title : '提示',
									msg : r.msg
								});
								p.dialog('close');
							} catch (e) {
								$.messager.alert('提示异常', result);
							}
						}
					});
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			},
			onLoad : function() {
				var index = $('#admin_jsgl_datagrid').datagrid('getRowIndex', id);
				var rows = $('#admin_jsgl_datagrid').datagrid('getRows');
				var o = rows[index];
				/*o.resourceIds = stringToList(rows[index].resourceIds); */
				var value = rows[index].resources;
				if (value && value.length > 0) {
					var ids="";
					for (var i = 0; i < value.length; i++) {
						ids += value[i].id+",";
					}
					
					ids = ids.toString().substring(0,ids.length-1)
				}
				o.resourceIds=ids;
				$('#admin_jsglEdit_editForm').form('load', o);
			}
		});
	}
	function admin_jsgl_appendFun() {
		$('#admin_jsgl_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		var p  = parent.lw.dialog({
			href : '${pageContext.request.contextPath}/admin/jsglAdd.jsp',
			width : 520,
			height : 200,
			modal : true,
			title : '添加角色',
			buttons : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#admin_jsglAdd_addForm').form('submit', {
						url : '${pageContext.request.contextPath}/role/add.shtml',
						success : function(result) {
							try {
								var r = $.parseJSON(result);
								if (r.success) {
									
									$('#admin_jsgl_datagrid').datagrid('insertRow', {
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
								$.messager.alert('提示异常', result);
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
	function admin_jsgl_removeFun() {
		var rows = $('#admin_jsgl_datagrid').datagrid('getChecked');
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
				if (r) {
					$.ajax({
						url : '${pageContext.request.contextPath}/role/deleteByPrimaryKey.shtml',
						data : {
							id : rows[0].id
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								$('#admin_jsgl_datagrid').datagrid('load');
								$('#admin_jsgl_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							}
							$.messager.show({
								title : '提示',
								msg : result.msg
							});
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
	function admin_jsgl_deleteFun(id) {
		$('#admin_jsgl_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('#admin_jsgl_datagrid').datagrid('checkRow', $('#admin_jsgl_datagrid').datagrid('getRowIndex', id));
		admin_jsgl_removeFun();
	}
</script>
<table id="admin_jsgl_datagrid"></table>