<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


    <!-- Page Header -->
    <header class="masthead" style="background-image: url('${pageContext.request.contextPath}/resources/img/post-bg.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="post-heading">
              <h1>${content.TITLE }</h1>
              <h2 class="subheading" style="font-family: 'Nanum Pen Script', cursive;">Problems look mighty small from 150 miles up</h2>
              <span class="meta">Posted by
                <a href="#">${content.USER_ID }</a>
                <!-- on August 24, 2018 -->${content.LOAD_DATE }</span>
            </div>
          </div>
        </div>
      </div>
    </header>