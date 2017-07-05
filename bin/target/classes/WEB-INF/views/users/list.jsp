<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Lista de Usuários</h1>

		<div>${message}</div>
	<table>
		<tr>
			<td>User Name</td>
			<td>Nome</td>
			<td>E-mail</td>
		</tr>
		<c:forEach items="${users }" var="user">
		<tr>
			<td>${user.userName}</td>
			<td>${user.name}</td>
			<td>${user.email}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>