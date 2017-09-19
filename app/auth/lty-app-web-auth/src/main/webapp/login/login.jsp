<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4.3/jquery-1.11.3.js"
	charset="utf-8"></script>
<script type="text/javascript">
function validate() {
	var loginName = $("#loginName").val();
	var password = $("#password").val();
	if (loginName == "" || loginName == null || loginName == "商户号或注册邮箱") {

		$("#m-tip").html("请输入商户号或注册邮箱");
		return false;
	}
	/* if (password == "" || password == null) {

		$("#p-tip").html("请输入密码！")
		return false;
	} */
	var sha_password = hex_sha1(password)
	var loginSuccss = false;
	$.ajax({
		url : '${pageContext.request.contextPath}/login/login.shtml',
		type : 'post',
		async : false,
		data : {
			loginName : loginName,
			password : sha_password
		},
		success : function(result) {
			
				try {
					var r = $.parseJSON(result);
				} catch (e) {
					r = result;
				}
				if (r.success) {
					loginSuccss = r.success;
				} else {
					alert(r.msg);
				}

			}

		});

		if (loginSuccss) {
			location.replace(location.href);
		}

		return true;
	}
</script>
<script src="js/sha1.js"></script>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<shiro:authenticated>
	<script type="text/javascript">
		location.href  = "<%=basePath%>";
	</script>
</shiro:authenticated>
</head>
<body>
	<div class="login">
		<div class="login-head">
			<div class="login-head-a">
				<img src="img/a.jpg" title="" alt="" />
				<p>我的</p>
			</div>
			<div class="login-head-b">后台管理</div>
		</div>
		<div class="login-con">
			<div class="login-a">
				<form id="loginForm">
					<div class="login-b">
						<div class="login-b-a">用户登陆</div>
						<div class="login-b-b">
							<ul>
								<li><label for="userName">用户名：</label><input type="text"
									id="loginName" name="loginName" />
									<h1 id="m-tip"></h1></li>
								<li><label for="password">密 &nbsp;&nbsp;码：</label><input
									type="password" id="password" name="password" />
									<h1 id="p-tip"></h1></li>
								<li><label>验证码：</label><input type="text" id="input1" /> <input
									type="text" id="checkCode" class="code" style="width: 55px" />
									<a href="#">看不清楚</a>
									<h1 id="c-tip"></h1> <!--输入错误时的输入框样式<input type="text" name="textfield" id="textfield" class="receSum-error" />-->
									<!--当输入的手机号码发生错误时，出现如下提示信息
                                   <p class="error-tips-1 spanRed">在此处显示错误的信息提示——如：对不起，您输入的手机号码格式有误，请重新输入！</p>-->

								</li>

								<li class="login-x">
									<div class="login-x-a">
										<input type="button" name="登录" value="登录" id="Button1"
											onClick="validate();" />
										<div class="x"></div>
									</div>
								</li>

							</ul>
						</div>
						<div class="login-b-c">
							&nbsp;&nbsp;<a href="#">忘记登录密码？</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="login-foot">网络科技有限公司©2016 浙ICP备12040171号</div>
	</div>
</body>
</html>