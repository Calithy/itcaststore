<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="castdiv">
	<ul>
		<li><a href="${pageContext.request.contextPath}/listProduct">商品管理</a></li>
		<li><a href="${pageContext.request.contextPath}/showSaleList">销售榜单</a></li>
		<li><a href="${pageContext.request.contextPath}/listOrder">订单管理</a></li>
		<li><a href="${pageContext.request.contextPath}/listNotices">公告管理</a></li>
	</ul>
</div>

<script>
	$(function () {
		$(".castdiv ul").css("height",$(document).height()-214.5);
	});
</script>