<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

	<!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    
    <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	<link href="${pageContext.request.contextPath}/resources/vendor/font.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/clean-blog.min.css" rel="stylesheet">
	
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
    
    <title>JH's Tech Blog</title>
</head>
<body>

	<jsp:include page="nav.jsp"></jsp:include>
	
	
	
	 <!-- center  -->
	 <c:choose>
	 	<c:when test="${center==null }">
	 		<jsp:include page="header.jsp"></jsp:include>
	 		<jsp:include page="main.jsp"></jsp:include>
	 	</c:when>
	 	<c:otherwise>
	 		<jsp:include page="postheader.jsp"></jsp:include>
	 		<jsp:include page="post.jsp"></jsp:include>
	 	</c:otherwise>
	 </c:choose>

	<jsp:include page="footer.jsp"></jsp:include>
	
	
	
	<!-- Bootstrap core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="${pageContext.request.contextPath}/resources/js/clean-blog.min.js"></script>
	<script>
	$(document).ready(function(){
		if ("${msg}"!=""){
			alert("${msg}");
		}
	});	
	</script>
</body>
</html>	