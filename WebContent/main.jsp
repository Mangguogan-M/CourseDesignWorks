<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<!-- 引入样式 -->
<link rel="stylesheet" href="css/3.css">
</head>
<body
	style="background-image: url('img/32.jpg'); background-size: cover; font-size: 20px;">
	<div>
	<a href="homepage.html"><img src="img/1.png" align="top" width="100px" height="100px" ></a>
	</div>
	<audio loop="loop" autoplay="autoplay">
		<source src="img/2.aac">
	</audio>
	<div class="main_wrap">
		<!-- 数据显示区域 -->
		<span
			style="font-size: 40px; font-family: sans-serif; font-weight: bold; margin-left: 200px; margin-top: 100px; color: red; text-align: center;" class="span_1">数据展示一览表</span><br>
		<table border="1" style="margin-top: 30px;" class = "table_1">
			<!-- 一行 -->
			<tr  style="font-weight: bold;">
				<td>序号</td>
				<td>昵称</td>
				<td>性别</td>
				<td>年龄</td>
				<td>详细</td>
			</tr>
			<c:forEach items="${list}" var="us" varStatus="i">
				<tr align="center">
					<td>${i.index+1}</td>
					<td>${us.nickname}</td>
					<td>
						<c:if test="${us.gendar==109}">男</c:if>
						<c:if test="${us.gendar==102}">女</c:if>
					</td>
					<td>${us.age}</td>
					<td><c:if test="${u.id==us.id}">
							<a href="#" onclick="alert('功能完善中，敬请期待.....');">修改</a>
							<a href="#" onclick="return confirm('确认要删除么');">删除</a>
						</c:if> <a href="#" onclick="alert('功能完善中，敬请期待.....');">详细</a></td>
				</tr>
			</c:forEach>
		</table>
		<!-- 返回 -->
		<a href="<%session.invalidate();%>" class = "a_1">返回</a>
	</div>
</body>
</html>