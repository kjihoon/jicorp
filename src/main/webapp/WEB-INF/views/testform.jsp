<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/create/contents">
	TITLE<input type="text" name="TITLE"><br>
	TITLE_SUB<input type="text" name="TITLE_SUB"><br>
	USER_ID<input type="text" name="USER_ID"><br>
	CONTENT<input type="text" name="CONTENT"><br>
	<input type="submit" value="테스트">
</form>

</body>
</html>