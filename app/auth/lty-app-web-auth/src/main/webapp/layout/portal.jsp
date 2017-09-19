<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript" charset="utf-8">
	$(function() {
		panels = [ {
			id : 'p1',
			title : '抽奖',
			height : 200,
			collapsible : true,
			href:'${pageContext.request.contextPath}/layout/portal/about.jsp'
		}, {
			id : 'p2',
			title : '会议',
			height : 200,
			collapsible : true,
			href:'${pageContext.request.contextPath}/layout/portal/link.jsp'
		}, {
			id : 'p3',
			title : '文件',
			height : 200,
			collapsible : true,
			href:'${pageContext.request.contextPath}/layout/portal/repair.jsp'
		}, {
			id : 'p4',
			title : '新闻',
			height : 200,
			collapsible : true,
			content : '<h1></h1>'
		}, {
			id : 'p5',
			title : '文化',
			height : 200,
			collapsible : true,
			href:'${pageContext.request.contextPath}/layout/portal/about2.jsp'
		} , {
			id : 'p6',
			title : '动态',
			height : 200,
			collapsible : true,
			href:'${pageContext.request.contextPath}/layout/portal/qun.jsp'
		} ];

		 $('#layout_portal_portal').portal({
			border : false,
			fit : true,
			onStateChange : function() {
				$.cookie('portal-state', getPortalState(), {
					expires : 7
				});
			}
		});
		var state = $.cookie('portal-state');
		if (!state) {
			state = 'p1,p2,p3:p4,p5,p6';/*冒号代表列，逗号代表行*/
		}
		addPortalPanels(state);
		$('#layout_portal_portal').portal('resize');

	});

	function getPanelOptions(id) {
		for ( var i = 0; i < panels.length; i++) {
			if (panels[i].id == id) {
				return panels[i];
			}
		}
		return undefined;
	}
	function getPortalState() {
		var aa=[];
		for(var columnIndex=0;columnIndex<2;columnIndex++) {
			var cc=[];
			var panels=$('#layout_portal_portal').portal('getPanels',columnIndex);
			for(var i=0;i<panels.length;i++) {
				cc.push(panels[i].attr('id'));
			}
			aa.push(cc.join(','));
		}
		return aa.join(':');
	}
	function addPortalPanels(portalState) {
		var columns = portalState.split(':');
		for (var columnIndex = 0; columnIndex < columns.length; columnIndex++) {
			var cc = columns[columnIndex].split(',');
			for (var j = 0; j < cc.length; j++) {
				var options = getPanelOptions(cc[j]);
				if (options) {
					var p = $('<div/>').attr('id', options.id).appendTo('body');
					p.panel(options);
					$('#layout_portal_portal').portal('add', {
						panel : p,
						columnIndex : columnIndex
					});
				}
			}
		}
	}
</script>
<div id="layout_portal_portal" style="position:relative">
	<div></div>
	<div></div>
</div>