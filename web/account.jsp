<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html>
<head>
	<title>我的账户</title>
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
    <script src="js/login.js"></script>
	 <link rel="stylesheet" type="text/css" href="css/login.css" />

</head>
<body>
	<%@include file="pages/header.jsp"%>
	<div class="container content">
			<div class="row">
				<div class="col-sm-3">				 	
					<ol class="breadcrumb breadcrumb-nobg">
						  <li class="breadcrumb-item"><a href="#">首页</a></li>
						  <li class="breadcrumb-item active">个人用户登录</li>
					</ol>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-sm-5">
						<div class="login">
							<div>
								<img src="images/logintitle.gif" style="margin-bottom:30px"/>
							</div>
								<table>
									<tr>
										<td>用户名：</td>
										<td><input type="text" id="username" class="form-control"/></td>
									</tr>
									<tr>
										<td>密码：</td>
										<td><input type="password" id="password" class="form-control"/></td>
									</tr>
									<tr>
										<td></td>
										<td><input type="checkbox" name="isUNR" value="1">记住用户名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="isAL" value="1">自动登录</td>
									</tr>
									<tr>
										<td></td>
										<td>
											<input type="image" id = "loginbutton" src="images/loginbutton.gif"  style="width:90px;height:30px;text-align: left;" />
										</td>
									</tr>
								</table> 	

						</div>
					</div>
					<div class="col-sm-7">
						<div class="toRegister">
					 		<span class="title">您还没有注册？</span><br><br>
							<span>注册新用户，享受更优惠价格!<br><br>千种图书，供你挑选！注册即享受丰富折扣和优惠，便宜有好货！超过万本图书任您选。<br><br>超人气社区！精彩活动每一天。买卖更安心！支付宝交易超安全。<br><br></span>
							<div><a href="register.jsp"><img src="images/signupbutton.gif" style="width:150px;height: 40px;"/></a></div>
						</div>
					</div>
				</div>				
			</div>
	</div>
	<%@include file="pages/footer.jsp"%>
</body>
</html>