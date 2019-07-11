<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
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
	<script src="js/index.js"></script>
	<link rel="stylesheet" type="text/css" href="css/index.css" />
	<script src="js/header.js"></script>
	<link rel="stylesheet" type="text/css" href="css/header.css" />
	<script src="js/footer.js"></script>
	<link rel="stylesheet" type="text/css" href="css/footer.css" />
  </head>
  <body>
  	<%@include file="pages/header.jsp"%>
	<div class="content">
			<div class="container space-deg2">
			 	<div class="ad">
		                <ul class="slider">
		                    <li><img src="images/index_ad0.jpg" /></li>
		                    <li><img src="images/index_ad1.jpg" /></li>
		                    <li><img src="images/index_ad2.jpg" /></li>
		                    <li><img src="images/index_ad3.jpg" /></li>
		                    <li><img src="images/index_ad4.jpg" /></li>
		                </ul>
		                <ul class="num">
		                    <li class="on">1</li>
		                    <li>2</li>
		                    <li>3</li>
		                    <li>4</li>
		                    <li>5</li>
		                </ul>
		     	</div>
	   		</div>
		 	<div class="container space-deg2">
			 	<div class="annoucer clear">
			 		
			 		<div class="float-left">
			 			<img src=" images/billboard.gif" width="497" height="38" />
			 			<table cellspacing="0" class="ctl">
							<tr>
								<td width="485" height="100%">因今天心情不好，全部书11折，爱买不买！！</td>
							</tr>
						</table>	
			 		</div>
					
					<div class="float-left">
						<table width="100%" border="0" cellspacing="0">
							<tr>
								<td>
									<img src=" images/hottitle.gif" width="126" height="29" />
								</td>
							</tr>
						</table>
					</div>
					
			 	</div>
		 	</div>
	</div>
	
	 <%@include file="pages/footer.jsp"%>
  </body>
</html>
