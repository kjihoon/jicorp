<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>




<div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
			  <!-- Alert MSG -->
			  <div class="alert alert-warning alert-dismissible fade show" role="alert">
					${msg}
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			  </div>
			  <!--/Alert MSG  -->
		</div>
	</div>
</div>
