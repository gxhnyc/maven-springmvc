<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>publisher-list</title>
<style type="text/css">
	body{
		text-align:left;
		margin-left: 500px;
		background:pink;
	}
	
	fieldset{
		
		width:550px;
		height:600px;
	}
	legend{text-align:center;}
	form{
		text-align:left;
	}
	
	a{
		text-decoration:none;
	}
	a:hover{
		color:red;
	}
	#publisher_brief{
		width:550px;
		height:500px;
	}
</style>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
	<h2>publisher-list(列出所有publisher)</h2>
	<fieldset>
		<legend>显示publishers</legend>
		<br><br><br>
		<!--action为空意味着会提交到当前表单页面的路径-->
		
		<c:forEach items="${publishers }" var="publisher">
		<!--<label for="publisher_name"> 当鼠标点击lable标签时，for属性对应的标签就会获得焦点  -->
			<label>出版社ID：</label><a>【${publisher.publisher_id }】</a>
			<label>出版社名：</label><a>【${publisher.publisher_name }】</a><br/>
			<label style="margin-left:85px">出版社简介：</label>
			<a>${publisher.publisher_brief }...</a><a href="${ contextPath}/publishers/${publisher.publisher_id}/edit">【编辑】</a>
			<a href="${ contextPath}/publishers/${publisher.publisher_id}/delete">【删除】</a>
			<br>
		</c:forEach>
	
	
	</fieldset>
</body>
</html>