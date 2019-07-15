<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html>
<head>
<title>订单详情</title>
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
	<link rel="stylesheet" type="text/css" href="css/header.css" />

	<link rel="stylesheet" type="text/css" href="css/footer.css" />
 	<style type="text/css">
 		.order{
 			background-color: #FCFDEF;
 			border: solid 1px #CCCCCC;
 			padding: 10px 10px;
 			width: 80%;
 			margin:auto;
 		}
 		.order td{
 			padding: 10px 55px;
 		}
 		.order tr td:nth-of-type(3){
 			padding-left: 80px;
 		}
 		.order tr:nth-of-type(1),tr:nth-last-of-type(1){
 			 background-color: #E1FFE1;
 		}
 		.order hr{
 			background-color:#CCCCCC ;
 			height: 1px;
 		}
 	</style>
</head>
<body>
	<%@include file="pages/header.jsp"%>
	<div class="container">
		<div class="myAccount">
			<div class="row">
				<div class="col-sm-7"></div>
				<div class="col-sm-5">
					<ol class="breadcrumb">
					  <li class="breadcrumb-item"><a href="index.jsp">首页</a></li>
					  <li class="breadcrumb-item "><a href="myAccount.jsp">我的账户</a></li>
					  <li class="breadcrumb-item "><a href="${pageContext.request.contextPath}/FindOrderByUserServlet">订单查询</a></li>
					  <li class="breadcrumb-item active">订单详细信息</li>
					</ol>
				</div>
			</div>
			<div class="order">
				<div>
					<label class="title">
						订单编号:305a7870-3820-4079-b6f9-5d2b63cbcd2a
					</label>
					<table>
						<tr>
							<td>
								序号 		
							</td>
							<td>商品名称 </td>
							<td>价格  </td>
							<td>数量  </td>
							<td>小计  </td>
						</tr>
						<c:forEach items="${orderItems}" var="item"  varStatus="xh">

							<tr>
								<td>${xh.count}</td>
								<td>${item.name}</td>
								<td>${item.price}</td>
								<td>${item.buynum}</td>
								<td>${item.price * item.buynum}</td>
							</tr>

						</c:forEach>

						<tr>

						</tr>
						<tr>
							<td>

							</td>
							<td>   </td>
							<td>  </td>
							<td>  </td>
							<td>${orderMoney} </td>

						</tr>
					</table>
					收货地址：${orderItems[0].receiverAddress} <br>
					收货人：  ${orderItems[0].receiverName}   <br>
					联系方式：${orderItems[0].receiverPhone}    <br>
					<hr>
				</div>
				<div class="row">
				 
					<div class="col-sm-8"></div>
					<div class="col-sm-4">
						<a href="pay.jsp?orderid=${orderItems[fn:length(orderItems) - 1].id}&&money=${orderMoney}">
							<img src=" images/gif53_030.gif" width="204" height="51" border="0">
						</a>
						
					</div>
				</div>
			</div>
		</div>
		
	</div>
	<%@include file="pages/footer.jsp"%>
</body>
</html>