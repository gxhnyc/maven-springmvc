<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Author-Details</title>
<link href="${contextPath}/assets/css/add-error.css" rel="stylesheet">
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
	<h2>Author-Details</h2>
	<a>${author.author_brief }</a>
	<ul>
		<c:forEach items="${author.books}" var="book">			
			<li>#${book.book_id} </li>
			<li> 《${book.book_name}》</li>
			<li>【${book.publisher.publisher_name }	】</li>			
		</c:forEach>
	</ul>
</body>
</html>