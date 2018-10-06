<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


    
    


<style>
.list-group-item{
	padding: .3rem 1.25rem;
}
</style>
<div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
			  <!-- ARROW -->
			  	<div id="arrowlist" class="list-group">
			  	  <a href="${pageContext.request.contextPath}/main/index"><span style="font-size:130%;">글 목록</span></a>
			  	  
				  <a href="${pageContext.request.contextPath}/select/content?CONTENTS_IDX=${arrow.PREVIOUS_IDX}" class="list-group-item" id="previous_title">이전 글 - ${arrow.PREVIOUS}</a>
				  <a href="${pageContext.request.contextPath}/select/content?CONTENTS_IDX=${arrow.NEXT_IDX}" class="list-group-item" id="next_title">다음 글 - ${arrow.NEXT}</a>
				</div>
			  <!--/ARROW  -->
			  <hr>
		</div>
	</div>
	
</div>


<script>
	$("#arrowlist a").mouseover(function(){
		$(this).addClass("active");
	})
	$("#arrowlist a").mouseleave(function(){
		$(this).removeClass("active");
	})
	var checkNext = "${arrow.NEXT}";
	var checkPrevious = "${arrow.PREVIOUS}";
	if (checkNext=="없음"){
		$("#next_title").hide();
	}
	if (checkPrevious=="없음"){
		$("#previous_title").hide();
	}
	
</script>