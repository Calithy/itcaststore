<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="ylzl.domain.User" %>
<div class="container space">

  		<div class="row">
  			
			<div class="col-sm-3">
				<a href="index.jsp">
            		<img src="images/logo.png" width="200" height="60" border="0" /> 
          		</a>
			</div>
			<div class="col-sm-5">
				
			</div>
			 		
			<div class="col-sm-4">
				 <img src="images/cart.gif" width="26" height="23" style="margin-bottom:-4px" />
             		&nbsp;
            		<a href="cart.jsp">购物车</a>
          | 		<a href="#">帮助中心</a>
				<%
					User user = (User)session.getAttribute("user");
					if(user == null){
				%>
          | 		<a href="account.jsp">我的帐户</a>
				<%}else{%>
					<a href="myAccount.jsp">我的帐户</a>
				<%}%>
          | 		<a href="register.jsp">新用户注册</a>
				    <div class="row">
						<div class="col-sm-5"></div>
						<div class="col-sm-7">
							<%
								if (user != null){
							%>
							<p class="title" style="color: darkred">欢迎 ${sessionScope.user.getUsername()}</p>
							<%}%>
						</div>
					</div>
			</div>
  		</div>
  	</div>
	<div class="container space">

		<div class="row">
			<div class="col-sm-12">
				<nav class="bg-green navbar-expand-sm"></nav>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<nav class="navbar navbar-expand-sm bg-black" >

			  <!-- Links -->
					  <ul class="navbar-nav">
					    <li class="nav-item">
					      <a class="nav-link color-white" href="#">文学</a>
					    </li>
					    <li class="nav-item">
					      <a class="nav-link color-white" href="#">生活</a>
					    </li>
					    <li class="nav-item">
					      <a class="nav-link color-white" href="#">计算机</a>
					    </li>
					    <li class="nav-item">
					      <a class="nav-link color-white" href="#">外语</a>
					    </li>
					    <li class="nav-item">
					      <a class="nav-link color-white" href="#">经管</a>
					    </li>
					    <li class="nav-item">
					      <a class="nav-link color-white" href="#">励志</a>
					    </li>
					    <li class="nav-item">
					      <a class="nav-link color-white" href="#">社科</a>
					    </li>
					    <li class="nav-item">
					      <a class="nav-link color-white" href="#">学术</a>
					    </li>
					    <li class="nav-item">
					      <a class="nav-link color-white" href="#">少儿</a>
					    </li>
					    <li class="nav-item">
					      <a class="nav-link color-white" href="#">艺术</a>
					    </li>
					    <li class="nav-item">
					      <a class="nav-link color-white" href="#">原版</a>
					    </li>
					    <li class="nav-item">
					      <a class="nav-link color-white" href="#">科技</a>
					    </li>
					    <li class="nav-item">
					      <a class="nav-link color-white" href="#">考试</a>
					    </li>
					    <li class="nav-item">
					      <a class="nav-link color-white" href="#">生活百科</a>
					    </li>
					    <li class="nav-item">
					      <a class="nav-link color-white" href="${pageContext.request.contextPath}/ShowAllProductsServlet" style="color:#b4d76d">全部商品目录</a>
					    </li>
					  </ul>
			 
				</nav>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 ">
				<nav class="bg-yellow navbar-expand-sm">
					<div class="row">
						<div class="col-sm-8"></div>
							<div class="col-sm-4 add-mar">
								<form action="#" >
									Search 
									<input type="text" value="请输入书名" width="50" height="20" 
								 class="font-size-small" /> 
								 
								<a href="#">
									<img src="images/serchbutton.gif" /> 
								</a>
							  </form>
						   </div>
						</div>
					</div>
				</nav>
				
			</div>
			
		</div>		
	</div>