<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html>
<head>
	<title>订单结算</title>
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
	<link rel="stylesheet" type="text/css" href="css/checkout.css" />
	<script type="text/javascript">
		$(function(){
			$("input[name=address]").focus(function(){
					$(".pop").css("display","none");
			});
			$(".order-sub img").click(function(){
				var val = $("input[name=address]").val();
				if(val.length==0){

					$(".pop").css("display","block");
				}
			});
		});
	</script>
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
					  <li class="breadcrumb-item"><a href="">文学</a></li>
					  <li class="breadcrumb-item active">学会宽容</li>
					</ol>
				</div>
			</div>
			<div class="checkout clearfix">
			   <img src="images/buy2.gif">
			   <br>
			   <p>你好，hanyongmeng！欢迎您来到网上书城结算中心</p>
			   <table class="container-fluid table-list">
			 		<tr>
			 			<td>序号</td>
			 			<td>商品名称</td>
			 			<td>价格</td>
			 			<td>类别</td>
			 			<td>数量</td>
			 			<td>小计</td>
			 		</tr>
			 		<tr>
			 			<td>1</td>
			 			<td>网管员必备宝典</td>
			 			<td>20.0</td>
			 			<td>原版</td>
			 			<td><input type="text" name="amount" value="2"> </td>
			 			<td>20.0</td>
			 			 
			 		</tr>
			 		<tr>
			 			<td></td>
			 			<td></td>
			 			<td></td>
			 			<td> </td>
			 			<td> </td>
			 			<td> 合计：20.0元</td>
			 		</tr>
			 	</table>
			 	<form>
			 		<table>
			 			<tr>
			 				<td><label for="address">收获地址</label></td>
			 				<td><input type="text" name="address" class="form-control"></td>
			 				<td><span class="pop"> 收获地址必须填写</span></td>
			 			</tr>
			 			<tr>
			 				<td><label for="user">收货人</label></td>
			 				<td><input type="text" name="user" class="form-control" value="hanyongmeng"></td>
			 			</tr>
			 			<tr>
			 				<td><label for="phone">联系方式</label></td>
			 				<td><input type="text" name="phone" class="form-control" value="15207545526"></td>
			 			</tr>
			 		</table>
			 		 
			 	</form>
			 	<hr>
			 	<div class="order-sub">
			 		<a href=""><img src="images/gif53_029.gif"></a>
			 	</div>
		 	</div>
		</div>
		
	</div>
	<%@include file="pages/footer.jsp"%>
</body>
</html>