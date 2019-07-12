<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="expend.jsp" %>
<link href="${pageContext.request.contextPath}/css/admin.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
<title>bookstore后台管理系统-订单信息查看</title>
</head>
<body>
	<%@include file="head.jsp" %>
	<div class="body">
		<%@include file="left.jsp" %>
		<div class="contentdiv2">
			<div class="titlediv">订 单 详 细 信 息</div>
			<table class="editTable clearfix">
				<tr>
					<td>订单编号：</td>
					<td>10e73ea6-52a6-4e91-902f-e2d7131f150f</td>
					<td>所属用户：</td>
					<td>madan</td>
				</tr>
				<tr>
					<td>收件人：</td>
					<td>madan</td>
					<td>联系电话：</td>
					<td>13269219270</td>
				</tr>
				<tr>
					<td>送货地址：</td>
					<td>dsdd</td>
					<td>总价：</td>
					<td>110.0</td>
				</tr>
				<tr>
					<td>下单时间：</td>
					<td colSpan="3">2019-07-10</td>
				</tr>
				<TR>
					<TD>商品信息</TD>
					<TD colSpan="3">
						<table class="sTable">
							<tr>
								<td>序号</td>
								<td>商品</td>
								<td>商品编号</td>
								<td>商品名称</td>
								<td>商品价格</td>
								<td>购买数量</td>
								<td>商品类别</td>
								<td>商品描述</td>
							</tr>
							<tr>
								<td>1</td>
								<td>
									<img src="${pageContext.request.contextPath}/images/book1.png" width="50" height="50">
								</td>
								<td>26ddd0c6-d7f2-4a83-b01b-286bb8c38420</td>
								<td>干掉太阳旗</td>
								<td>50.0</td>
								<td>1</td>
								<td>文学</td>
								<td>很不错</td>
							</tr>
						</table>
					</TD>
				</TR>
				<TR>
					<td colSpan="4">
						<img src="${pageContext.request.contextPath}/images/shim.gif">
					</td>
				</TR>
				<tr>
					<td colSpan="4">
						<button class="btn" type="button" onclick="history.go(-1)" value="返回" >返回</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>