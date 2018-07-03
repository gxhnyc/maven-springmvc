<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book-Details</title>
<style type="text/css">
	body{
		background:url(../images/han01.jpg)  no-repeat;
	}
	a{
		text-decoration:none;
	}
	a:hover{
		color:red;
	}
</style>
</head>
<body>
	<h2>《${book.book_name}》</h2>
	<ul>
		<c:forEach items="${book.author}" var="author">
			<li>作者：<a>${author.author_name } </a>	</li>		
		</c:forEach>
	</ul>
	<ul>
		
			<li>出版社：<a>【${book.publisher.publisher_name } 】</a>	</li>		
		
	</ul>
</body>



</html>