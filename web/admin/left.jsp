
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--左侧菜单 -->
<div id="menu" class="col-md-4">
    <!-- 侧边栏标签页 -->
    <ul class="nav nav-pills nav-stacked">
        <!-- 侧边栏选项 -->
        <li><a href="${pageContext.request.contextPath}/listProduct">商品管理</a></li>
        <li><a href="#">销售榜单</a></li>
        <li><a href="#">订单管理</a></li>
        <li><a href="${pageContext.request.contextPath}/listOrder">公告管理</a></li>
    </ul>
</div>