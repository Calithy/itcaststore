<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
    <link rel="stylesheet" type="text/css" href="css/header.css" />

    <link rel="stylesheet" type="text/css" href="css/footer.css" />
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
			$("#summitButton").click(function () {
				var address = $("input[name='address']").val();
				var username = $("input[name='username']").val();
				var phone = $("input[name='phone']").val();
				var money = 50;
				var len = ${fn:length(orderItems)};
				alert(len);
				var orderId = '${orderItems[fn:length(orderItems)-1].id}';
				alert(orderId);
				var data = {"address":address,"username":username,"telphone":phone,"orderId":orderId,"money":money};
				$.post("${pageContext.request.contextPath}/AddAdressServlet",data);

				$(document).ajaxComplete(function(event, xhr, settings){
					console.log("complete");
					var url = xhr.getResponseHeader("redirectUrl");
					var enable = xhr.getResponseHeader("enableRedirect");
					if((enable == "true") && (url != "")){
						var win = window;
						while (win != win.top){
							win = win.top;
						}
						win.location.href = url;
					}
				});
			})


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
				   <c:forEach items="${orderItems}" var="orderItem" varStatus="xh">
					   <tr>
						   <td>${xh.count}</td>
						   <td>${orderItem.name}</td>
						   <td>${orderItem.price}</td>
						   <td>原版</td>
						   <td><input type="text" name="amount" value="${orderItem.buynum}"> </td>
						   <td>${orderItem.price * orderItem.buynum}</td>

					   </tr>
				   </c:forEach>

			 		<tr>
			 			<td></td>
			 			<td></td>
			 			<td></td>
			 			<td> </td>
			 			<td> </td>
			 			<td> 合计：20.0元</td>
			 		</tr>
			 	</table>
			 	<form role="form">
			 		<table>
			 			<tr>
			 				<td><label name="address">收获地址</label></td>
			 				<td><input type="text" name="address" class="form-control"></td>
			 				<td><span class="pop"> 收获地址必须填写</span></td>
			 			</tr>
			 			<tr>
			 				<td><label name="username">收货人</label></td>
			 				<td><input type="text" name="username" class="form-control" value="hanyongmeng"></td>
			 			</tr>
			 			<tr>
			 				<td><label name="phone">联系方式</label></td>
			 				<td><input type="text" name="phone" class="form-control" value="15207545526"></td>
			 			</tr>
			 		</table>

			 	</form>
			 	<hr>
			 	<div class="order-sub">
			 		<img src="images/gif53_029.gif" id="summitButton">
			 	</div>
		 	</div>
		</div>
		
	</div>
	<%@include file="pages/footer.jsp"%>
</body>
</html>