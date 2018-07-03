<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>operator-add</title>
<style type="text/css">
	body{
		background:pink;
	}
	a{
		text-decoration:none;
	}
	a:hover{
		color:red;
	}
</style>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
	<h2>operator-add</h2>
	<fieldset>
		<legend>添加管理员</legend>
		<!--action为空意味着会提交到当前表单页面的路径-->
		<form action="" method="post">
			<label for="username">用户名：</label><input type="text" name="username" id="username">
			<label for="password">密　码：</label><input type="password" name="password" id="password">
			<button type="submit">添加</button>
		</form>
	
	</fieldset>
</body>
</html>