<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/assets/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/assets/bootstrap/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/assets/css/home.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/assets/css/list.css"/>
</head>
<body>
<!-- 头部 -->
<jsp:include page="../header.jsp"/>
<div id="middle" class="row">
    <!-- 左侧菜单 -->
    <jsp:include page="../left.jsp"/>
    <div id="content" class="col-md-8">
        <div class="container">
            <table id="dataTable" class="table table-striped table-bordered table-hover">
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
                        <td></td>
                        <td></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- 底部 -->
<jsp:include page="../footer.jsp"/>

</body>
</html>
