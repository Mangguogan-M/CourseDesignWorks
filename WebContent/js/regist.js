/** 验证 * */
var flag1 = false;// 验证码状态
var flag2 = false;// 验证用户名：1、部位空2、输入合法
var flag3 = false;// 验证昵称 ：不许是中文或者英文 unicode:\u0000-\uffff 中文范围：\u4e00-\u9fa5
var flag4 = false;// 验证密码 ：6-12位
var flag5 = false;// 验证年龄 ：18-80
var flag6 = false;// 验证电话 ：长度11位
$(document).ready(
		function() {
			// 验证电话
			var $phone = $("input[name = 'phone']");
			// 给和个对象添加事件函数，鼠标丢失事件
			$phone.blur(function() {
				// 得到输入框的值
				var phone1 = $phone.val();
				phone1 = phone1.replace(/\s/g, "");
				var v3 = /^1(3|4|5|7|8)\d{9}$/;
				if (v3.test(phone1)) {
					$("#phone_err").css("color", "green").html("√正确");
				} else {
					$("#phone_err").css("color", "red").html("×错误");
	 			}
			});
			// 验证年龄
			var $age = $("input[name='age']");
			$age.blur(function() {
				var age1 = $age.val();
				age1 = age1.replace(/\s/g, "");
				var v3 = /^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
				if (v3.test(age1)) {
					$("#age_err").css("color", "green").html("√正确");
				} else {
					$("#age_err").css("color", "red").html("×您输入错误");
				}
			});
			// 验证密码
			var $pwd = $("input[name = 'pwd']");
			// 给和个对象添加事件函数，鼠标丢失事件
			$pwd.blur(function() {
				// 得到输入框的值
				//密码强度正则，最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符
				//var v2 = /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/;
				//输出 true
				//console.log("=="+v2.test("iFat3#"));
				var pwd1 = $pwd.val();
				pwd1 = pwd1.replace(/\s/g, "");
				// 正则表达式最短6位，最长16位 {6,16}
				// 可以包含小写大母 [a-z] 和大写字母 [A-Z]
				// 可以包含数字 [0-9]
				// 可以包含下划线 [ _ ] 和减号 [ - ]
				var v2 = /^[\w_]{6,16}$/;
				if (v2.test(pwd1)) {
					$("#pwd_err").css("color", "green").html("√密码可以使用");
				} else {
					$("#pwd_err").css("color", "red").html("×密码不合法");
				}
			});
			// 验证昵称
			var $nickname = $("input[name='nickname']");
			// 给这个对象添加事件函数，鼠标丢失事件
			$nickname.blur(function() {
				// 得到输入框的值
				var nick = $nickname.val();
				// 为了防止有人恶意用空格注册
				nick = nick.replace(/\s/g, "");
				// 中文，英文，下划线，4-10个长度
				var v1 = /^[\u4e00-\u9fa5_a-zA-Z_]{4,10}$/;
				if (v1.test(nick)) {
					$("#nick_err").css("color", "green").html("√昵称可用");
				} else {
					$("#nick_err").css("color", "red").html("×昵称不合法");
				}
			});
			// 验证用户名
			var $username = $("input[name='username']");
			// 给这个对象添加时间函数，鼠标丢失时间
			$username.blur(function() {
				var name1 = $username.val();
				// 为了防止有人恶意用空格注册
				name1 = name1.replace(/\s+/g, "");
				alert(name1.length);
				// 判定是否有空格
				if (name1 == null || name1.length == 0) {
					$("#name1_err").css("color", "red").css("font-size", 10)
							.html("×不能为空！");
					flag2 = false;
				} else {
					$.ajax({
						url : "findName",
						dataType : "json",
						data : {
							"name1" : name1
						},
						success : function(msg) {
							if (msg) {
								$("#name1_err").css("color", "green").html(
										"√用户名可以使用！");
								flag2 = true;
							} else {
								$("#name1_err").css("color", "red").html(
										"×此用户名太受欢迎！");
								flag2 = false;
							}
						}
					});
				}
			});
			var $code = $("input[name='code']");
			// 給這個對象添加事件函數和 鼠標丟失時間 -> blur
			$code.blur(function() {
				var code = $code.val();// 得到输入框的值
				// 为了防止出现有人使用空格欺骗问题
				code = code.replace("\\s\\g", "");
				// 判定
				if (code == null || code.length == 0) {
					$("#code_err").css("color", "red").html("x不能为空!");
					flag1 = false;
				} else {
					// 使用ajax进行异步测试
					$.ajax({
						url : "code",
						dataType : "json",
						data : {
							"code1" : code
						},
						success : function(msg) {
							if (msg) {
								$("#code_err").css("color", "green").html(
										"√输入正确!");
								flag1 = true;
							} else {
								$("#code_err").css("color", "red").html(
										"x输入错误!");
								flag1 = false;
							}
						}
					});
				}
			});
		});

/** 表单提交检查 * */
function f2() {
	$("input[name = 'code']").blur();
	$("input[name = 'username']").blur();
	$("input[name = 'nickname']").blur();
	$("input[name = 'pwd']").blur();
	$("input[name = 'age']").blur();
	$("input[name = 'phone']").blur();
	return flag1;
}
/** 鼠标点击切换验证马 * */
function f1() {
	// 得到验证码的承载对象
	//var v1 = document.getElementById("img_1");
	var $v1 = $("#img_1");
	// 2、切换验证码
	$v1.attr("src", "verify?time=" + new Date());
}