<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


    <!-- Page Header -->
    <header class="masthead" style="background-image: url('${pageContext.request.contextPath}/resources/${thumbNail }')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="post-heading">
              <h1>${content.TITLE }</h1>
              <h2 class="subheading" style="font-family: 'Nanum Pen Script', cursive;">
				${content.TITLE_SUB }
              </h2>
              <span class="meta">Posted by
                <a href="#">${content.USER_ID }</a>
                <!-- on August 24, 2018 --><span class="load_date">${content.LOAD_DATE }</span></span>
            </div>
          </div>
        </div>
      </div>
    </header>