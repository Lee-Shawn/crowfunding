<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="keys" content="">
<meta name="author" content="">
<%@include file="/WEB-INF/include/css-file.jsp"%>
<link rel="stylesheet" href="${ctp }/css/login.css">
<style>
</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<div>
					<a class="navbar-brand" href="${ctp}/index.jsp" style="font-size: 32px;">尚筹网-创意产品众筹平台</a>
				</div>
			</div>
		</div>
	</nav>

	<div class="container">

		<form id="regForm" class="form-signin" role="form" action="${ctp}/permission/user/reg" method="post">
			<h2 class="form-signin-heading">
				<i class="glyphicon glyphicon-log-in"></i> 用户注册
			</h2>
			<div class="form-group has-success has-feedback">
				<input id="loginacct_input" type="text" name="loginacct" class="form-control" 
					value="${TUser.loginacct }" placeholder="请输入登录账号" autofocus>
				<span class="glyphicon glyphicon-user form-control-feedback"></span>
				<span id="loginMsg" class="errorInfo" style="color:red"></span>
			</div>
			<div class="form-group has-success has-feedback">
				<input id="userpswd_input" type="password" name="userpswd" class="form-control" 
					placeholder="请输入登录密码" style="margin-top: 10px;">
				<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				<span class="errorInfo" style="color:red"></span>
			</div>
			<div class="form-group has-success has-feedback">
				<input id="email_input" type="text" name="email" class="form-control" 
					value="${TUser.email }" placeholder="请输入邮箱地址" style="margin-top: 10px;">
				<span class="glyphicon glyphicon glyphicon-envelope form-control-feedback"></span>
				<span class="errorInfo" style="color:red"></span>
			</div>
			<div class="form-group has-success has-feedback">
				<select class="form-control">
					<option>会员</option>
					<option>管理</option>
				</select>
			</div>
			<div class="checkbox">
				<label> 忘记密码 </label>
				<label style="float: right"> <a href="login.jsp">我有账号</a>
				</label>
			</div>
			<a id="submitBtn" class="btn btn-lg btn-success btn-block"> 注册</a>
		</form>
	</div>
	
	<%@include file="/WEB-INF/include/js-file.jsp"%>
	<script type="text/javascript">
		// 给校验器设置一些策略
		$.validator.setDefaults({
			showErrors: function(map, list) {
				//console.log(map);
				//console.log(list);
				// 将每个元素自己的错误信息显示在自己的图标下
				// 先清除所有错误,状态
				$(".errorInfo").empty();
				$(".form-group").removeClass("has-success has-error has-warning");
				
				$.each(list, function() {
					// 错误信息
					$(this.element).nextAll(".errorInfo").text(this.message);
					// 改变input状态
					$(this.element).parent("div.form-group").addClass("has-error");
				})
			}
		});	
	
		$("#submitBtn").click(function(){
			var loginType = $("select.form-control").val();
			if (loginType == "管理") {
				$("#regForm").submit();
			} else {
				alert("会员注册尚未开通");
			}
			return false;
		});
		
		$("#regForm").validate({
			rules: {
				loginacct: {
					required: true,
					minlength: 6
				},
				userpswd: {
					required: true,
					minlength: 6
				},
				email: {
					required: true,
					email: true
				}
			},
			messages: {
				loginacct: {
					required: "请输入登录帐号",
					minlength: "登陆账号长度不能小于6个字符"
				},
				userpswd: {
					required: "请输入登录密码",
					minlength: "登陆密码长度不能小于6个字符"
				},
				email: {
					required: "请输入注册邮箱",
					email: "请输入正确的邮箱格式"
				}
			}
		});
		
		/* $(document).ready(function(){
			$("#loginacct_input").click(function(){
		    	htmlobj=$.ajax({
		    		url:"${ctp}/permission/user/reg",
		    		async:false
		    	});
		    	$("#loginMsg").html(htmlobj.responseText);
		    });
		}); */
	</script>
</body>
</html>