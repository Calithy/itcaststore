<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="expend.jsp" %>
<link href="${pageContext.request.contextPath}/css/admin.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
<title>bookstore后台管理系统-商品管理</title>
</head>
<body>
	<jsp:include page="head.jsp"/>
	<div class="body">
		<jsp:include page="left.jsp"/>
		<div class="contentdiv2">
			<div class="titlediv">查 询 条 件</div>
			<form action="${pageContext.request.contextPath}/searchProduct" method="get">
				<div class="container-fluid clearfix">
					<table class="formTable">
						<tr>
							<td>商品编号：</td>
							<td><input type="text" class="form-control" name="id"></td>
						</tr>
						<tr>
							<td>商品名称：</td>
							<td><input type="text" class="form-control" name="name"></td>
						</tr>
					</table>
					<table class="formTable">
						<tr>
							<td>类别：</td>
							<td>
								<select name="category" class="form-control">
									<option value="" selected="selected">--选择商品类别--</option>
									<c:forEach items="${categories}" var="cate">
										<option value="${cate}">${cate}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td>价格区间（元）：</td>
							<td><input type="number" class="form-control" name="minPrice"><span style="float:left;">&nbsp;-&nbsp;</span><input type="number" class="form-control" name="maxPrice"></td>
						</tr>
					</table>
				</div>
				<div class="container-fluid clearfix">
					<button type="reset" class="btn" name="reset" value="重置">重置</button>
					<button type="submit" class="btn" name="search" value="查询">查询</button>
				</div>
			</form>
			<div class="titlediv">商 品 列 表</div>
			<div class="container-fluid con clearfix">
				<button type="button" class="btn" name="add" value="添加" onclick="addBtnClick('${pageContext.request.contextPath}');">添加</button>
				<table class="listDataTable table table-striped table-bordered table-hover">
					<thead>
						<tr class="info">
							<td>商品编号</td>
							<td>商品名称</td>
							<td>商品价格</td>
							<td>商品数量</td>
							<td>商品类型</td>
							<td>编辑</td>
							<td>删除</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products}" var="product">
							<tr>
								<td>${product.id}</td>
								<td>${product.name}</td>
								<td>${product.price}</td>
								<td>${product.pnum}</td>
								<td>${product.category}</td>
								<td><a href="${pageContext.request.contextPath}/editProduct?id=${product.id}"><img src="${pageContext.request.contextPath}/images/i_edit.gif"></a></td>
								<td><a href="${pageContext.request.contextPath}/deleteProduct?id=${product.id}"><img src="${pageContext.request.contextPath}/images/i_del.gif"></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>

<script>
	function addBtnClick(path) {
		$(location).attr("href",path + "/editProduct");
	}
</script>
</body>
</html>