<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html>
<head>
	<title>注册页面</title>
	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>传智书城</title>
    
	<!-- 新 Bootstrap4 核心 CSS 文件 -->
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="css/font-awesome.css" />
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
	 <script src="js/jquery.min.js"></script>
	<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
	<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
	  <script src="js/popper.min.js"></script>
	<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
	<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/register.js"></script>
	<link rel="stylesheet" type="text/css" href="css/register.css" />
	<script src="js/header.js"></script>
	<link rel="stylesheet" type="text/css" href="css/header.css" />
	<script src="js/footer.js"></script>
	<link rel="stylesheet" type="text/css" href="css/footer.css" />
	<link rel="stylesheet" type="text/css" href="css/header.css" />

	<link rel="stylesheet" type="text/css" href="css/footer.css" />
</head>
<body>
	<%@include file="pages/header.jsp"%>
	<div class="container content">
		<div class="register">
				<div class="row">
					<div class="col-sm-2 content-margin-min ind-big-font"><b>新用户注册</b></div>	 
				</div>
				<div class="row">
					<div class="col-sm-1"></div>
					<div class="col-sm-9  ">
						<form class="form-horizontal form-margin bottom-border" role="form">
							  <div class="form-group">
							  	<div class="row">
							  		<label for="email" class="col-sm-2 control-label">邮箱</label>
							    	<div class="col-sm-5">
							      		<input type="text" class="form-control form-control-short" id="email" placeholder="">
							    	</div>
							    	<div class="col-sm-4" id="email-pop" class="pop">请输入有效的邮箱地址</div>
							    	 
							  	</div>
							    
							  </div>
							  <div class="form-group">
							  	<div class="row">
							  		<label for="username" class="col-sm-2 control-label">用户名</label>
							    	<div class="col-sm-5">
							    		<input type="text" class="form-control form-control-short" id="username" placeholder="">
							    	</div>
							      	
							      	<div class="col-sm-5" id="username-pop" class="pop">字母数字下划线1-10位，不能是数字开头</div>						      	 						    	 
							  	</div>						    
							  </div>
							  <div class="form-group">
							  	<div class="row">
							  		 <label for="psw" class="col-sm-2 control-label" >密码</label>
							  		 <div class="col-sm-5">
							      		<input type="text" class="form-control form-control-short" id="psw" placeholder="">
							    	</div>
							    	<div class="col-sm-4" id="psw-pop" class="pop">密码请设置6-16位字符</div>
							  	</div>
							  </div>
							  <div class="form-group">
								  	<div class="row">
								  		<label for="psw" class="col-sm-2 control-label">重复密码</label>
									    <div class="col-sm-5">
									      <input type="text" class="form-control form-control-short" id="psw-com" placeholder="">
									    </div>
									    <div class="col-sm-4" id="psw-com-pop" class="pop">两次输入的密码不一致</div>
								  	</div>				    
							  </div> 
							  <div class="form-group">
								  	<div class="row">
								  		<label  class="col-sm-2 control-label">性别</label>
								  		<div class="col-sm-6">
								  			<div class="row">
								  				<div class="radio radio-inline col-sm-3">
								  					<label>
								  						<input type="radio" name="gender" value="男" checked="">男
								  					</label>
								  				</div> 
								  				<div class="radio radio-inline col-sm-3">
								  					<label>
								  						<input type="radio" name="gender" value="女">女
								  					</label>
								  				</div>
								  			</div> 	
		            					</div><!-- /.col-lg-6 -->
								  	</div>
							  </div>
							  <div class="form-group">
							  	<div class="row">
							  		<label class="col-sm-2 control-label">联系电话</label>
							  		<div class="col-sm-8">
							  			<input type="text" id="phone" class="form-control form-control-short" placeholder="">
							  		</div>
							  		
							  	</div>
							  </div>
							  <div class="form-group">
								  	<div class="row">
								  		<label class="col-sm-2 control-label">个人介绍</label>
								  		<div class="col-sm-8">
								  			<textarea class="form-control" rows="3" id="self-introduction"></textarea>
								  		</div>
								  	</div>
							  </div>
						</form>
					</div>				 
				</div>


				 </div>
					<div class="row ">
					<div class="col-sm-2 content-margin-min ind-big-font"><b>注册验证</b></div>	 
					</div>
					<div class="row ">
						<div class="col-sm-1"></div>
						<div class="col-sm-9 bottom-border">
							<div class="row">
								<label for="verifyingCode" class="col-sm-2">验证码</label>
								<div class="col-sm-4">
									<input type="text" id="verifyingCode" class="form-control-code-short form-control" placeholder="">
									<img src="${pageContext.request.contextPath}/ImageCodeServlet" width="180"
										 height="30" class="textinput" style="height: 30px;" id="img" />&nbsp;&nbsp;
								</div>
								<div class="col-sm-4" id="verifyingCode-pop" class="pop">验证码错误</div>
							</div>
							<div class="row margin-code">
								<div class="col-sm-2"></div>
								<div class="col-sm-4">
									<input type="text" id="code" class="form-control form-control-code" disabled="">
								</div>
								<div class="col-sm-4 form-control-code-a"><a href="#" id="changeCode">看不清，换一张</a></div>
							</div>
						</div>
					</div>
					<div class="row button-margin">
						<div class="col-sm-1"></div>
						<div class="col-sm-9">
							<input type="image" src="images/signup.gif" id="submit" border="0" width="140" height="35"/>
						</div>
					</div>	 
		</div>
	</div>
	 <%@include file="pages/footer.jsp"%>
</body>
</html>
