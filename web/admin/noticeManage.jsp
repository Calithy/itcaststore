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
<title>bookstore后台管理系统-公告管理</title>
</head>
<body>
	<jsp:include page="head.jsp"/>
	<div class="body">
		<jsp:include page="left.jsp"/>
		<div class="contentdiv2">
			<div class="titlediv">公 告 列 表</div>
			<div class="container-fluid con clearfix">
				<button type="button" class="btn" name="add" value="添加" onclick="addNotice('${pageContext.request.contextPath}');">添加</button>
				<table class="listDataTable table table-striped table-bordered table-hover">
					<thead>
						<tr class="info">
							<td>公告编号</td>
							<td>公告标题</td>
							<td>公告内容</td>
							<td>时间</td>
							<td>编辑</td>
							<td>删除</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${notices}" var="notice">
							<tr>
								<td>${notice.n_id}</td>
								<td>${notice.title}</td>
								<td>${notice.details}</td>
								<td>${notice.n_time}</td>
								<td><a href="${pageContext.request.contextPath}/editNotice?id=${notice.n_id}"><img src="${pageContext.request.contextPath}/images/i_edit.gif"></a></td>
								<td><a href="#"><img src="${pageContext.request.contextPath}/images/i_del.gif"></a></td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
<script>
	function addNotice(path) {
		$(location).attr("href",path + "/admin/editNotice.jsp");
	}
</script>
</body>
</html>