<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册成功</title>
<!-- 引入jquery脚本 -->
<script src="js/jquery-3.2.1.min.js"></script>
<script>
	//网页文档加载完毕，自动执行function里面的业务
	$(document).ready(function(){
		var $code = $("#mycode");
		var i = 5;
		//每一千毫秒执行一次，i变为0，直接跳转
		setInterval(() => {
			i--;
			$code.html(i);
			if (i == 0) {
				location.href = "login.html";
			}
		}, 1000);
	});
</script>
</head>
<body style = "background-image: url('img/timg1.jpg'); background-size: cover; font-size: 20px;">
	If you`re seeing this, you`ve cuccessfully insering data.
	Congratulation! ${name}<br>
	<span id = "mycode" style = "color: red; font-size: 40px; margin-left: 40px;">5</span>秒以后动跳转登陆界面<br>
	<a href = "login.html" style="margin-left: 60px;">直接点击跳转</a>

</body>
</html>