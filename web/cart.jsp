<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html>
<head>
	<title>我的购物车</title>
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
	<link rel="stylesheet" type="text/css" href="css/cart.css" />
</head>
<body>
	<%@include file="pages/header.jsp"%>
	<div class="container">
		<div class="myAccount">
			<div class="row">
				<div class="col-sm-9"></div>
				<div class="col-sm-3">
					<ol class="breadcrumb">
					  <li class="breadcrumb-item"><a href="">首页</a></li>
					  <li class="breadcrumb-item active">购物车</li>
					</ol>
				</div>
			</div>
			<div class="cart">
			  
		 		 <img src="images/page_ad.jpg" class="imgC"> 
		 		 <img src="images/buy1.gif"> 
		 	 
			 	<table class="container-fluid">
			 		<tr>
			 			<td>序号</td>
			 			<td>商品名称</td>
			 			<td>价格</td>
			 			<td>数量</td>
			 			<td>库存</td>
			 			<td>小计</td>
			 			<td>取消</td>
			 		</tr>
			 		<tr>
			 			<td>1</td>
			 			<td>网管员必备宝典</td>
			 			<td>20.0</td>
			 			<td><input type="button" value="-" name="minus"><input type="text" name="amount"><input type="button" value="+" name="plus"></td>
			 			<td>15</td>
			 			<td>40.0</td>
			 			<td><a href="">x</a></td>
			 		</tr>
			 		<tr>
			 			<td></td>
			 			<td></td>
			 			<td></td>
			 			<td> </td>
			 			<td> </td>
			 			<td> </td>
			 			<td> 合计：40.0元</td>
			 		</tr>
			 	</table>
			 	<div class="decide container-fluid clearfix">
			 		<div class="img-float">
			 			<a href=""  ><img src="images/gwc_jx.gif"></a>
			 			<a href=""  ><img src="images/gwc_buy.gif"></a>
			 		</div>
			 		
			 		
			 	</div>
			</div>
		</div>
		
	</div>
	<%@include file="pages/footer.jsp"%>
</body>
</html>