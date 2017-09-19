<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
	$(function() {
		$('#layout_west_tree').tree({
			url : '${pageContext.request.contextPath}/menu/findAllTreeNode.shtml',
			parentField : 'pid',
			method:'get',
			lines : false,
			onClick : function(node) {
				var url;
				if (node.attributes.url) {
					url = '${pageContext.request.contextPath}' + node.attributes.url;
				} else {
					url = '${pageContext.request.contextPath}/error/dog.jsp';
				}
				if (url.indexOf('druidController') > -1) {/*要查看连接池监控页面*/
					layout_center_addTabFun({
						title : node.text,
						closable : true,
						iconCls : node.iconCls,
						content : '<iframe src="' + url + '" frameborder="0" style="border:0;width:100%;height:99%;"></iframe>'
					});
				} else {
					
					// jsp视图
// 					if (node.id == 'yhgl') {
// 						url = '${pageContext.request.contextPath}' + '/user/list';
// 					}
					
					// json视图-easy ui
					layout_center_addTabFun({
						title : node.text,
						closable : true,
						iconCls : node.iconCls,
						href : url,
						tools : [ {
							iconCls : 'icon-mini-refresh',
							handler : function() {
								layout_center_refreshTab(node.text);
							}
						} ]
					});
				}
			}
		});
	}); 
</script>
<div class="easyui-accordion" data-options="fit:true,border:false">
	<div title="后台管理" data-options="isonCls:'icon-save',tools : [ {
				iconCls : 'icon-reload',
				handler : function() {
					$('#layout_west_tree').tree('reload');
				}
			}, {
				iconCls : 'icon-redo',
				handler : function() {
					var node = $('#layout_west_tree').tree('getSelected');
					if (node) {
						$('#layout_west_tree').tree('expandAll', node.target);
					} else {
						$('#layout_west_tree').tree('expandAll');
					}
				}
			}, {
				iconCls : 'icon-undo',
				handler : function() {
					var node = $('#layout_west_tree').tree('getSelected');
					if (node) {
						$('#layout_west_tree').tree('collapseAll', node.target);
					} else {
						$('#layout_west_tree').tree('collapseAll');
					}
				}
			} ]">
		<ul id="layout_west_tree"></ul>
	</div>
	<div title="业务管理" data-options="iconCls:'icon-reload'">
		
	</div>
</div>