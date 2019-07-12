<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html>
<head>
	<title>我的订单</title>
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
 	<link rel="stylesheet" type="text/css" href="css/orders.css" />
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
							<img src="images/icon1.png"><a href="alterInfo.jsp">用户信息修改</a>
						</li>
						<li>
							<img src="images/icon2.png"><a href="orders.jsp">订单查询</a>
						</li>
						<li>
							<img src="images/icon3.png"><a href="index.jsp">用户退出</a>
						</li>
					</ul>
				</div>
				<div class="col-sm-8">
					<div class="orders">
						<span class="title">我的订单</span><br><br>共有<span style="color:red;">1</span>订单
						<table>
							<tr>
								<td style="background-color: #A3E6DF;">订单号</td>
								<td style="background-color: #A3D7E6;">收件人</td>
								<td style="background-color: #A3CCE6;">订单时间</td>
								<td style="background-color: #A3B6E6;">状态</td>
								<td style="background-color: #A3E2E6;">操作</td>
							</tr>
							<tr>
								<td>305a7870-3820-4079-b6f9-5d2b63cbcd2a</td>
								<td>huangyun</td>
								<td>2016-01-13</td>
								<td>未支付</td>
								<td>
									<a href="order.html">查看</a>
									<a href="#">删除</a>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="pages/footer.jsp"%>
</body>
</html>