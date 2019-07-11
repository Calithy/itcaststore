<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="expend.jsp" %>
<link href="${pageContext.request.contextPath}/css/admin.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
<title>bookstore后台管理系统-修改公告</title>
</head>
<body>
	<jsp:include page="head.jsp"/>
	<div class="body">
		<jsp:include page="left.jsp"/>
		<div class="contentdiv2">
			<form action="#" method="post">
				<!-- id隐藏域 -->
				<input type="hidden" name="id" value="${notice.n_id}"/>
				<div class="titlediv">修 改 公 告</div>
				<table class="editTable">
					<tr>
						<td>公告标题：</td>
						<td colSpan="3">
							<input type="text" name="title" class="form-control" value="${notice.title}"/>
						</td>
					</tr>
					<tr>
						<td>公告内容：</td>
						<td colSpan="3">
							<textarea name="details" cols="30" rows="5" style="WIDTH: 96%" class="form-control">${notice.details}</textarea>
						</td>
					</tr>
					<tr>
						<td colSpan="4">
							<img src="${pageContext.request.contextPath}/images/shim.gif">
						</td>
					</tr>
					<tr>
						<td colSpan="4">
							<button class="btn" type="button" onclick="history.go(-1)" value="返回" >返回</button>
							<button type="reset" value="重置" class="btn">重置</button>
							<button type="submit" class="btn" value="确定">确定</button>
						</td>
					</tr>
				</table>
			</form>

		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>