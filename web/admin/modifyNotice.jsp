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
	<%@include file="head.jsp" %>
	<div class="body">
		<%@include file="left.jsp" %>
		<div class="contentdiv2">
			<div class="titlediv">修 改 公 告</div>
			<table class="editTable">
				<tr>
					<td>公告标题：</td>
					<td colSpan="3">
						<input type="text" name="title" class="form-control" value="暂停当日达业务"/>
					</td>
				</tr>
				<tr>
					<td>公告内容：</td>
					<td colSpan="3">
						<textarea name="details" cols="30" rows="3" style="WIDTH: 96%" class="form-control">尊敬的网上书城用户，<br>为了让大家有更好的购物体验，3月25日起，当日达业务关小黑屋回炉升级！<br>具体开放时间请留意公告，感谢大家的支持与理解，祝大家购物愉快！<br>3月23日<br></textarea>
					</td>
				</tr>
				<TR>
					<td colSpan="4">
						<img src="${pageContext.request.contextPath}/images/shim.gif">
					</td>
				</TR>
				<tr>
					<td colSpan="4">
						<button class="btn" type="button" onclick="history.go(-1)" value="返回" >返回</button>
						<button type="reset" value="重置" class="btn">重置</button>
						<button type="submit" class="btn" value="确定">确定</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>