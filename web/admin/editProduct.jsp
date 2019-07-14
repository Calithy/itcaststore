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
<title>bookstore后台管理系统-商品编辑</title>
</head>
<body>
	<jsp:include page="head.jsp"/>
	<div class="body">
		<jsp:include page="left.jsp"/>
		<div class="contentdiv2">
			<form action="${pageContext.request.contextPath}/saveProduct" method="post" enctype="multipart/form-data" onsubmit="return formCheck()">
				<!-- id隐藏域 -->
				<input type="hidden" name="id" value="${product.id}"/>
				<div class="titlediv">编 辑 商 品</div>
				<table class="editTable clearfix">
					<tr>
						<td>商品名称：</td>
						<td>
							<input type="text" name="name" class="form-control" value="${product.name}" required/>
						</td>
						<td>商品价格：</td>
						<td>
							<input type="number" name="price" step="any" class="form-control" value="${product.price}" required/>
						</td>
					</tr>
					<tr>
						<td>商品数量：</td>
						<td>
							<input type="number" name="pnum" class="form-control" value="${product.pnum}" required/>
						</td>
						<td>商品类别：</td>
						<td>
							<select name="category" class="form-control" required>
                                <c:if test="${product == null}">
                                    <option value="">请选择商品类别</option>
                                </c:if>
                                <c:if test="${product != null}">
                                    <option value="${product.category}">${product.category}</option>
                                </c:if>
								<c:forEach items="${categories}" var="cate">
									<option value="${cate}">${cate}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>商品图片：</td>
						<td colSpan="3">
							<input type="file" name="imgurl" size="30" value="${product.imgurl}" required/></td>
					</tr>
					<tr>
						<td>商品描述：</td>
						<td colSpan="3">
							<textarea name="description" cols="30" rows="5" style="WIDTH: 96%" class="form-control">${product.description}</textarea>
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
<script>
	function formCheck() {
		//未选择分类
		if ($("select[name='category'] option:selected").val().trim() === '') {
			alert("请选择分类！");
			return false;
		}
	}
</script>
</body>
</html>