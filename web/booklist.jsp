<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html>
<head>
	<title>图书列表</title>
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
 	<link rel="stylesheet" type="text/css" href="css/booklist.css" />
</head>
<body>
	<%@include file="pages/header.jsp"%>
<div class="container">
		<div class="myAccount">
			<div class="row">
				<div class="col-sm-7"></div>
				<div class="col-sm-5">
					<ol class="breadcrumb">
					  <li class="breadcrumb-item"><a href="">首页</a></li>
					  <li class="breadcrumb-item "><a href="">我的账户</a></li>
					  <li class="breadcrumb-item "><a href="">订单查询</a></li>
					  <li class="breadcrumb-item active">订单详细信息</li>
					</ol>
				</div>
			</div>
			<div class="booklist">
				<label class="title">商品目录</label>
				<hr>
				<label class="title">全部商品 </label> 共18种商品 
				<hr>
				<div class="container-fluid">
					<img src="images/productlist.gif" style="width:100%;height: 38px;margin:15px 0;">
				</div>
				
				<table class="col-md-12">
					<tr>
						<td>
							<div class="img-shadow">
								<img src="images/timg.jfif">
							</div>
							<a href="#">数据库教程<br>售价：45元</a>
						</td>
						<td>
							<div class="img-shadow">
								<img src="images/timg.jfif">
							</div>
							<a href="#">数据库教程<br>售价：45元</a>
						</td>
						<td>
							<div class="img-shadow">
								<img src="images/timg.jfif">
							</div>
							<a href="#">数据库教程<br>售价：45元</a>
						</td>
						<td>
							<div class="img-shadow">
								<img src="images/timg.jfif">
							</div>
							<a href="#">数据库教程<br>售价：45元</a>
						</td>
					</tr>
				</table>
				<div class="container-fluid pagebtn">
					<ul>
						<li><a href=""><img src="images/previous_page2.png"></a></li>
						<li class="active"><a href="">1</a></li>
						<li><a href="">2</a></li>
						<li><a href="">3</a></li>
						<li><a href=""><img src="images/next_page.png"></a></li>
					</ul>
				</div>
			</div>
		</div>
		
	</div>
	<%@include file="pages/footer.jsp"%>
</body>
</html>