<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>publisher-edit</title>
<style type="text/css">
	body{
		margin:0px 500px;
		background:pink;
	}
	fieldset{
	
		width:450px;
		height:500px;
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
		width:400px;
		height:150px;
	}
	.add-error{
		background:yellow;
		color:red;
		font-weight:bold;
	}
</style>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
	<h2>publisher-edit</h2>
	<fieldset>
		<legend>添加books</legend>
		<br><br><br>
		<!--action为空意味着会提交到当前表单页面的路径-->
		<form:form action="" method="post" commandName="bookForm">
	
		<!--<label for="publisher_name"> 当鼠标点击lable标签时，for属性对应的标签就会获得焦点  -->
		
		<div>
			<label for="book_name">图书名称：</label>
			<form:input type="text" path="book_name" id="book_name"/>
			<form:errors path="book_name" cssClass="add-error"></form:errors>
		</div>	
		<div>
			<label for="book_brief">图书简介：</label>
			<form:input type="text" path="book_brief" id="book_brief"/>
			<form:errors path="book_brief" cssClass="add-error"></form:errors>
		</div>
		<div>
			<label for="author_ids">　作　者：</label>
			<form:select path="author_ids" id="author_ids" >
				 <form:option value="" label="--请选择作者--" />  
                 <form:options 	items="${authorsOptions}" 
                   				itemLabel="author_name" 
                   				itemValue="author_id"
                   				/>  
      		</form:select>
      		<form:errors path="author_ids" cssClass="add-error"></form:errors>
		</div>
		<div>
			<label for="publisher_id">　出版社：</label>
			<form:select path="publisher_id" id="publisher_id" >
			 	<form:option value="" label="--请选择出版社--" />
				<form:options items="${publisherOptions}" 
                   			  itemLabel="publisher_name" 
                   			  itemValue="publisher_id"
                   			  />
                   
      			</form:select>
			<form:errors path="publisher_id" cssClass="add-error"></form:errors>
		</div>
		
			<button type="submit">添加</button>
		</form:form>
	
	</fieldset>
</body>
</html>