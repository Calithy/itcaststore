<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html>
<head>
	<title>订单支付</title>
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
	<link rel="stylesheet" type="text/css" href="css/pay.css" />
</head>
<body>
		<%@include file="pages/header.jsp"%>
	<div class="body">
		<div class="accountDiv">
			<div class="container-fluid row">
				<div class="col-md-8"></div>
				<ol class="breadcrumb col-md-4" style="background-color:white;font-size:13px;">
				  <li class="breadcrumb-item"><a href="">首页</a></li>
				  <li class="breadcrumb-item"><a href="">我的账户</a></li>
				  <li class="breadcrumb-item"><a href="">订单查询</a></li>
				  <li class="breadcrumb-item"><a class="active" href="#">订单支付</a></li>
				</ol>
			</div>
			<div class="container-fluid row">
				<div class="col-md-3 catadiv">
					<span class="title" style="color:#1C3F09;">我的账户</span><br><hr>
					<ul>
						<li><img src="images/icon1.png"/><a href="">用户信息修改</a></li>
						<li><img src="images/icon2.png"/><a href="">订单查询</a></li>
						<li><img src="images/icon3.png"/><a href="#">用户退出</a></li>
					</ul>
				</div>
				<div class="col-md-8 paydiv">
					<table>
						<tr>
							<td>订单号：</td>
							<td><input type="text" name="orderId" class="form-control" placeholder="305a7870-3820-4079-b6f9-5d2b63cbcd2a"/></td>
							<td>支付金额：</td>
							<td><input type="text" name="money" class="form-control" placeholder="59.0" style="float:left"/>元</td>
						</tr>
						<tr>
							<td>选择网上银行：</td>
						</tr>
						<tr>
							<td><input type="radio" name="yh" checked value="ICBC-NET-B2C"/><img src="images/icbc.bmp"/></td>
							<td><input type="radio" name="yh" value="CMBCHINA-NET-B2C"/><img src="images/cmb.bmp"/></td>
							<td><input type="radio" name="yh" value="ABC-NET-B2C"/><img src="images/abc.bmp"/></td>
							<td><input type="radio" name="yh" value="CCB-NET-B2C"/><img src="images/ccb.bmp"/></td>
						</tr>
						<tr>
							<td><input type="radio" name="yh" value="BCCB-NET-B2C"/><img src="images/bj.bmp"/></td>
							<td><input type="radio" name="yh" value="BOCO-NET-B2C"/><img src="images/bcc.bmp"/></td>
							<td><input type="radio" name="yh" value="CIB-NET-B2C"/><img src="images/cib.bmp"/></td>
							<td><input type="radio" name="yh" value="NJCB-NET-B2C"/><img src="images/nanjing.bmp"/></td>
						</tr>
						<tr>
							<td><input type="radio" name="yh" value="CMBC-NET-B2C"/><img src=" images/cmbc.bmp"/></td>
							<td><input type="radio" name="yh" value="CEB-NET-B2C"/><img src=" images/guangda.bmp"/></td>
							<td><input type="radio" name="yh" value="BOC-NET-B2C"/><img src=" images/bc.bmp"/></td>
							<td><input type="radio" name="yh" value="PINGANBANK-NET"/><img src=" images/pingan.bmp"/></td>
						</tr>
						<tr>
							<td><input type="radio" name="yh" value="CBHB-NET-B2C"/><img src=" images/bh.bmp"/></td>
							<td><input type="radio" name="yh" value="HKBEA-NET-B2C"/><img src=" images/dy.bmp"/></td>
							<td><input type="radio" name="yh" value="NBCB-NET-B2C"/><img src=" images/ningbo.bmp"/></td>
							<td><input type="radio" name="yh" value="ECITIC-NET-B2C"/><img src=" images/zx.bmp"/></td>
						</tr>
						<tr>
							<td><input type="radio" name="yh" value="SDB-NET-B2C"/><img src="images/sfz.bmp"/></td>
							<td><input type="radio" name="yh" value="GDB-NET-B2C"/><img src="images/gf.bmp"/></td>
							<td><input type="radio" name="yh" value="SHB-NET-B2C"/><img src="images/sh.bmp"/></td>
							<td><input type="radio" name="yh" value="SPDB-NET-B2C"/><img src="images/shpd.bmp"/></td>
						</tr>
						<tr>
							<td><input type="radio" name="yh" value="POST-NET-B2C"/><img src="images/post.bmp"/></td>
							<td><input type="radio" name="yh" value="BJRCB-NET-B2C"/><img src="images/beijingnongshang.bmp"/></td>
							<td><input type="radio" name="yh" value="HXB-NET-B2C"/><img src="images/hx.bmp"/></td>
							<td><input type="radio" name="yh" value="CZ-NET-B2C"/><img src="images/zheshang.bmp"/></td>
						</tr>
					</table>
					<div class="container-fluid" style="text-align: center;"><a href="findOrderByUser.jsp"><button type="button">确认支付</button></a></div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="pages/footer.jsp"%>
</body>
</html>