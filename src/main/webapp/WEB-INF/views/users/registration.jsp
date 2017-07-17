<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="${s:mvcUrl('UC#save').build() }" method="POST"
		commandName="user">
		<div>
			<label>Irmão</label>
			<form:select path="brother">
				<form:option value="NONE" label="--- Select ---" />
				<form:options items="${brothers}" />
			</form:select>
		</div>
		<div>
			<label>User Name</label>
			<form:input path="userName" />
			<form:errors path="userName" />
		</div>
		<div>
			<label>Password</label>
			<form:password path="password" />
			<form:errors path="password" />
		</div>
		<div>
			<label>Perfil</label>
			<form:select path="roles[0]">
				<form:option value="NONE" label="--- Select ---" />
				<form:options items="${roles}" />
			</form:select>
		</div>
		<button type="submit">Registrar</button>
	</form:form>

</body>
</html>