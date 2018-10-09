<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<!-- Tail Writer Res -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/tail/tail_css/tail.writer.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/tail/tail_css/tail.writer.github.css">
	<script src="${pageContext.request.contextPath}/resources/tail/tail_js/marked.js"></script>
	<script src="${pageContext.request.contextPath}/resources/tail/tail_js/tail.writer.min.js"></script>
	
	
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


<!-- inner markdown res -->    
<style>
@import url(//https://fonts.googleapis.com/earlyaccess/nanumgothiccoding.css);
[name=md]{
	font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;

}
[name=md] pre{
	border-radius: 5px;
}
[name=md] code{
font-family: Courier, 'New Courier', monospace;
	font-size: 120%;
	line-height: 20px;
	font-weight: 500;
}    
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/highlight/styles/default.css">
<script src="${pageContext.request.contextPath}/resources/highlight/highlight.pack.js"></script>
<script>hljs.initHighlightingOnLoad();</script>    
<!-- /inner markdown res -->   

<title>JIHOONY</title>
</head>
<body>

	<jsp:include page="nav.jsp"></jsp:include>
	
	
	
	 <!-- center  -->
	 <c:choose>
	 	<c:when test="${center==null }">
	 		<jsp:include page="header.jsp"></jsp:include>
	 		<c:choose><c:when test="${msg!=null }"><jsp:include page="alert.jsp"></jsp:include></c:when></c:choose>
	 		<jsp:include page="main.jsp"></jsp:include>
	 	</c:when>
	 	<c:otherwise>
	 		<jsp:include page="${center}header.jsp"></jsp:include>
	 		<jsp:include page="${center}.jsp"></jsp:include>
	 	</c:otherwise>
	 </c:choose>

	<jsp:include page="footer.jsp"></jsp:include>
	
	
	
	<!-- Bootstrap core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
    <!-- Custom scripts for this template -->
    <script src="${pageContext.request.contextPath}/resources/js/clean-blog.min.js"></script>
	<script>
	
	
	$(document).ready(function(){
		//날짜 표기 처리
		var test =$(".load_date").toArray();
		for (var idx = 0 ; idx<test.length;idx++){
			var date = test[idx].innerText;
			var YYYY = date.substring(0,4);
			var MM 	 = date.substring(4,6);
			var dd   = date.substring(6,8);
			var hh   = date.substring(8,10);
			var mm   = date.substring(10,12);
			$(".load_date").eq(idx).text(YYYY+"."+MM+"."+dd+"  "+hh+":"+mm);	
		}
	});
	
	 // master check
	 var mastercheck= "${master}";
	 if (mastercheck!=""){
	    	$("[name=mastercheck]").show();
	 }else{
	    	$("[name=mastercheck]").hide();
	 }
	
	 //의견 보내기
	 $(".send_opinion").click(function(){
 		alert("kjihoon0914@naver.com");
 	})
 	
	</script>
</body>
</html>	