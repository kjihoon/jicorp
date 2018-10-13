<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>
#mainList img{
	padding: 20px 20px 20px 20px;
	height: 200px;
}
#mainList:hover {
    box-shadow: 0 0 2px 1px rgba(0, 140, 186, 0.5);
}
</style>
    <!-- Main Content -->
    <div class="container">
    
	
      <div class="row">
        
		
        <div class="col-lg-8 col-md-10 mx-auto">
        
		
          <!-- contents view using loof -->
          <c:forEach items="${contents }" var="content">
          <div class="row" id="mainList">
         	 <img src="${content.THUMBNAIL}" class="col-5">
          <div class="col-7">           
          <div class="post-preview">
            <a href="${pageContext.request.contextPath}/select/content?CONTENTS_IDX=${content.CONTENTS_IDX}">
              <h3 class="post-title">
                ${content.TITLE }
              </h3>
              <h4 class="post-subtitle" style="font-family: 'Nanum Pen Script', cursive;">
				${content.TITLE_SUB }
              </h4>
            </a>
            <p class="post-meta">Posted by
              <a href="#">${content.USER_ID }</a>
              <!-- on September 24, 2018 --><span class="load_date">${content.LOAD_DATE }</span></p>
          </div>
          </div>
          </div>
          <hr>
          </c:forEach>

			<nav aria-label="Page navigation example">
			  <ul class="pagination justify-content-center">
			    <li class="page-item" id="prevIdx">
			      <a class="page-link" href="#" >Previous</a>
			    </li>

			    <li class="page-item" id="nextIdx">
			      <a class="page-link" href="#">Next</a>
			    </li>
			  </ul>
			</nav>


          <!-- Pager -->
          <div class="clearfix">
            <a name="mastercheck" class="btn btn-primary float-right" href="${pageContext.request.contextPath}/load/contents">POST</a>
          </div>
        </div>
      </div>
    </div>
    <hr>
    
    <script>
    var page = parseInt("${page}");
    var count = "${contentlen}";
    count = parseInt(count)/3;
    count = count > parseInt(count) ? parseInt(count)+1 : parseInt(count); 
    for (var i = 0 ; i<count;i++){
    	 if (page==i){
    		var inner = "<li class='page-item disabled'><a class='page-link' href='${pageContext.request.contextPath}/main/index?page="+i+"'>"+i+"</a></li>";
    	 }else{
    		 var inner = "<li class='page-item'><a class='page-link' href='${pageContext.request.contextPath}/main/index?page="+i+"'>"+i+"</a></li>";
    	 }
    	 $("#nextIdx").before(inner);
    }
    $("#prevIdx a").attr("href","${pageContext.request.contextPath}/main/index?page="+(page-1));
    $("#nextIdx a").attr("href","${pageContext.request.contextPath}/main/index?page="+(page+1));
    if (page ==0){
    	$("#prevIdx").addClass("disabled");
    }else if (page>=count-1){
    	$("#nextIdx").addClass("disabled");
    }
   
    
    </script>   