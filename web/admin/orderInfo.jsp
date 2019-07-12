<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="expend.jsp" %>
<link href="${pageContext.request.contextPath}/css/admin.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
<title>bookstore后台管理系统-订单信息详情</title>
</head>
<body>
	<%@include file="head.jsp" %>
	<div class="body">
		<%@include file="left.jsp" %>
		<div class="contentdiv2">
			<div class="titlediv">订 单 详 细 信 息</div>
			<table class="editTable clearfix">
				<tr>
					<td colspan="3">订单编号：</td>
					<td>${order.id}</td>
					<td>所属用户：</td>
					<td>${order.userName}</td>
				</tr>
				<tr>
					<td colspan="3">收件人：</td>
					<td>${order.receiverName}</td>
					<td>联系电话：</td>
					<td>${order.receiverPhone}</td>
				</tr>
				<tr>
					<td colspan="3">送货地址：</td>
					<td>${order.receiverAddress}</td>
					<td>总价：</td>
					<td>${order.money}</td>
				</tr>
				<tr>
					<td colspan="3">下单时间：</td>
					<td colSpan="3"><fmt:formatDate value="${order.ordertime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
				<tr>
					<td colspan="3">商品信息</td>
					<td colSpan="3">
						<div class="container-fluid con clearfix">
							<table class="listDataTable table table-striped table-bordered table-hover">
								<thead>
								<tr>
									<td>序号</td>
									<td>商品</td>
									<td width="270px">商品编号</td>
									<td>商品名称</td>
									<td>商品价格</td>
									<td>购买数量</td>
									<td>商品类别</td>
									<td width="450px">商品描述</td>
								</tr>
								</thead>
								<tbody>
								<c:forEach items="${order.orderItemList}" var="orderItem" varStatus="status">
									<tr>
										<td>${status.count}</td>
										<td>
											<img src="${pageContext.request.contextPath}${products[status.count-1].imgurl}" width="50" height="50">
										</td>
										<td>${products[status.count-1].id}</td>
										<td>${products[status.count-1].name}</td>
										<td>${products[status.count-1].price}</td>
										<td>${orderItem.buynum}</td>
										<td>${products[status.count-1].category}</td>
										<td>${products[status.count-1].description}</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
					</td>
				</tr>
				<tr>
					<td colSpan="6">
						<button class="btn" type="button" onclick="history.go(-1)" value="返回" >返回</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>