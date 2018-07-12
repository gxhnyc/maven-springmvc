<%@ tag language="java" pageEncoding="UTF-8"%>
<!-- 调用该tag时还需传参title以指定页面标题 -->
<%@ attribute name="title" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<title>${title}</title>
		<link href="${contextPath}/assets/css/add-error.css" rel="stylesheet">
		<style>
			.menu {
				display: inline-block;
			}
		</style>
	</head>
	<body>
	<div class="header">
		<ul class="menu">
			<li><a href="">图书管理</a></li>
			<li><a href="${contextPath }/books/">图书列表</a></li>
			<li><a href="${contextPath }/books/book-add">添加图书</a></li>
		</ul>
	
		<ul class="menu">
			<li><a href="">作者管理</a></li>
			<li><a href="${contextPath }/authors/">作者列表</a></li>
			<li><a href="${contextPath }/authors/author-add">添加作者</a></li>
		</ul>
	
		<ul class="menu">
			<li><a href="">出版社管理</a></li>
			<li><a href="${contextPath }/publishers/">出版社列表</a></li>
			<li><a href="${contextPath }/publishers/publisher-add">添加出版社</a></li>
		</ul>
	</div>
	<hr>
	<div class="content">
		<!-- 取tag参数值 -->
		<h2>${title }</h2>
		<!-- 把layout标签的内容插入到此处 -->
		<jsp:doBody></jsp:doBody>
	</div>
	<hr>
	<div class="footer">
		copyright@ 2018
	</div>
	
	
	</body>
</html>