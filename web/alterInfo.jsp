<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html>
<head>
	<title>资料修改</title>
	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
     
	<!-- 新 Bootstrap4 核心 CSS 文件 -->
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="css/font-awesome.css" />
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
	 <script src="js/jquery.min.js"></script>
	<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
	<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
	  <script src="js/popper.min.js"></script>
	<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
	<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/myAccount.css" />
 	<link rel="stylesheet" type="text/css" href="css/alterInfo.css" />
 	<script type="text/javascript">
 		$(function(){
 			 
 			$("#cpas-pop").css("display","none");
 			$("#pas-pop").css("display","block");
 			$("input[name='password']").focus(function(){
 				$("#pas-pop").css("display","none");
 			});
 			$("input[name='password']").blur(function(){
					var val = $("input[name='password']").val();
					if(val.length>16||val.length<6){
						$("#pas-pop").css("display","block");
					}
			});
			$("input[name='Compassword']").blur(function(){
					var val = $("input[name='password']").val();
					var valc = $("input[name='Compassword']").val();
					if(val!=valc){
						$("#cpas-pop").css("display","block");
					}
			});
			$("form").submit(function(){
				$(".pop").each(function(){
					if($(this).css("display")=="block"){
						alert("请确保所有字段填写正确");
						return false;
					}
				});
				return true;

			});
			 
 		});
 	</script>
</head>
<body>
	<%@include file="pages/header.jsp"%>
	<div class="container">
		<div class="myAccount">
			<div class="row">
				<div class="col-sm-8"></div>
				<div class="col-sm-4">
					<ol class="breadcrumb">
					  <li class="breadcrumb-item"><a href="">首页</a></li>
					  <li class="breadcrumb-item active"><b>我的账户</b></li>
					  <li class="breadcrumb-item active">用户信息修改</li>
					</ol>
				</div>
			</div>
			<div class="row sider">
				<div class="col-sm-1"></div>
				<div class="col-sm-3">
					<ul>
						<li>
							我的账户
						</li>
						<li>
							<img src="images/icon1.png"><a href="#">用户信息修改</a>
						</li>
						<li>
							<img src="images/icon2.png"><a href="${pageContext.request.contextPath}/FindOrderByUserServlet">订单查询</a>
						</li>
						<li>
							<img src="images/icon3.png"><a href="${pageContext.request.contextPath}/LogoutServlet">用户退出</a>
						</li>
					</ul>
				</div>
				<div class="col-sm-8">
					<div class="alter">
						<form method="post" action="UserInfoChangeServlet">
								<table>
									<tr>
										<td>会员邮箱</td>
										<td> <input type="text" id="email" name="email" class="form-control" value="${sessionScope.user.getEmail()}" readonly ></td>
									</tr>
									<tr>
										<td>会员名</td>
										<td><input type="text" id="username" name = "username" class="form-control" value="${sessionScope.user.getUsername()}" readonly></td>
									</tr>
									<tr>
										<td>修改密码</td>
										<td> <input type="text" id="password" name = "password" class="form-control"/></td>
										<td><span id="pas-pop" class="pop">密码为6-16位字符，请区分大小写</span></td>
									</tr>
									<tr>
										<td>重复密码</td>
										<td> <input type="text" name="Compassword" class="form-control"  /></td>
										<td><span id="cpas-pop" class="pop">前后两次密码不一致</span></td>
									</tr>
									<tr>
										<td>性别</td>
										<td> <input type="radio" name="gender" value="男" checked="checked">男
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="radio" name="gender"  value="女"  >女
										</td>
									</tr>
									<tr>
										<td>联系方式</td>
										<td> <input type="text" name="phone" id="phone" class="form-control" value="${sessionScope.user.getTelphone()}" /></td>
									</tr>
									<tr>
										<td> </td>
										<td>  </td>
									</tr>
									<br/>
								</table> 	
								<div>
									 
									<input type="image" id="alterInfo" src="images/botton_gif_025.gif" onclick="submit">
									 
								</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		
	</div>
	<%@include file="pages/footer.jsp"%>
</body>
</html>