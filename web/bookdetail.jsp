<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html>
<head>
	<title>图书详情</title>
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
	<link rel="stylesheet" type="text/css" href="css/bookdetail.css" />
	<link rel="stylesheet" type="text/css" href="css/header.css" />

	<link rel="stylesheet" type="text/css" href="css/footer.css" />
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
					  <li class="breadcrumb-item"><a href="">${product.category}</a></li>
					  <li class="breadcrumb-item active">${product.name}</li>
					</ol>
				</div>
			</div>
			<div class="detail">
			  	<img src="images/page_ad.jpg" class="img-top">
			  	<div class="book clearfix">
			  		<div class="book-img">
			  			<img src="${pageContext.request.contextPath}/images${product.imgurl}">
			  		</div>
			  		<div class="des">
			  			<span class="title">${product.name}</span>
			  			<hr>
			  			售价：<span>${product.price}</span>
			  			<hr>
			  			<b>内容简介：</b><br>
			  			<p>${product.description}</p>
			  		</div>
			  		<div class="buy-img">
			  			<a href="${pageContext.request.contextPath}/AddCartServlet?id=${product.id}"><img src="images/buybutton.gif"></a>
			  		</div>
			  		
			  	</div>
		 	</div>
		</div>
		
	</div>
	<%@include file="pages/footer.jsp"%>
</body>
</html>