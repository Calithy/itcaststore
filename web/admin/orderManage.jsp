<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="expend.jsp" %>
<link href="${pageContext.request.contextPath}/css/admin.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
<title>bookstore后台管理系统-订单管理</title>
</head>
<body>
	<%@include file="head.jsp" %>
	<div class="body">
		<%@include file="left.jsp" %>
		<div class="contentdiv2">
			<div class="titlediv">查 询 条 件</div>
			<form action="${pageContext.request.contextPath}/searchOrder" method="get">
				<div class="container-fluid clearfix">
					<table class="formTable">
						<tr>
							<td>订单编号：</td>
							<td><input type="text" class="form-control" name="id"></td>
						</tr>
					</table>
					<table class="formTable">
						<tr>
							<td>收件人：</td>
							<td><input type="text" class="form-control" name="name"></td>
						</tr>
					</table>
				</div>
				<div class="container-fluid clearfix">
					<button type="reset" class="btn" name="reset" value="重置">重置</button>
					<button type="submit" class="btn" name="search" value="查询">查询</button>
				</div>
			</form>
			<div class="titlediv">订 单 列 表</div>
			<div class="container-fluid con clearfix">
				<table class="listDataTable table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<td>订单编号</td>
							<td>收件人</td>
							<td>地址</td>
							<td>联系电话</td>
							<td>总价</td>
							<td>所属用户</td>
							<td>订单状态</td>
							<td>查看</td>
							<td>删除</td>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${orders}" var="order">
						<tr>
							<td>${order.id}</td>
							<td>${order.receiverName}</td>
							<td>${order.receiverAddress}</td>
							<td>${order.receiverPhone}</td>
							<td>${order.money}</td>
							<td>${order.userName}</td>
							<td>
								<c:if test="${order.paystate == 0}">未支付</c:if>
								<c:if test="${order.paystate == 1}">已支付</c:if>
							</td>
							<td><a href="${pageContext.request.contextPath}/orderInfo?id=${order.id}"><img src="${pageContext.request.contextPath}/images/button_view.gif"></a></td>
							<td><a href="${pageContext.request.contextPath}/deleteOrder?id=${order.id}"><img src="${pageContext.request.contextPath}/images/i_del.gif"></a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>