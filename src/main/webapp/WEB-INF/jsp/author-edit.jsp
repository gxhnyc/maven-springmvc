<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<c:set var="title" value="${(author.author_name==null||author.author_name=='')?'添加作者':'修改作者' }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title}</title>
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
	
	.field-error{
		margin-left:10px;
		color:yellow;
		font-weight:bold;
		
	}
</style>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
	<h2>${title}</h2>
	<fieldset>
		<legend>${title}</legend>
		<!--action为空意味着会提交到当前表单页面的路径-->
		<!-- commandName指定表单bean的model名 -->
		<form:form action="" method="post" commandName="author">
		<!-- path指定该字段对应的pojo属性名 -->
			<div>
				<label for="author_name">用户名：</label>
				<form:input type="text" path="author_name" id="author_name"/>
				<!-- cssClass给错误消息标签加class="field-error"以便应用校验错误样式 -->
				<form:errors path="author_name" cssClass="field-error"></form:errors>
			</div>
			<div>
				<label for="author_gender">性　别：</label>	
				<!-- 注意：单选按钮组的name应该一样，并且value要指定为枚举名 -->
				<!-- 注意: 单选按钮不是<input type="radio"/>,而是radiobutton -->		
				<form:radiobutton path="author_gender" value="Male"/>男
				<form:radiobutton path="author_gender" value="Female"/>女
				<form:errors path="author_gender" cssClass="field-error"></form:errors>
			</div>
			<div>
				<label for="author_brief">简　介：</label>
				<form:textarea path="author_brief" id="author_brief"/>
				<form:errors path="author_brief" cssClass="field-error"></form:errors>
			</div>
			<button type="submit">提交</button>
		</form:form>
	
	</fieldset>
</body>
</html>