<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" href="assets/css/home.css"/>
</head>
<body>
    <!-- 头部 -->
    <jsp:include page="header.jsp"/>
    <div id="middle" class="row">
        <!-- 左侧菜单 -->
        <jsp:include page="left.jsp"/>
        <div id="content" class="col-md-8">
            内容
        </div>
    </div>
    <!-- 底部 -->
    <jsp:include page="footer.jsp"/>

</body>
</html>
