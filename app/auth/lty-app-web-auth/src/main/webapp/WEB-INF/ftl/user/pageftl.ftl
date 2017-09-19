<#import "spring.ftl" as spring />
<html>
	<head>
		<title>深圳多元世纪信息技术股份有限公司@SZ</title>
	</head>
	<body>
		<table>
			<thead>
				<tr>
					<th>登录名称</th>
					<th>账户信息</th>
					<th>类型</th>
					<th>状态</th>
					<th>创建时间</th>
				</tr>
			</thead>	
           	<#list userList.rows as user>
				<tr>
					<td>${user.loginName}</td>
					<td>Jerry.Wang</td>
					<td>${user.type}</td>
					<td>${user.status}</td>
					<td>${user.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
				</tr>
           </#list>
		 <table>
	</body>
</html>