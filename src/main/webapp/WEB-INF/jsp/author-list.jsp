<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Author-list</title>
<link href="${contextPath}/assets/css/add-error.css" rel="stylesheet">
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
	<h2>Author-list</h2>
	<ul>
		<c:forEach items="${authors}" var="author">
			<li>#${author.author_id} : <a href="${contextPath }/authors/${author.author_id}/author-details"></a><a>【${author.author_name}】</a><a>【${author.author_gender }】</a>
			<a href="${contextPath }/authors/${author.author_id}/author-edit">【编辑】</a><a href="${contextPath }/authors/${author.author_id}/author-delete">【删除】</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>