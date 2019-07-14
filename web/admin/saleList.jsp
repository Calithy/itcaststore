<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="expend.jsp" %>
<link href="${pageContext.request.contextPath}/css/admin.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
<title>bookstore后台管理系统-销售榜单</title>
</head>
<body>
	<%@include file="head.jsp" %>
	<div class="body">
		<%@include file="left.jsp" %>
		<div class="contentdiv2">
			<div class="titlediv">查 询 条 件</div>
			<form action="${pageContext.request.contextPath}/downloadSaleList" method="get" onsubmit="return check()">
				<div class="container-fluid clearfix">
					<table>
						<tr>
							<td>请输入年份：</td>
							<td><input type="number" class="form-control" name="year" required></td>
						</tr>
					</table>
					<table>
						<tr>
							<td>请选择月份：</td>
							<td>
								<select name="month" class="form-control">
									<option value="">--选择月份--</option>
									<option value="1">一月</option>
									<option value="2">二月</option>
									<option value="3">三月</option>
									<option value="4">四月</option>
									<option value="5">五月</option>
									<option value="6">六月</option>
									<option value="7">七月</option>
									<option value="8">八月</option>
									<option value="9">九月</option>
									<option value="10">十月</option>
									<option value="11">十一月</option>
									<option value="12">十二月</option>
								</select>
							</td>
						</tr>
					</table>
				</div>
				<div class="container-fluid clearfix">
					<button type="reset" class="btn" name="reset" value="重置">重置</button>
					<button type="submit" class="btn" name="search" value="下载">下载</button>
				</div>
			</form>
		</div>
	</div>
	<%@include file="footer.jsp" %>
<script>
	function check(){
		var year = $("input[name='year']").val().trim();
		var month = $("select[name='month'] option:selected").val().trim();
		if (parseInt(year) < 1900 || parseInt(year) > 2999){
			alert("年份范围：1900-2100。");
			return false;
		}
		else if(month === null || month === ''){
			alert("请选择月份");
			return false;
		}
		return true;
	}
</script>
</body>
</html>