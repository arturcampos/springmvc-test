<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalhes do usuário</title>
</head>
<body>
	<h1>Detalhes do usuário: ${user.userName}(${user.email }) </h1>

	<div>
		<label>User Name:</label>
		<form:input path="user.userName" disabled="true" />
	</div>
	<div>
		<label>Nome:</label>
		<form:input path="user.name"/>
	</div>
	<div>
		<label>E-mail:</label>
		<form:input path="user.email"/>
	</div>
</body>
</html>