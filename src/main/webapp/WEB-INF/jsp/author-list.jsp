<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Author-add</title>
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
	<h2>Author-add</h2>
	<ul>
		<c:forEach items="${authors}" var="author">
			<li>#${author.author_id} : <a href="${contextPath }/authors/author-details/${author.author_id}">${author.author_name}【${author.author_gender }】</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>