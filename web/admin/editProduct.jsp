<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="expend.jsp" %>
<link href="${pageContext.request.contextPath}/css/admin.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
<title>bookstore后台管理系统-商品编辑</title>
</head>
<body>
	<%@include file="head.jsp" %>
	<div class="body">
		<%@include file="left.jsp" %>
		<div class="contentdiv2">
			<div class="titlediv">编 辑 商 品</div>
			<table class="editTable clearfix">
				<tr>
					<td>商品名称：</td>
					<td>
						<input type="text" name="name" class="form-control"/>
					</td>
					<td>商品价格：</td>
					<td>
						<input type="text" name="price" class="form-control"/>
					</td>
				</tr>
				<tr>
					<td>商品数量：</td>
					<td>
						<input type="text" name="pnum" class="form-control"/>
					</td>
					<td>商品类别：</td>
					<td>
						<select name="category" class="form-control">
							<option value="">--选择商品类加--</option>
							<option value="文学">文学</option>
							<option value="生活">生活</option>
							<option value="计算机">计算机</option>
							<option value="外语">外语</option>
							<option value="经营">经营</option>
							<option value="励志">励志</option>
							<option value="社科">社科</option>
							<option value="学术">学术</option>
							<option value="少儿">少儿</option>
							<option value="艺术">艺术</option>
							<option value="原版">原版</option>
							<option value="科技">科技</option>
							<option value="考试">考试</option>
							<option value="生活百科">生活百科</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>商品图片：</td>
					<td colSpan="3">
					<input type="file" name="upload" size="30" value=""/></td>
				</tr>
				<TR>
					<TD>商品描述：</TD>
					<TD colSpan="3">
						<textarea name="description" cols="30" rows="3" style="WIDTH: 96%" class="form-control"></textarea>
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